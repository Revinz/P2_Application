package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.TimerTask;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class SelectMode extends ControlMode {

    //Used for constraining the cursor inside the application window
    private static float statusBarHeight = 72; //pixels
    private static float bottomBarHeight = 130;

    // Center the cursor at start
    private static float x = getScreenWidth() / 2;
    private static float y = (getScreenHeight() - bottomBarHeight - statusBarHeight)/2 ; //24 is the height of the status bar, 48 is the height of the bottom bar

    //Used to get the correct touch positon
    private static float yPadding = statusBarHeight + 5; // 5 for the pixel image center
    private static float xPadding = 5; // 5 for the pixel image center

    //Different speed levels for pitch and roll tilting of the phone
    private static float pitchLowSpeed = 3f;
    private static float pitchHighSpeed = 6f;
    private static float rollLowSpeed = 3f;
    private static float rollHighSpeed = 6f;

    //The angles to engage the different speed levels, in accelerometer values from -9.89 to 9.89.
    private static float pitchLowSpeedAngle = 2f;
    private static float pitchHighSpeedAngle = 4f;
    private static float rollLowSpeedAngle = 2f;
    private static float rollHighSpeedAngle = 4f;

    private static float dampening = 10;

    public static int getScreenWidth()
    {return Resources.getSystem().getDisplayMetrics().widthPixels;}

    public static int getScreenHeight()
    {return Resources.getSystem().getDisplayMetrics().heightPixels;}

    SelectMode(Context c, Activity a) {
        super(c, a);
        SetOverlay(c);
        //RetrieveSettings();

    }

    public static void RetrieveSettings() {
        pitchLowSpeed = CursorLayout.getlowSpeedY_cursor(c);
        pitchHighSpeed = CursorLayout.gethighSpeedY_cursor(c);
        pitchLowSpeedAngle = CursorLayout.getlowAngleY_cursor(c);
        pitchHighSpeedAngle = CursorLayout.gethighAngleY_cursor(c);

        rollLowSpeed = CursorLayout.getlowSpeedX_cursor(c);
        rollHighSpeed = CursorLayout.gethighSpeedX_cursor(c);
        rollLowSpeedAngle = CursorLayout.getlowAngleX_cursor(c);
        rollHighSpeedAngle = CursorLayout.gethighAngleX_cursor(c);
        //TODO (Patrick): Retrieve the settings from the settings file
    }

    public static void select(){

        if (currMode != Mode.SELECTMODE)
            return;

        //Check if the user selected the back button
        if (x >= 200 && x <= 450 && y >= 1800 - bottomBarHeight && y <= getScreenHeight() - bottomBarHeight)
        {
            currActivity.onBackPressed();
            Log.w("BACK BUTTON", "BACKBUTTON");
            return;
        }

        long downTime = SystemClock.uptimeMillis();
        long eventTime = SystemClock.uptimeMillis();

        int action = MotionEvent.ACTION_DOWN;
        int metaState = 0;

        MotionEvent event = MotionEvent.obtain(downTime, eventTime, action, x +xPadding, y + yPadding, metaState);

        currActivity.dispatchTouchEvent(event);

        downTime = SystemClock.uptimeMillis();
        eventTime = SystemClock.uptimeMillis() + 100;
        action = MotionEvent.ACTION_UP;

        event = MotionEvent.obtain(downTime, eventTime, action, x+xPadding, y+yPadding, metaState);

        currActivity.dispatchTouchEvent(event);

    }

    void longSelect(){}

    void drag(){}

    //Used to limit the input for setting / getting the speed values
    enum Speed {
        PITCH_LOW,
        PITCH_HIGH,
        ROLL_LOW,
        ROLL_HIGH
    }

    //Updates the cursors' position
    public void Update() {

        //only update if the current mode is select mode
        if (currMode != Mode.SELECTMODE)
            return;

        //Get accelerometer values and reverse them
        float pitch = Accelerometer.getY();
        float roll = Accelerometer.getX() * -1; //Reverse it to the the proper direction

        //Gets the angle of the phone -- in negative or positive radians up to 1 PI
        // Based on the testing
        double angle = Math.atan2(pitch, roll);

        // If it is outside the ellipse, move the cursor.
        if (CheckIfOutsideEllipse(roll, pitch,  pitchHighSpeedAngle, rollHighSpeedAngle)) {
            //Get the angle of the phone and move the cursor in that direction.
            y += pitchHighSpeed * Math.sin(angle) / dampening;
            x += rollHighSpeed * Math.cos(angle) / dampening;
        }

        else if (CheckIfOutsideEllipse(roll, pitch, pitchLowSpeedAngle, rollLowSpeedAngle))
        {
            //Get the angle of the phone and move the cursor in that direction.
            y += pitchLowSpeed * Math.sin(angle)  / dampening;
            x += rollLowSpeed * Math.cos(angle) / dampening;
        }


        //Constrain the cursor's position to be inside the application window
        if (x > getScreenWidth() - 20)
            x = getScreenWidth() - 20;

        if (y > getScreenHeight())
            y =  getScreenHeight();

        if (x < 0)
            x = 0;

        if (y < 0)
            y = 0;


        //Update the location of the cursor
        params.x = (int)x;
        params.y = (int)y;

        if (testImage != null)
            windowManager.updateViewLayout(testImage, params);

        //Log.w("X", Float.toString(x));
        //Log.w("Y", Float.toString(y));


    }
    // More info about calculating ellipses at:
    // https://math.stackexchange.com/questions/76457/check-if-a-point-is-within-an-ellipse

    // Checks if the given point is outside the ellipse that is given by the angles
    private boolean CheckIfOutsideEllipse(float x, float y, float pitchAngle, float rollAngle) {
        //Test the point of the pitch and roll values o the required angles
        // Since the angles can be different we are calculating an ellipse instead of a circle
        // Note: We are using the angle values as radii for the ellipses
        float yAxis = (y * y) / (pitchAngle * pitchAngle);
        float xAxis = (x * x) / (rollAngle * rollAngle);

        //Add the two axises together and find the square root
        double ellipseRadius = Math.sqrt(yAxis + xAxis);

        // If it is outside the ellipse, return true
        if (ellipseRadius > 1) //The point is inside the ellipse if it is below 1.
        {
            return true;
        }

        return false;
    }


    /********************* Getters / setter *******************/

    //Sets the specified speed speed to the new value
    public static void setSpeedLevel(Speed _speed, float _amount){
        switch (_speed){
            case PITCH_LOW:
                pitchLowSpeed = _amount;
                break;

            case PITCH_HIGH:
                pitchHighSpeed = _amount;
                break;

            case ROLL_LOW:
                rollLowSpeed = _amount;
                break;

            case ROLL_HIGH:
                rollHighSpeed = _amount;
                break;
        }
    }

    //Sets the angle for the specified speed to the new value
    public static void setSpeedAngle(Speed _speed, float _amount) {
        switch (_speed){
            case PITCH_LOW:
                pitchLowSpeedAngle = _amount;
                break;

            case PITCH_HIGH:
                pitchHighSpeedAngle = _amount;
                break;

            case ROLL_LOW:
                rollLowSpeedAngle = _amount;
                break;

            case ROLL_HIGH:
                rollHighSpeedAngle = _amount;
                break;
        }

    }


    //Gets the specified speed
    public static float getSpeedLevel(Speed _speed){
        switch (_speed){
            case PITCH_LOW:
                return pitchLowSpeed;

            case PITCH_HIGH:
                return pitchHighSpeed;

            case ROLL_LOW:
                return rollLowSpeed;

            case ROLL_HIGH:
                return rollHighSpeed;
        }

        //Will never be reached but mandatory
        return 0;
    }

    //gets the specified speed
    public static float setSpeedAngle(Speed _speed) {
        switch (_speed){
            case PITCH_LOW:
                return pitchLowSpeedAngle;

            case PITCH_HIGH:
                return pitchHighSpeedAngle;

            case ROLL_LOW:
                return rollLowSpeedAngle;

            case ROLL_HIGH:
                return rollHighSpeedAngle;
        }

        //Will never be reached but mandatory
        return 0;
    }



}
