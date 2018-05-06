//Pseudcode
/*
*make a fake touch that acts like a finger swiping up or down*
check if the scrollMode is true or false;
use the sensor output to determine x and y ;
make the touch event;
make an update that makes the screen scroll ;
make it possible to changes the sensitivity of the tilt in settings;

*/
package aau.g202.p2_gesturebasedinteraction;

import android.os.SystemClock;
import android.view.MotionEvent;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class ScrollMode extends ControlMode {


    public void Update() {
        //Update whatever you need updated in here

        if (currMode != Mode.SCROLLMODE)
            return;

        float y = Accelerometer.getY() * -1;
        float x = Accelerometer.getX() * -1;


        //the time (in ms) when the user originally pressed down to start a stream of position events.
        // This must be obtained from SystemClock.uptimeMillis().
        long downTime = SystemClock.uptimeMillis();
        //The time (in ms) when this specific event was generated.
        // This must be obtained from SystemClock.uptimeMillis().
        long eventTime = SystemClock.uptimeMillis();

        //The kind of action being performed -- one of either ACTION_DOWN,

        // ACTION_MOVE, ACTION_UP, or ACTION_CANCEL.
        @Override public boolean action (MotionEvent event){
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    x = TiltLevelX + (int) (event.getRawX());
                    y = TiltLevelY + (int) (event.getRawY());
                    break;
                //should make it stop scrolling by pressing a button
                case MotionEvent.ACTION_CANCEL:
                    if (press button == true){
                    //or false?
                    onTilt = 0;
                }
            }
        }

        MotionEvent event = MotionEvent.obtain(downTime, eventTime, action, x, y, metaState);

        view.onTouchEvent(event);


    }
}
}
