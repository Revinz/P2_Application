package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class CursorLayout extends Settings implements View.OnClickListener{
    private SeekBar cursorHighSpeedX_seekbar, cursorHighSpeedY_seekbar, cursorLowSpeedX_seekbar, cursorLowSpeedY_seekbar, cursorHighAngleX_seekbar, cursorHighAngleY_seekbar,cursorLowAngleX_seekbar, cursorLowAngleY_seekbar;
    private TextView cursorHighSpeedRoll_Text, cursorHighSpeedPitch_Text, cursorLowSpeedRoll_Text,cursorLowSpeedPitch_Text, cursorHighAngleRoll_Text, cursorHighAnglePitch_Text,cursorLowAngleRoll_Text, cursorLowAnglePitch_Text;
    int cursor_image = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Creating sharedPreferences for the seekbars
        //For High Speed
        SharedPreferences highSpeedX_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighSpeedXEdit = highSpeedX_cursor.edit();

        SharedPreferences highSpeedY_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighSpeedYEdit = highSpeedY_cursor.edit();

        //For Low Speed
        SharedPreferences lowSpeedX_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowSpeedXEdit = lowSpeedX_cursor.edit();

        SharedPreferences lowSpeedY_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowSpeedYEdit = lowSpeedY_cursor.edit();

        //For High speed Angle
        SharedPreferences highAngleX_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighAngleXEdit = highAngleX_cursor.edit();

        SharedPreferences highAngleY_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighAngleYEdit = highAngleX_cursor.edit();

        //For Low speed Angle
        SharedPreferences lowAngleX_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowAngleXEdit = lowAngleX_cursor.edit();

        SharedPreferences lowAngleY_cursor = getApplicationContext().getSharedPreferences("cursorSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowAngleYEdit = lowAngleY_cursor.edit();

        //casting variables for the image buttons
        ImageButton dot_button = findViewById(R.id.dot_button);
        ImageButton cursor_button = findViewById(R.id.cursor_button);
        ImageButton circle_button = findViewById(R.id.circle_button);

        //Setting on click listeners to the image buttons
        dot_button.setOnClickListener(this);
        cursor_button.setOnClickListener(this);
        circle_button.setOnClickListener(this);

        //casting variables for the seekbars
        cursorHighSpeedX_seekbar = findViewById(R.id.cursorHighSpeedX_seekbar);
        cursorHighSpeedY_seekbar = findViewById(R.id.cursorHighSpeedY_seekbar);
        cursorLowSpeedX_seekbar = findViewById(R.id.cursorLowSpeedX_seekbar);
        cursorLowSpeedY_seekbar = findViewById(R.id.cursorLowSpeedY_seekbar);
        cursorHighAngleX_seekbar = findViewById(R.id.cursorHighAngleX_seekbar);
        cursorHighAngleY_seekbar = findViewById(R.id.cursorHighAngleY_seekbar);
        cursorLowAngleX_seekbar = findViewById(R.id.cursorLowAngleX_seekbar);
        cursorLowAngleY_seekbar = findViewById(R.id.cursorLowAngleY_seekbar);

        //Text For cursorHighSpeedX_seekbar
        cursorHighSpeedRoll_Text.setText("Roll:" + cursorHighSpeedX_seekbar.getProgress()+ "/" + cursorHighSpeedX_seekbar.getProgress());
        //To detect change on cursorHighSpeedX_seekbar
        cursorHighSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorHighSpeedRoll_Text.setText("Roll:" + progress+ "/" + cursorHighSpeedX_seekbar.getProgress());
                cursorHighSpeedXEdit.putInt("cursorSpeedValue",cursorHighSpeedX_seekbar.getProgress());
                cursorHighSpeedXEdit.apply();
            }
        });

        //Text For cursorHighSpeedY_seekbar
        cursorHighSpeedPitch_Text.setText("Pitch:" + cursorHighSpeedY_seekbar.getProgress()+ "/" + cursorHighSpeedY_seekbar.getProgress());
        //To detect change on cursorHighSpeedY_seekbar
        cursorHighSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorHighSpeedPitch_Text.setText("Pitch:" + progress+ "/" + cursorHighSpeedY_seekbar.getProgress());
                cursorHighSpeedYEdit.putInt("cursorSpeedValue",cursorHighSpeedY_seekbar.getProgress());
                cursorHighSpeedYEdit.apply();
            }
        });

        //Text For cursorLowSpeedX_seekbar
        cursorLowSpeedRoll_Text.setText("Roll:" + cursorLowSpeedX_seekbar.getProgress()+ "/" + cursorLowSpeedX_seekbar.getProgress());
        //To detect change on cursorLowSpeedX_seekbar
        cursorLowSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorLowSpeedRoll_Text.setText("Roll:" + progress + "/" + cursorLowSpeedX_seekbar.getProgress());
                cursorLowSpeedXEdit.putInt("cursorSpeedValue",cursorLowSpeedX_seekbar.getProgress());
                cursorLowSpeedXEdit.apply();
            }
        });

        //Text For cursorLowSpeedY_seekbar
        cursorLowSpeedPitch_Text.setText("Pitch:" + cursorLowSpeedY_seekbar.getProgress()+ "/" +cursorLowSpeedY_seekbar.getProgress());
        //To detect change on cursorLowSpeedY_seekbar
        cursorLowSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorLowSpeedPitch_Text.setText("Pitch:" + progress+ "/" + cursorLowSpeedY_seekbar.getProgress());
                cursorLowSpeedYEdit.putInt("cursorSpeedValue",cursorLowSpeedY_seekbar.getProgress());
                cursorLowSpeedYEdit.apply();
            }
        });

        //Text For cursorHighAngleX_seekbar
        cursorHighAngleRoll_Text.setText("Roll:" + cursorHighAngleX_seekbar.getProgress()+ "/" + cursorHighAngleX_seekbar.getProgress());
        //To detect change on cursorHighAngleX_seekbar
        cursorHighAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorHighAngleRoll_Text.setText("Roll:" + progress + "/" + cursorHighAngleX_seekbar.getProgress());
                cursorHighAngleXEdit.putInt("cursorSpeedValue",cursorHighAngleX_seekbar.getProgress());
                cursorHighAngleXEdit.apply();
            }
        });

        //Text For cursorHighAngleY_seekbar
        cursorHighAnglePitch_Text.setText("Pitch:" + cursorHighAngleY_seekbar.getProgress()+ "/" + cursorHighAngleY_seekbar.getProgress());
        //To detect change on cursorHighAngleY_seekbar
        cursorHighAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorHighAnglePitch_Text.setText("Pitch:" + progress + "/" + cursorHighAngleY_seekbar.getProgress());
                cursorHighAngleYEdit.putInt("cursorSpeedValue",cursorHighAngleY_seekbar.getProgress());
                cursorHighAngleYEdit.apply();
            }
        });

        //Text For cursorLowAngleX_seekbar
        cursorLowAngleRoll_Text.setText("Roll:" + cursorLowAngleX_seekbar.getProgress()+ "/" + cursorLowAngleX_seekbar.getProgress());
        //To detect change on cursorLowAngleX_seekbar
        cursorLowAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorLowAngleRoll_Text.setText("Roll:" + progress+ "/" + cursorLowAngleX_seekbar.getProgress());
                cursorLowAngleXEdit.putInt("cursorSpeedValue",cursorLowAngleX_seekbar.getProgress());
                cursorLowAngleXEdit.apply();
            }
        });

        //Text For cursorLowAngleY_seekbar
        cursorLowAnglePitch_Text.setText("Pitch " + cursorLowAngleY_seekbar.getProgress()+ "/" + cursorLowAngleY_seekbar.getProgress());
        //To detect change on cursorLowAngleY_seekbar
        cursorLowAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser){
                progress = progressValue;
            }
            @Override //Can be used to display things and to test
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override //Can be used to display things and to test
            public void onStopTrackingTouch(SeekBar seekBar) {
                cursorLowAnglePitch_Text.setText("Pitch:" + progress+ "/" + cursorLowAngleY_seekbar.getProgress());
                cursorLowAngleYEdit.putInt("cursorSpeedValue",cursorLowAngleY_seekbar.getProgress());
                cursorLowAngleYEdit.apply();
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
    public int getCursor_image(){
        return cursor_image;
    }
}