package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import static aau.g202.p2_gesturebasedinteraction.ControlMode.c;
import static aau.g202.p2_gesturebasedinteraction.MainMenu.settingsPref;

public class ScrollLayout extends Settings{
    private static SeekBar scrollHighSpeedY_seekbar, scrollLowSpeedY_seekbar, scrollHighAngleY_seekbar,scrollLowAngleY_seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolllayout);

        //final SharedPreferences.Editor settingsEdit = settingsPref.edit();
        SetupSeekbars();

        //To detect change on scrollHighSpeedY_seekbar
        scrollHighSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollHighSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("SHSY",scrollHighSpeedY_seekbar.getProgress());
                settingsEdit.apply();
                ScrollMode.RetrieveSettings();
            }
        });

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

        //To detect change on scrollHighAngleY_seekbar
        scrollHighAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollHighAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("SHAY",scrollHighAngleY_seekbar.getProgress());
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

    public static float gethighSpeedY_scroll(Context c){
        return settingsPref.getFloat("SHSY",0)/10;
    }

    public static float getlowSpeedY_scroll(Context c){
        return settingsPref.getFloat("SLSY",0)/10;
    }

    public static float gethighAngleY_scroll(Context c){
        return settingsPref.getFloat("SHAY",0)/100;
    }

    public static float getlowAngleY_scroll(Context c) {
        return settingsPref.getFloat("SLAY", 0)/100;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
    }

    public void SetupSeekbars(){
        //casting variables for the seekbars
        scrollHighSpeedY_seekbar = findViewById(R.id.scrollHighSpeedY_seekbar);
        scrollLowSpeedY_seekbar = findViewById(R.id.scrollLowSpeedY_seekbar);
        scrollHighAngleY_seekbar = findViewById(R.id.scrollHighAngleY_seekbar);
        scrollLowAngleY_seekbar = findViewById(R.id.scrollLowAngleY_seekbar);

        scrollHighSpeedY_seekbar.setProgress((int)gethighSpeedY_scroll(c)*10);
        scrollLowSpeedY_seekbar.setProgress((int)getlowSpeedY_scroll(c)*10);
        scrollHighAngleY_seekbar.setProgress((int)gethighAngleY_scroll(c)*100);
        scrollLowAngleY_seekbar.setProgress((int)getlowAngleY_scroll(c)*100);
    }

    public static void scrollStartUp(){
        SharedPreferences.Editor settingsEdit = settingsPref.edit();
        if (settingsPref.getBoolean("firstrunScroll",true)){
            // Do first run stuff here then set 'firstrun' as false
            float defaultSpeed = 50;
            float defaultAngle = 45;
            settingsEdit.putFloat("SHSY", defaultSpeed);
            settingsEdit.putFloat("SLSY", defaultSpeed);
            settingsEdit.putFloat("SHAY", defaultAngle);
            settingsEdit.putFloat("SLAY", defaultAngle);
            settingsEdit.apply();
            settingsPref.edit().putBoolean("firstrunScroll",false).apply();
        }
        ScrollMode.RetrieveSettings();
    }
}
