package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.TimerTask;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class SelectMode extends ControlMode {

    private static float x,y;

    //Different speed levels for pitch and roll tilting of the phone
    private static float pitchLowSpeed = 0.5f;
    private static float pitchHighSpeed = 0.5f;
    private static float rollLowSpeed = 0.5f;
    private static float rollHighSpeed = 0.5f;

    //The angles to engage the different speed levels, in accelerometer values from -9.89 to 9.89.
    private static float pitchLowSpeedAngle = 1.5f;
    private static float pitchHighSpeedAngle = 4.7f;
    private static float rollLowSpeedAngle = 1.3f;
    private static float rollHighSpeedAngle = 4.1f;


    SelectMode(Context c, Activity a) {
        super(c, a);
        //TODO (Patrick): Retrieve the settings from the settings file
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //image cursor;

    public static void select(){

        // Obtain MotionEvent object
        long downTime = SystemClock.uptimeMillis();
        long eventTime = SystemClock.uptimeMillis() + 100;
// List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
        int metaState = 0;
        MotionEvent motionEvent = MotionEvent.obtain(
                downTime,
                eventTime,
                MotionEvent.ACTION_UP,
                x,
                y,
                metaState
        );

// Dispatch touch event to view
        testImage.dispatchTouchEvent(motionEvent);
        Log.w("Select", "Dispatched");

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
        // They are opposite in the accelerometer and we reverse them back
        float pitch = Accelerometer.getY();
        float roll = Accelerometer.getX() * -1;

        //Log.w("Pitch", Float.toString(pitch));
        //Log.w("Roll", Float.toString(roll));


        //Check for low speed on the pitch
        if (pitch >= pitchLowSpeedAngle && pitch < pitchHighSpeedAngle)
            y += pitchLowSpeed;
        else if (pitch <= -pitchLowSpeedAngle  && pitch > -pitchHighSpeedAngle)
            y -= pitchLowSpeed;

        //Check for high speed on the pitch
        else if (pitch >= pitchHighSpeedAngle)
            y += pitchHighSpeed;
        else if (pitch <= -pitchHighSpeedAngle)
            y -= pitchHighSpeed;

        //Check for low speed on the roll
        if (roll >= rollLowSpeedAngle && roll < rollHighSpeedAngle)
            x += rollLowSpeed;
        else if (roll <= -rollLowSpeedAngle  && roll > -rollHighSpeedAngle)
            x -= rollLowSpeed;

        //Check for high speed on the roll
        else if (roll >= rollHighSpeedAngle)
            x += rollHighSpeed;
        else if (roll <= -rollHighSpeedAngle)
            x -= rollHighSpeed;


        //Log.w("X", Float.toString(x));
        //Log.w("Y", Float.toString(y));

        //Update the location of the cursor
        params.x = (int)x;
        params.y = (int)y;

        if (testImage != null && params != null)
            windowManager.updateViewLayout(testImage, params);


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
