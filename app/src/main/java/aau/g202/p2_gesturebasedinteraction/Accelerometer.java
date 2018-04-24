package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by mgh76 on 18-04-2018.
 */

public class Accelerometer extends sensor implements SensorEventListener {

private final SensorManager AcSensorManager; //Only -ONE- sensormanager for accelerometer
private final Sensor AcSensor; //Only -ONE- instance of the sensor
private float x, y, z;


    public Accelerometer(Context context) {
        AcSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        AcSensor = AcSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        AcSensorManager.registerListener(this,AcSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public String toString() {
    String readings = "x is " + this.x + "  y is " + this.y + "  z is " + this.z;
        return readings;
    }

    @Override
    public void onSensorChanged(SensorEvent event) { //When sensor value changes, do this.
        //X Y Z are in SI units(m/s^2), and represent acceleration minus Gz on the assigned axis
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        if(x > 0) {
            //MOVE CURSOR STUFF}
        }
        if(y > 0) {
            //MOVE CURSOR STUFF
        }
        if (z > 0) {
            //MOVE CURSOR STUFF
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        //WHAT DO WE DO WHEN ACCURACY CHANGES? :O
    }

    public void resetAxes() //Resets the three axes.
    {x = 0; y = 0; z = 0;}

    //The below are getter & setter methods.
    public float getX() {return x;}

    public void setX(float x) {this.x = x;}

    public float getY() {return y;}

    public void setY(float y) {this.y = y;}

    public float getZ() {return z;}

    public void setZ(float z) {this.z = z;}

}
