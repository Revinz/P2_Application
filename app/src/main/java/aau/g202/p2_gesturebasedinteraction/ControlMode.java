package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.os.HandlerThread;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.util.Log;
import android.view.View;
import android.content.Context;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public abstract class ControlMode{

   enum Mode {
        SCROLLMODE,
        SELECTMODE,
    }

    static Mode currMode = Mode.SELECTMODE;
    private static float[] Pivot = new float[3];
    private static float x,y; //Position of the cursor

    //Makes a timer and a task that gets executed at a fixed rate.
    // https://stackoverflow.com/questions/4597690/android-timer-how-to
    Timer updateTimer = new Timer();
    private static int updateRate = 1000; //in millis
    TimerTask updateTask = new TimerTask() {
        @Override
        public void run() {
            Update();
            Log.w("NEW UPDATE", "--------");
        }
    };

    ControlMode() {
        //Set the fixed update rate for the timer
        updateTimer.scheduleAtFixedRate(updateTask, 0, updateRate);
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



    abstract void Update();

}
