package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ControlMode
{

   enum Mode {
        SCROLLMODE,
        SELECTMODE,
    }

    static Mode currMode = Mode.SELECTMODE;
    static float pivotPitch;
    static float pivotRoll;

    private static boolean isStarted = true; //whether or not the gesture based navigation is started

    // Overlay
    static WindowManager windowManager;
    static WindowManager.LayoutParams params;
    static ImageView testImage;

    //Hold the activity running the ControlMode.
    //Used to update on the UI thread.
    private Activity activity;
    public static View currView;
    public static Context c;

    public static Activity currActivity;

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

    ControlMode(Context _c, Activity a) {
        activity = a;
        c = _c;

        //Set the fixed update rate for the timer
        updateTimer.scheduleAtFixedRate(updateTask, 0, updateRate);


    }


    void SwitchMode(){
        if (currMode == Mode.SELECTMODE) {
            RemoveOverlay();
            currMode = Mode.SCROLLMODE;
        }
        else if (currMode == Mode.SCROLLMODE){
            SetOverlay(c);
            currMode = Mode.SELECTMODE;
        }
    }

    public static void ResetPivot(){

        pivotPitch = Accelerometer.getY();
        pivotRoll = Accelerometer.getX();
    }

    abstract void Update();

    //Removes the overlay
    public static void RemoveOverlay() {
        windowManager.removeView(testImage);
    }

    public static void SetOverlay(Context c) {
        //Setup the window manager
        windowManager = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);

        int flag;

        //Setup the layout params
        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE, //TODO: Change back to TYPE_APPLICATION_OVERLAY
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, //Make it not be touchable, make it register touches outside the view itself (cursor), and allow the window to extend to anywhere
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
    
        //Create the view and it's dispatchKeyEvent to listen to keys being pressed.
        // More info here: https://developer.android.com/reference/android/view/View.html#dispatchKeyEvent(android.view.KeyEvent)
        // In short, it sends the key events forward to the next view in the "view tree" down to
        // the view in focus.
        testImage = new android.support.v7.widget.AppCompatImageView(c)
        {
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {

                Log.w("event", event.toString());

                if (event.getKeyCode()== KeyEvent.KEYCODE_VOLUME_DOWN && event.getAction() == KeyEvent.ACTION_UP) {
                    Log.w("VOUME DOW!", "WRKKING");
                    if (currActivity != null)
                        SelectMode.select();

                    return true;
                }

                //Make the back button work with the app
                if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP){
                    currActivity.finish();
                    return true;
                }


                return super.dispatchKeyEvent(event);
            }
        };

        testImage.setImageResource(R.drawable.tempcursor);
        windowManager.addView(testImage, params);

    }

    void hideOverlay() {
        testImage.setVisibility(View.GONE);
    }

    void showOverlay() {
        testImage.setVisibility(View.VISIBLE);
    }


}