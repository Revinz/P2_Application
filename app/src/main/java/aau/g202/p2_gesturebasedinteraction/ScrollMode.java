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
import android.content.Context;

/**
 * Created by Revinz on 27-Apr-18.
 */

public class ScrollMode extends ControlMode {


    private static float scrollLowSpeed = 5;
    private static int dampening = 30;
    private static float lowSpeedScrollAngle = 1;

    ScrollMode(Context c, Activity a) {
        super(c, a);

        //RetrieveSettings();

    }

    public static void RetrieveSettings() {
        scrollLowSpeed = ScrollLayout.getlowSpeedY_scroll(c);
        lowSpeedScrollAngle = ScrollLayout.getlowAngleY_scroll(c);
    }

    public void Update() {
        //Update whatever you need updated in here

        if (currMode != Mode.SCROLLMODE)
            return;

        Tilt();

    }

    int yPos = 0;

    private void Tilt() {


        if (Math.abs(Accelerometer.getY()) < lowSpeedScrollAngle)
            return;

            // Try to scroll. It is only possible in the fake facebook app.
        try {
            FacebookScroll.scrollView.smoothScrollTo(0, yPos);
            yPos += scrollLowSpeed * Accelerometer.getY() / dampening;

            if (yPos < 0)
                yPos = 0;
            else if (yPos > FacebookScroll.scrollView.getBottom() + 1920)
                yPos = FacebookScroll.scrollView.getBottom() + 1920;
        }
         catch (Exception e) {

         }



    }


}

