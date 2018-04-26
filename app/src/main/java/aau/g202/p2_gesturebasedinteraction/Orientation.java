package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

import java.util.Vector;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Bruger on 25-04-2018.
 */

public class Orientation extends sensor implements SensorEventListener{

    private SensorManager manager;
    private Sensor accelerometer;
    private Sensor MagneticSensor;
    private Sensor gravitySensor;

    public Double[] Angles = new Double[3];


    float[] gravity = new float[3];
    float[] geomagneticField = new float[3];
    float[] rotationMatrix = new float[9];

    int counter = 0;


    Orientation(Context context){
        manager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        MagneticSensor = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        gravitySensor = manager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        manager.registerListener(this, MagneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
        manager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {

        //Update the values for the gravity sensor and magnetic field sensor
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            gravity = event.values;

        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            geomagneticField = event.values;

        if (gravity != null && geomagneticField != null) {
            boolean success = SensorManager.getRotationMatrix(rotationMatrix, null, gravity, geomagneticField);

            if (success) {

                float orientation[] = new float[3];

                manager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_Y, SensorManager.AXIS_MINUS_X, rotationMatrix);
                SensorManager.getOrientation(rotationMatrix, orientation);

                //Update the angle values
                for (int i = 0; i < 3; i++){
                    double temp = orientation[i];
                    //Angles[i] = temp;
                    Angles[i] = Math.toDegrees(temp); // convert the counterclockwise rotation to clockwise rotation

                }



            }
        }

        Angles[0] = (double)0;

        if (Angles[0] != null && counter % 50 == 0) {

            Log.w("Degrees azimuth", Double.toString(Angles[0])); //Output mAngle to LogCat
            Log.w("Degrees pitch", Double.toString(Angles[1])); //Output mAngle to LogCat
            Log.w("Degrees roll", Double.toString(Angles[2])); //Output mAngle to LogCat
        }

        counter++;

        //Reset counter to prevent crash
        if (counter > 10000000)
            counter = 0;

    }



}
