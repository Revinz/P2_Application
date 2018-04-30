package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.util.Log;
import android.view.View;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public abstract class ControlMode extends Service{

   enum Mode {
        SCROLLMODE,
        SELECTMODE,
    }

    static Mode currMode = Mode.SELECTMODE;
    private static float[] Pivot = new float[3];
    private static float x,y; //Position of the cursor

    private static boolean isStarted = true; //whether or not the gesture based navigation is started

    public static WindowManager windowManager;
    public static WindowManager.LayoutParams params;
    public static ImageView testImage;

    public Activity activity;

    //Makes a timer and a task that gets executed at a fixed rate.
    // https://stackoverflow.com/questions/4597690/android-timer-how-to
    Timer updateTimer = new Timer();
    private static int updateRate = 1; //in millis
    TimerTask updateTask = new TimerTask() {
        @Override
        public void run() {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Update();
                    //Log.w("NEW UPDATE", "--------");
                }
            });
        }
    };

    ControlMode(Context c, Activity a) {
        activity = a;

        //Set the fixed update rate for the timer
        updateTimer.scheduleAtFixedRate(updateTask, 0, updateRate);

        SetOverlay(c);

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

    //Removes the overlay
    public static void RemoveOverlay() {
        windowManager.removeView(testImage);
    }

    public static void SetOverlay(Context c) {
        //Setup the window manager
        windowManager = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);

        //Setup the layout params
        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.CENTER;

        testImage = new ImageView(c);
        testImage.setImageResource(R.drawable.ic_launcher_foreground);

        windowManager.addView(testImage, params);
    }

}