package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;

public class Settings extends AppCompatActivity implements View.OnClickListener{

    //initializing variables
    SeekBar cursorSpeed_seekbar, cursorAngle_seekbar, scrollSpeed_seekbar, scrollAngle_seekbar;
    ImageButton dot_button, cursor_button, circle_button;
    Switch AutoTurnOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Creating sharedPreferences for the seekbars and the switch
        SharedPreferences speed_cursor = getApplicationContext().getSharedPreferences("cursorSpeed",MODE_PRIVATE);
        final SharedPreferences.Editor cursorSpeedEdit = speed_cursor.edit();

        SharedPreferences angle_cursor = getApplicationContext().getSharedPreferences("cursorAngle",MODE_PRIVATE);
        final SharedPreferences.Editor cursorAngleEdit = angle_cursor.edit();

        SharedPreferences speed_scroll = getApplicationContext().getSharedPreferences("scrollSpeed",MODE_PRIVATE);
        final SharedPreferences.Editor scrollSpeedEdit = speed_scroll.edit();

        SharedPreferences angle_scroll = getApplicationContext().getSharedPreferences("scrollAngle",MODE_PRIVATE);
        final SharedPreferences.Editor scrollAngleEdit = angle_scroll.edit();

        SharedPreferences TurnOnAuto = getApplicationContext().getSharedPreferences("TurnOnB",MODE_PRIVATE);
        final SharedPreferences.Editor AutoTurnOnEdit = TurnOnAuto.edit();

        //casting variables for the seekbars
        cursorSpeed_seekbar = findViewById(R.id.cursorSpeed_seekbar);
        cursorAngle_seekbar = findViewById(R.id.cursorAngle_seekbar);
        scrollSpeed_seekbar = findViewById(R.id.scrollSpeed_seekbar);
        scrollAngle_seekbar = findViewById(R.id.scrollAngle_seekbar);

        //Casting variables for the switch
        AutoTurnOn = findViewById(R.id.LightSensor_Switch);

        //casting variables for the image buttons
        dot_button = findViewById(R.id.dot_button);
        cursor_button = findViewById(R.id.cursor_button);
        circle_button = findViewById(R.id.circle_button);

        //Setting on click listeners to the image buttons
        dot_button.setOnClickListener(this);
        cursor_button.setOnClickListener(this);
        circle_button.setOnClickListener(this);

        //To detect change on pitchSpeed_seekbar
        cursorSpeed_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 2;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorSpeedEdit.putInt("cursorSpeedValue",cursorSpeed_seekbar.getProgress());
                cursorSpeedEdit.apply();
            }
        });

        //To detect change on pitchAngle_seekbar
        cursorAngle_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            //Setting start progress
            int progress = 2;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
            }

            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorAngleEdit.putInt("cursorAngleValue",cursorAngle_seekbar.getProgress());
                cursorAngleEdit.apply();
            }
        });

        //To detect change on rollSpeed_seekbar
        scrollSpeed_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 2;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                scrollSpeedEdit.putInt("scrollSpeedValue",scrollSpeed_seekbar.getProgress());
                scrollSpeedEdit.apply();
            }
        });

        //To detect change on rollAngle_seekbar
        scrollAngle_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 2;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                scrollAngleEdit.putInt("scrollAngleValue",scrollAngle_seekbar.getProgress());
                scrollAngleEdit.apply();
            }
        });

        //To detect change on the switch
        AutoTurnOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                AutoTurnOnEdit.putBoolean("LightSensorValue",AutoTurnOn.isChecked());
                AutoTurnOnEdit.apply();
            }
        });
    }
    //Method for selecting the different cursors
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.dot_button:
               // cursor_image = R.drawable.reddot;
                break;
            case R.id.cursor_button:
                // cursor_image = R.drawable.mouse;
                break;
            case R.id.circle_button:
                //cursor_image = R.drawable.circle;
                break;
        }
    }

}
