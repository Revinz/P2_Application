package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import static aau.g202.p2_gesturebasedinteraction.ControlMode.c;
import static aau.g202.p2_gesturebasedinteraction.MainMenu.settingsPref;

public class SimpleSettingsLayout extends AppCompatActivity implements View.OnClickListener {

    private static SeekBar cursorMaxSpeed_seekbar, cursorMinSpeed_seekbar, tiltMax_seekbar, tiltMin_seekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_settings_layout);

        //Creating Editor for the SharedPreference
        //final SharedPreferences.Editor settingsEdit = settingsPref.edit();
        SetupSeekbars();

        //To detect change on cursorHighSpeedX_seekbar
        cursorMaxSpeed_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(SimpleSettingsLayout.this, "Value: " + progress + "/"+ cursorMaxSpeed_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CMaxS",cursorMaxSpeed_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use gethighSpeedX_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorHighSpeedX_seekbar
        cursorMinSpeed_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(SimpleSettingsLayout.this, "Value: " + progress + "/"+ cursorMinSpeed_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CMinS",cursorMinSpeed_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use gethighSpeedX_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorHighAngleX_seekbar
        tiltMax_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(SimpleSettingsLayout.this, "Value: " + progress + "/"+ tiltMax_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("tMax",tiltMax_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use gethighAngleX_cursor()
                SelectMode.RetrieveSettings();
            }
        });
        //To detect change on cursorHighAngleX_seekbar
        tiltMin_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(SimpleSettingsLayout.this, "Value: " + progress + "/"+ tiltMin_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("tMin",tiltMin_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use gethighAngleX_cursor()
                SelectMode.RetrieveSettings();
            }
        });

    }

    @Override
    public void onClick(View v) {}

    public static float getMaxSpeed_cursor(Context c){
        return settingsPref.getFloat("CMaxS",0)/10;
    }

    public static float getMinSpeed_cursor(Context c){
        return settingsPref.getFloat("CMinS",0)/10;
    }

    public static float gettiltMax_cursor(Context c){
        return settingsPref.getFloat("tMax",0)/100;
    }

    public static float gettiltMin_cursor(Context c){
        return settingsPref.getFloat("tMin",0)/100;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
    }


    public void SetupSeekbars(){
        //casting variables for the seekbars
        cursorMaxSpeed_seekbar = findViewById(R.id.MaxCSpeedBar);
        cursorMinSpeed_seekbar = findViewById(R.id.MinCSpeedBar);
        tiltMax_seekbar = findViewById(R.id.MaxTiltBar);
        tiltMin_seekbar = findViewById(R.id.MinTiltBar);

        cursorMaxSpeed_seekbar.setProgress((int)getMaxSpeed_cursor(c)*10);
        cursorMinSpeed_seekbar.setProgress((int)getMinSpeed_cursor(c)*10);
        tiltMax_seekbar.setProgress((int)gettiltMax_cursor(c)*100);
        tiltMin_seekbar.setProgress((int)gettiltMin_cursor(c)*100);
    }

    public static void cursorStartUp(){
        SharedPreferences.Editor settingsEdit = settingsPref.edit();
        if (settingsPref.getBoolean("firstrunCursor", true)) {
            float defaultSpeed = 50;
            float defaultAngle = 45;
            // Do first run stuff here then set 'firstrun' as false
            settingsEdit.putFloat("CMaxS",defaultSpeed);
            settingsEdit.putFloat("CMinS",defaultSpeed);
            settingsEdit.putFloat("tMax",defaultAngle);
            settingsEdit.putFloat("TMin",defaultAngle);
            settingsEdit.apply();
            settingsPref.edit().putBoolean("firstrunCursor", false).apply();
        }
        SelectMode.RetrieveSettings();
    }
}