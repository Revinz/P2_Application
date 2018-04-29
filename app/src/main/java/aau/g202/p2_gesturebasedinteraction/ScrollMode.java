package aau.g202.p2_gesturebasedinteraction;

import android.os.SystemClock;
import android.view.MotionEvent;

public class ScrollMode {

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
