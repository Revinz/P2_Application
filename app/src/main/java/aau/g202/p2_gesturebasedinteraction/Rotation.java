package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Bruger on 25-04-2018.
 */

public class Rotation extends sensor implements SensorEventListener{

    private SensorManager mgr;
    private Sensor accelerometer;
    private TextView text;
    private float[] gravity = new float[3];
    private float[] motion = new float[3];
    public double ratio;
    public double mAngle;
    private int counter = 0;

    Rotation(Context context){
        mgr = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        accelerometer = mgr.getDefaultSensor(Sensor.TYPE_ALL);
        mgr.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {



        Log.w("Degrees:", Double.toString(mAngle)); //Output mAngle to LogCat
    }



}
