package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by mgh76 on 25-04-2018.
 */

public class Lightsensor implements SensorEventListener {

    private final SensorManager LightSensorManager;
    private final Sensor LightSensor;
    private float lx;
    private TextView LightReadings;

    public Lightsensor(Context context) {

        //Gets sensortype and listener
        LightSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        LightSensor = LightSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        LightSensorManager.registerListener(this,LightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        lx = event.values[0];
        if(lx < 15)
        {
            //DO STUFF
        }
        else
        {}

        //Log.w("Light Level",  Float.toString(lx));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
