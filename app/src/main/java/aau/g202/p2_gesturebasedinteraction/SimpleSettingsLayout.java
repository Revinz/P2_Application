package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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


        Button resetButton = findViewById(R.id.BnReset);

        //Setup Click Listener for the reset button to reset the settings on click.
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SetupDefaultSettings();
                Toast.makeText(SimpleSettingsLayout.this, "Settings have been reset to default", Toast.LENGTH_SHORT).show();
            }
        });

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
        return settingsPref.getFloat("tMax",0)/10;
    }

    public static float gettiltMin_cursor(Context c){
        return settingsPref.getFloat("tMin",0)/10;
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

        UpdateSeekbarThumbs();
    }

    //Updates the seekbar thumbs position
    public static void UpdateSeekbarThumbs() {
        cursorMaxSpeed_seekbar.setProgress((int)(getMaxSpeed_cursor(c)*10));
        cursorMinSpeed_seekbar.setProgress((int)(getMinSpeed_cursor(c)*10));
        tiltMax_seekbar.setProgress((int)(gettiltMax_cursor(c)*10));
        tiltMin_seekbar.setProgress((int)(gettiltMin_cursor(c)*10));
    }

    public static void cursorStartUp(){
        if (settingsPref.getBoolean("firstrunCursor", true)) {
            SetupDefaultSettings();
            settingsPref.edit().putBoolean("firstrunCursor", false).apply();
        }
        SelectMode.RetrieveSettings();
    }

    //Sets up the default values for the settings
    private static void SetupDefaultSettings() {
        SharedPreferences.Editor settingsEdit = settingsPref.edit();
        float defaultSpeed = 30;
        float defaultAngle = 20;
        settingsEdit.putFloat("CMaxS", defaultSpeed + 20);
        settingsEdit.putFloat("CMinS", defaultSpeed);
        settingsEdit.putFloat("tMax", defaultAngle + 15);
        settingsEdit.putFloat("tMin", defaultAngle);
        settingsEdit.apply();

        //Try to update the position the seekbar thumbs
        try {
            UpdateSeekbarThumbs();

        }
        catch(Exception ex){

        }

        //Take the new cursor settings in use
        SelectMode.RetrieveSettings();

    }
}