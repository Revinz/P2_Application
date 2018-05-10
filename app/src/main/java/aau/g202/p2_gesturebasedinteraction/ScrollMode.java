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
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.app.Instrumentation;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class ScrollMode extends ControlMode {


    private static float scrollSpeed = 5;
    private static int dampening = 30;
    private static float minScrollAngle = 1;

    public static int getScreenHeight()
    {return Resources.getSystem().getDisplayMetrics().heightPixels;}


    ScrollMode(Context c, Activity a) {
        super(c, a);
    }


    public static void RetrieveSettings() {
        scrollSpeed = ScrollLayout.getlowSpeedY_scroll(c);
        minScrollAngle = ScrollLayout.getlowAngleY_scroll(c);

    }

    public void Update() {
        //Update whatever you need updated in here

        if (currMode != Mode.SCROLLMODE)
            return;

        Tilt();

    }

    int yPos = 0;

    private void Tilt() {


        if (Math.abs(Accelerometer.getY()) < minScrollAngle)
            return;

            // Try to scroll. It is only possible in the fake facebook app.
        try {
            FacebookScroll.scrollView.smoothScrollTo(0, yPos);
            yPos += scrollSpeed * Accelerometer.getY() / dampening;

            if (yPos < 0)
                yPos = 0;
            else if (yPos > FacebookScroll.scrollView.getBottom() + getScreenHeight())
                yPos = FacebookScroll.scrollView.getBottom() + getScreenHeight() ;
        }
         catch (Exception e) {

         }



    }


}

