//Pseudcode

/*
*make a fake touch that acts like a finger swiping up or down*
check if the scrollMode is true or false;
make the scroll();
make the touch event;
use the sensor output to determine x and y ;
make an update that makes the screen scroll ;
make it possible to changes the sensitivity of the tilt in settings;
scroll;

*/
package aau.g202.p2_gesturebasedinteraction;

import android.os.SystemClock;
import android.view.MotionEvent;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class ScrollMode extends ControlMode {

        //the time (in ms) when the user originally pressed down to start a stream of position events.
        // This must be obtained from SystemClock.uptimeMillis().
        public long downTime = SystemClock.uptimeMillis();
        //The time (in ms) when this specific event was generated.
        // This must be obtained from SystemClock.uptimeMillis().
        public long eventTime = SystemClock.uptimeMillis();
        //this is done to make the fake touch scroll from the middle of the screen.
        int x = width/2;
        int y = height/2;

        //The kind of action being performed -- one of either ACTION_DOWN,
        // ACTION_MOVE, ACTION_UP, or ACTION_CANCEL.
        @Override public boolean onTilt( MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    x = TiltLevelX + (int) (event.getRawX() );
                    y = TiltLevelY + (int) (event.getRawY() );
                    break;
                //should make it stop scrolling by pressing a button
                case MotionEvent.ACTION_CANCEL:
                    if (press button == true) {
                    //or false?
                    onTilt = 0;
                }
            }
        }


        MotionEvent event = MotionEvent.obtain(downTime, eventTime, action, x, y, metaState);
view.onTouchEvent(event);


    }


    public void Update() {
        //Update whatever you need updated in here
    }
}
