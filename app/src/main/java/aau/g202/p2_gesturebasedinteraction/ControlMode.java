package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.util.Log;
import android.view.View;
import android.content.Context;

public class ControlMode{

   enum Mode {
        SCROLLMODE,
        SELECTMODE,
    }

    static Mode currMode = Mode.SELECTMODE;
    private static float[] Pivot = new float[3];

    void TurnOnOff(){

    }

    void SwitchMode(){
        if (currMode == Mode.SELECTMODE) {
            currMode = Mode.SCROLLMODE;
        }
        else if (currMode == Mode.SCROLLMODE){
            currMode = Mode.SELECTMODE;
        }
    }

    void ResetPivot(){
        Pivot = Accelerometer.getXYZ();
    }


}
