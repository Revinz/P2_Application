package aau.g202.p2_gesturebasedinteraction;

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
    private static float pitchLowSpeedAngle;
    private static float pitchHighSpeedAngle;
    private static float rollLowSpeedAngle;
    private static float rollHighSpeedAngle;


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

        //Get accelerometer values
        float pitch = Accelerometer.getX();
        float roll = Accelerometer.getY();

        //Check for low speed on the pitch
        if (pitch >= pitchLowSpeedAngle && pitch < pitchHighSpeedAngle)
            x += pitchLowSpeed;
        else if (pitch <= -pitchLowSpeedAngle && pitch > pitchHighSpeedAngle)
            x -= pitchLowSpeed;

        //TODO (Patrick): Add the rest of the speed angles
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
