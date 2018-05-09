package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;
import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by mgh76 on 18-04-2018.
 *
 * Code to give the accelerometer readings in the x,y,z axes as well as display them.
 *
 */

public class Accelerometer implements SensorEventListener {

private final SensorManager AcSensorManager; //Only -ONE- sensormanager for accelerometer
private final Sensor AcSensor; //Only -ONE- instance of the sensor
private static float x, y, z; //Acceleration in x, y, z axes

//The below contains code for the accelerometer class object.
    public Accelerometer(Context context) { //Main class object

        //Gets sensortype and listener.
        AcSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        AcSensor = AcSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        AcSensorManager.registerListener(this,AcSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public String toString() {
    String readings = "x:" + this.x + "\ny:" + this.y + "\nz:" + this.z;
        return readings;
    }

    boolean hasPivot = false;
    @Override
    public void onSensorChanged(SensorEvent event) { //When sensor value changes, do this.
        //X Y Z are in SI units(m/s^2), and represent acceleration minus Gz on the assigned axis
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        if (!hasPivot) {
            hasPivot = true;
            ControlMode.ResetPivot();
        }
        //Output readings to console
        //Log.v("Roll", Float.toString(x));
        //Log.v("pitch", Float.toString(y));
        //Log.v("Z", Float.toString(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        //Nothing to do here for us.
    }

    public void resetAxes() //Resets the three axes.
    {x = 0; y = 0; z = 0;}

    //The below are getter & setter methods.

    // Gets the X -- pitch
    public static float getX() {return x;}

    public void setX(float x) {this.x = x;}

    //Gets the Y -- roll
    public static float getY() {return y;}

    public void setY(float y) {this.y = y;}

    public static float getZ() {return z;}

    public void setZ(float z) {this.z = z;}

    //Returns all the 3 axis values as an array
    public static float[] getXYZ() {
        return new float[] {getX(), getY(), getZ()};
    }
}