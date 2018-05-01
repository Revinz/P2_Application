package aau.g202.p2_gesturebasedinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lightsensor ls = new Lightsensor(this);
        Accelerometer accelerometer = new Accelerometer(this);
        //ControlMode cm = new ControlMode();
        ControlMode modes = new SelectMode(this, this);


    }
/*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.w("Volume Down", "SELECT ------------------------------------------");
            //SelectMode.select();

            return true;

        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Log.w("Volume up", "modeswing?");

            return false;
        }

        return super.onKeyDown(keyCode, event);

    } */


    //Removes the overlay from the screen
    @Override
    public void onDestroy() {
        ControlMode.RemoveOverlay();

        super.onDestroy();
    }
}