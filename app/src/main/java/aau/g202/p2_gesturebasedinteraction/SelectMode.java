package aau.g202.p2_gesturebasedinteraction;

import android.util.Log;

import java.util.TimerTask;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class SelectMode extends ControlMode {

    private static float x,y;

    //Different speed levels for pitch and roll tilting of the phone
    private static float pitchLowSpeed = 4;
    private static float pitchHighSpeed = 8;
    private static float rollLowSpeed = 4;
    private static float rollHighSpeed = 8;

    //The angles to engage the different speed levels, in accelerometer values from -9.89 to 9.89.
    private static float pitchLowSpeedAngle = 2;
    private static float pitchHighSpeedAngle = 4.5f;
    private static float rollLowSpeedAngle = 2;
    private static float rollHighSpeedAngle = 4.5f;


    SelectMode() {
        //TODO (Patrick): Retrieve the settings from the settings file
    }

    //image cursor;

    void select(){}

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
        float pitch = Accelerometer.getY() * -1;
        float roll = Accelerometer.getX() * -1;

        Log.w("Pitch", Float.toString(pitch));
        Log.w("Roll", Float.toString(roll));


        //Check for low speed on the pitch
        if (pitch >= pitchLowSpeedAngle && pitch < pitchHighSpeedAngle)
            x += pitchLowSpeed;
        else if (pitch <= -pitchLowSpeedAngle  && pitch > -pitchHighSpeedAngle)
            x -= pitchLowSpeed;

        //Check for high speed on the pitch
        else if (pitch >= pitchHighSpeed)
            x += pitchHighSpeed;
        else if (pitch <= -pitchHighSpeedAngle)
            x -= pitchHighSpeed;

        //Check for low speed on the roll
        if (roll >= rollLowSpeedAngle && roll < rollHighSpeedAngle)
            y += rollLowSpeed;
        else if (roll <= -rollLowSpeedAngle  && roll > -rollHighSpeedAngle)
            y -= rollLowSpeed;

        //Check for high speed on the roll
        else if (roll >= rollHighSpeedAngle)
            y += rollHighSpeed;
        else if (roll <= -rollHighSpeedAngle)
            y -= rollHighSpeed;


        Log.w("X", Float.toString(x));
        Log.w("Y", Float.toString(y));
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
