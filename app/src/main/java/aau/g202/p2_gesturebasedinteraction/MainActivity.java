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

        ControlMode cm = new ControlMode();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.w("Volume Down", "SELECT");

            return true;

        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Log.w("Volume up", "modeswing?");

            return false;
        }

        return super.onKeyDown(keyCode, event);

    }

    @Override
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN && keyCode == KeyEvent.KEYCODE_POWER) {
            Log.w("Volume Down + Power", "changeMode");

            return true;
        }

        return super.onKeyDown(keyCode, event);

    }
}