package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.opengl.GLES32;
import android.os.Debug;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public abstract class ControlMode
{

   enum Mode {
        SCROLLMODE,
        SELECTMODE,
    }

    static Mode currMode = Mode.SELECTMODE;
    private static float[] Pivot = new float[3];
    private static float x,y; //Position of the cursor

    private static boolean isStarted = true; //whether or not the gesture based navigation is started

    // Overlay
    static WindowManager windowManager;
    static WindowManager.LayoutParams params;
    static ImageView testImage;

    //Hold the activity running the ControlMode.
    //Used to update on the UI thread.
    private Activity activity;
    private static Process shellADB;

    //Makes a timer and a task that gets executed at a fixed rate.
    // https://stackoverflow.com/questions/4597690/android-timer-how-to
    Timer updateTimer = new Timer();
    private static int updateRate = 1; //in millis
    TimerTask updateTask = new TimerTask() {
        @Override
        public void run() {
            // Update on the UI thread, otherwise it will crash.
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

        //Create the view and it's dispatchKeyEvent to listen to keys being pressed.
        // More info here: https://developer.android.com/reference/android/view/View.html#dispatchKeyEvent(android.view.KeyEvent)
        // In short, it sends the key events forward to the next view in the "view tree" down to
        // the view in focus.
        testImage = new ImageView(c) //"Should" -- not an error even tho it is marked as an error
        {
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                if (event.getKeyCode()==KeyEvent.KEYCODE_VOLUME_DOWN) {
                    return true;
                }
                return super.dispatchKeyEvent(event);
            }
        };

        testImage.setImageResource(R.drawable.ic_launcher_foreground);
        windowManager.addView(testImage, params);

    }


}