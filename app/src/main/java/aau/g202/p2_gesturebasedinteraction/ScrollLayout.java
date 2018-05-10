package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

import junit.framework.Assert;

import static aau.g202.p2_gesturebasedinteraction.ControlMode.c;
import static aau.g202.p2_gesturebasedinteraction.MainMenu.settingsPref;

public class ScrollLayout extends AppCompatActivity{
    private static SeekBar scrollLowSpeedY_seekbar, scrollLowAngleY_seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolllayout);

        SetupSeekbars();


        //To detect change on scrollLowSpeedY_seekbar
        scrollLowSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollLowSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("SLSY",scrollLowSpeedY_seekbar.getProgress());
                settingsEdit.apply();
                ScrollMode.RetrieveSettings();
            }
        });



        //To detect change on scrollLowAngleY_seekbar
        scrollLowAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollLowAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("SLAY",scrollLowAngleY_seekbar.getProgress());
                settingsEdit.apply();
                ScrollMode.RetrieveSettings();
            }
        });

    }

    public static float getlowSpeedY_scroll(Context c){
        return settingsPref.getFloat("SLSY",0)/10;
    }

    public static float getlowAngleY_scroll(Context c) {

        return settingsPref.getFloat("SLAY", 0)/10;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
    }

    public void SetupSeekbars(){
        //casting variables for the seekbars
        scrollLowSpeedY_seekbar = findViewById(R.id.scrollLowSpeedY_seekbar);
        scrollLowAngleY_seekbar = findViewById(R.id.scrollLowAngleY_seekbar);

        scrollLowSpeedY_seekbar.setProgress((int)getlowSpeedY_scroll(c)*10);
        scrollLowAngleY_seekbar.setProgress((int)getlowAngleY_scroll(c)*10);
    }

    public static void scrollStartUp(){
        SharedPreferences.Editor settingsEdit = settingsPref.edit();
        if (settingsPref.getBoolean("firstrunScroll",true)){
            // Do first run stuff here then set 'firstrun' as false
            settingsEdit.putFloat("SLSY", 50);
            settingsEdit.putFloat("SLAY", 45);
            settingsEdit.apply();
            settingsPref.edit().putBoolean("firstrunScroll",false).apply();
        }
        ScrollMode.RetrieveSettings();
    }
}
