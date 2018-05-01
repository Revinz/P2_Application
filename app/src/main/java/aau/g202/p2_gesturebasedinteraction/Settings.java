package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Settings extends AppCompatActivity implements View.OnClickListener{

    //initializing variables
    SeekBar pitchSpeed_seekbar, pitchAngle_seekbar, rollSpeed_seekbar, rollAngle_seekbar;
    ImageButton dot_button, cursor_button, circle_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences speed_pitch = getApplicationContext().getSharedPreferences("pitchSpeed",MODE_PRIVATE);
        final SharedPreferences.Editor pitchSpeedEdit = speed_pitch.edit();

        SharedPreferences angle_pitch = getApplicationContext().getSharedPreferences("pitchAngle",MODE_PRIVATE);
        final SharedPreferences.Editor pitchAngleEdit = angle_pitch.edit();

        SharedPreferences speed_roll = getApplicationContext().getSharedPreferences("rollSpeed",MODE_PRIVATE);
        final SharedPreferences.Editor rollSpeedEdit = speed_roll.edit();

        SharedPreferences angle_roll = getApplicationContext().getSharedPreferences("rollAngle",MODE_PRIVATE);
        final SharedPreferences.Editor rollAngleEdit = angle_roll.edit();

        //casting variables for the seekbars
        pitchSpeed_seekbar = findViewById(R.id.pitchSpeed_seekbar);
        pitchAngle_seekbar = findViewById(R.id.pitchAngle_seekbar);
        rollSpeed_seekbar = findViewById(R.id.rollSpeed_seekbar);
        rollAngle_seekbar = findViewById(R.id.rollAngle_seekbar);

        //casting variables for the image buttons
        dot_button = findViewById(R.id.dot_button);
        cursor_button = findViewById(R.id.cursor_button);
        circle_button = findViewById(R.id.circle_button);

        //Setting on click listeners to the image buttons
        dot_button.setOnClickListener(this);
        cursor_button.setOnClickListener(this);
        circle_button.setOnClickListener(this);

        //To detect change on pitchSpeed_seekbar
        pitchSpeed_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
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
                pitchSpeedEdit.putInt("pitchSpeedValue",pitchSpeed_seekbar.getProgress());
                pitchSpeedEdit.apply();
            }
        });

        //To detect change on pitchAngle_seekbar
        pitchAngle_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
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
                pitchAngleEdit.putInt("pitchAngleValue",pitchAngle_seekbar.getProgress());
                pitchAngleEdit.apply();
            }
        });

        //To detect change on rollSpeed_seekbar
        rollSpeed_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
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
                rollSpeedEdit.putInt("rollSpeedValue",rollSpeed_seekbar.getProgress());
                rollSpeedEdit.apply();
            }
        });

        //To detect change on rollAngle_seekbar
        rollAngle_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
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
                rollAngleEdit.putInt("rollAngleValue",rollAngle_seekbar.getProgress());
                rollAngleEdit.apply();
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
