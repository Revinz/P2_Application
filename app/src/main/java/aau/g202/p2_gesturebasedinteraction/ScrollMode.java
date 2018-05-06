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

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.app.Instrumentation;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class ScrollMode extends ControlMode {

    int centerWidth = 1080 / 2;
    int centerHeight = 1920 / 2;

    int scrollSpeed = 5;
    int dampening = 10;

    ScrollMode(Context c, Activity a) {
        super(c, a);

    }

    public void Update() {
        //Update whatever you need updated in here

        if (currMode != Mode.SCROLLMODE)
            return;

        Tilt();

    }


    private void Tilt() {

            long downTime = System.currentTimeMillis();
            long upTime = System.currentTimeMillis();
            float yStart = 0.5f;
            float yEnd = Accelerometer.getY() + yStart;
            float yEnd2 = Accelerometer.getY() + yStart;

        try {
            MotionEvent event = MotionEvent.obtain(downTime, upTime, MotionEvent.ACTION_SCROLL, 0, yStart, 0);
            currActivity.dispatchTouchEvent(event);
        }
         catch (Exception e) {

         }



    }


}

