package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.util.Log;
import android.view.View;

public class ControlMode{

   enum Mode {
        SCROLLMODE,
        SELECTMODE,
    }

    static Mode currMode = Mode.SELECTMODE;
    boolean CURRMODE = true;
    //static Sensor[] sensors;
    private static double Pivot; //Maybe make an angle class to calculate the angle


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

    }




}
