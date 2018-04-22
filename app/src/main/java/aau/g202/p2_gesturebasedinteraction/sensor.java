package aau.g202.p2_gesturebasedinteraction;
import android.hardware.*;

/**
 * Created by jp93 on 18-Apr-18.
 */

public abstract class sensor implements SensorEventListener
{
    float lastOutput;
    float output;

    public float GetSensor()
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
