package aau.g202.p2_gesturebasedinteraction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import static aau.g202.p2_gesturebasedinteraction.ControlMode.c;
import static aau.g202.p2_gesturebasedinteraction.MainMenu.settingsPref;

public class CursorLayout extends AppCompatActivity implements View.OnClickListener{
    //static SharedPreferences settingsPref;
    private static SeekBar cursorHighSpeedX_seekbar, cursorHighSpeedY_seekbar, cursorLowSpeedX_seekbar, cursorLowSpeedY_seekbar, cursorHighAngleX_seekbar, cursorHighAngleY_seekbar,cursorLowAngleX_seekbar, cursorLowAngleY_seekbar;
    public static int cursor_image = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursorlayout);

        SetupSeekbars();

        //casting variables for the image buttons
        ImageButton dot_button = findViewById(R.id.dot_button);
        ImageButton cursor_button = findViewById(R.id.cursor_button);
        ImageButton circle_button = findViewById(R.id.circle_button);

        //Setting on click listeners to the image buttons
        dot_button.setOnClickListener(this);
        cursor_button.setOnClickListener(this);
        circle_button.setOnClickListener(this);




        //To detect change on cursorHighSpeedX_seekbar
        cursorHighSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorLowSpeedX_seekbar.getProgress() >= cursorHighSpeedX_seekbar.getProgress()){
                    cursorHighSpeedX_seekbar.setProgress(cursorLowSpeedX_seekbar.getProgress()+1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighSpeedX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CHSX",cursorHighSpeedX_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use gethighSpeedX_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorHighSpeedY_seekbar
        cursorHighSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorLowSpeedY_seekbar.getProgress() >= cursorHighSpeedY_seekbar.getProgress()){
                    cursorHighSpeedY_seekbar.setProgress(cursorLowSpeedY_seekbar.getProgress()+1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CHSY",cursorHighSpeedY_seekbar.getProgress());
                settingsEdit.apply();
                //To get data use gethighSpeedY_cursor()
                SelectMode.RetrieveSettings();
            }
        });


        //To detect change on cursorLowSpeedX_seekbar
        cursorLowSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorHighSpeedX_seekbar.getProgress() <= cursorLowSpeedX_seekbar.getProgress()){
                    cursorLowSpeedX_seekbar.setProgress(cursorHighSpeedX_seekbar.getProgress()-1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowSpeedX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CLSX",cursorLowSpeedX_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use getlowSpeedX_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorLowSpeedY_seekbar
        cursorLowSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorHighSpeedY_seekbar.getProgress() <= cursorLowSpeedY_seekbar.getProgress()){
                    cursorLowSpeedY_seekbar.setProgress(cursorHighSpeedY_seekbar.getProgress()-1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CLSY",cursorLowSpeedY_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use getlowSpeedY_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorHighAngleX_seekbar
        cursorHighAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorLowAngleX_seekbar.getProgress() >= cursorHighAngleX_seekbar.getProgress()){
                    cursorHighAngleX_seekbar.setProgress(cursorLowAngleX_seekbar.getProgress()+1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighAngleX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CHAX",cursorHighAngleX_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use gethighAngleX_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorHighAngleY_seekbar
        cursorHighAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorLowAngleY_seekbar.getProgress() >= cursorHighAngleY_seekbar.getProgress()){
                    cursorHighAngleY_seekbar.setProgress(cursorLowAngleY_seekbar.getProgress()+1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CHAY",(float)cursorHighAngleY_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use gethighAngleY_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorLowAngleX_seekbar
        cursorLowAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorHighAngleX_seekbar.getProgress() <= cursorLowAngleX_seekbar.getProgress()){
                    cursorLowAngleX_seekbar.setProgress(cursorHighAngleX_seekbar.getProgress()-1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowAngleX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CLAX",(float)cursorLowAngleX_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use getlowAngleX_cursor()
                SelectMode.RetrieveSettings();
            }
        });

        //To detect change on cursorLowAngleY_seekbar
        cursorLowAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            //Setting start progress
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
                if (cursorHighAngleY_seekbar.getProgress() <= cursorLowAngleY_seekbar.getProgress()){
                    cursorLowAngleY_seekbar.setProgress(cursorHighAngleY_seekbar.getProgress()-1);
                }
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor settingsEdit = settingsPref.edit();
                settingsEdit.putFloat("CLAY",(float)cursorLowAngleY_seekbar.getProgress());
                settingsEdit.apply();

                //To get data use getlowAngleY_cursor()
                SelectMode.RetrieveSettings();
            }
        });

    }
    //Method for selecting the different cursors
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.dot_button:
                cursor_image = R.drawable.reddot;
                break;
            case R.id.cursor_button:
                cursor_image = R.drawable.mouse;
                break;
            case R.id.circle_button:
                cursor_image = R.drawable.circle;
                break;
        }

    }
    public static int getCursor_image(){
        return cursor_image;
    }

    public static float gethighSpeedX_cursor(Context c){
        return settingsPref.getFloat("CHSX",0)/10;
    }

    public static float gethighSpeedY_cursor(Context c){
        return settingsPref.getFloat("CHSY",0)/10;
    }

    public static float getlowSpeedX_cursor(Context c){
        return settingsPref.getFloat("CLSX",0)/10;
    }

    public static float getlowSpeedY_cursor(Context c){
        return settingsPref.getFloat("CLSY",0)/10;
    }

    public static float gethighAngleX_cursor(Context c){
        return settingsPref.getFloat("CHAX",0)/100;
    }

    public static float gethighAngleY_cursor(Context c){
        return settingsPref.getFloat("CHAY",0)/100;
    }

    public static float getlowAngleX_cursor(Context c){
        return settingsPref.getFloat("CLAX",0)/100;
    }

    public static float getlowAngleY_cursor(Context c){
        return settingsPref.getFloat("CLAY",0)/100;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
    }


    public void SetupSeekbars(){
            //casting variables for the seekbars
            cursorHighSpeedX_seekbar = findViewById(R.id.cursorHighSpeedX_seekbar);
            cursorHighSpeedY_seekbar = findViewById(R.id.cursorHighSpeedY_seekbar);
            cursorLowSpeedX_seekbar = findViewById(R.id.cursorLowSpeedX_seekbar);
            cursorLowSpeedY_seekbar = findViewById(R.id.cursorLowSpeedY_seekbar);
            cursorHighAngleX_seekbar = findViewById(R.id.cursorHighAngleX_seekbar);
            cursorHighAngleY_seekbar = findViewById(R.id.cursorHighAngleY_seekbar);
            cursorLowAngleX_seekbar = findViewById(R.id.cursorLowAngleX_seekbar);
            cursorLowAngleY_seekbar = findViewById(R.id.cursorLowAngleY_seekbar);

            cursorHighSpeedX_seekbar.setProgress((int)gethighSpeedX_cursor(c)*10);
            cursorHighSpeedY_seekbar.setProgress((int)gethighSpeedY_cursor(c)*10);
            cursorLowSpeedX_seekbar.setProgress((int)getlowSpeedX_cursor(c)*10);
            cursorLowSpeedY_seekbar.setProgress((int)getlowSpeedY_cursor(c)*10);
            cursorHighAngleX_seekbar.setProgress((int)gethighAngleX_cursor(c)*100);
            cursorHighAngleY_seekbar.setProgress((int)gethighAngleY_cursor(c)*100);
            cursorLowAngleX_seekbar.setProgress((int)getlowAngleX_cursor(c)*100);
            cursorLowAngleY_seekbar.setProgress((int)getlowAngleY_cursor(c)*100);
    }

    public static void cursorStartUp(){
        SharedPreferences.Editor settingsEdit = settingsPref.edit();
        if (settingsPref.getBoolean("firstrunCursor", true)) {
            // Do first run stuff here then set 'firstrun' as false
            settingsEdit.putFloat("CHSX",50);
            settingsEdit.putFloat("CHSY",50);
            settingsEdit.putFloat("CLSX",49);
            settingsEdit.putFloat("CLSY",49);
            settingsEdit.putFloat("CHAX",45);
            settingsEdit.putFloat("CHAY",45);
            settingsEdit.putFloat("CLAX",44);
            settingsEdit.putFloat("CLAY",44);
            settingsEdit.apply();
            settingsPref.edit().putBoolean("firstrunCursor", false).apply();
        }
        SelectMode.RetrieveSettings();
    }
}