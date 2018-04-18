package aau.g202.p2_gesturebasedinteraction;
import android.hardware.*;

/**
 * Created by jp93 on 18-Apr-18.
 */

public abstract class sensors implements SensorEventListener
{
    float lastUotput;
    float output;

    public float Getsenss()
    {
        return 0;
    }

    public float ReadSensor()
    {
        return 0;
    }
    private void smoothenOutput()
    {

    }
    
}
