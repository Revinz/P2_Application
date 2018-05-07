package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class ScrollLayout extends Settings implements View.OnClickListener{
    private SeekBar scrollHighSpeedX_seekbar, scrollHighSpeedY_seekbar, scrollLowSpeedX_seekbar, scrollLowSpeedY_seekbar, scrollHighAngleX_seekbar, scrollHighAngleY_seekbar,scrollLowAngleX_seekbar, scrollLowAngleY_seekbar;
    private TextView scrollHighSpeedRoll_Text, scrollHighSpeedPitch_Text, scrollLowSpeedRoll_Text,scrollLowSpeedPitch_Text, scrollHighAngleRoll_Text, scrollHighAnglePitch_Text,scrollLowAngleRoll_Text, scrollLowAnglePitch_Text;
    int SHSX, SHSY, SLSX, SLSY, SHAX, SHAY, SLAX, SLAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Creating sharedPreferences for the seekbars
        //For High Speed
        SharedPreferences highSpeedX_scroll = getApplicationContext().getSharedPreferences("HighCursorSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedXEdit = highSpeedX_scroll.edit();

        SharedPreferences highSpeedY_scroll = getApplicationContext().getSharedPreferences("HighCursorSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedYEdit = highSpeedY_scroll.edit();

        //For Low Speed
        SharedPreferences lowSpeedX_scroll = getApplicationContext().getSharedPreferences("LowCursorSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedXEdit = lowSpeedX_scroll.edit();

        SharedPreferences lowSpeedY_scroll = getApplicationContext().getSharedPreferences("LowCursorSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedYEdit = lowSpeedY_scroll.edit();

        //For High speed Angle
        SharedPreferences highAngleX_scroll = getApplicationContext().getSharedPreferences("HighAngleSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleXEdit = highAngleX_scroll.edit();

        SharedPreferences highAngleY_scroll = getApplicationContext().getSharedPreferences("HighAngleSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleYEdit = highAngleX_scroll.edit();

        //For Low speed Angle
        SharedPreferences lowAngleX_scroll = getApplicationContext().getSharedPreferences("LowAngleSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowAngleXEdit = lowAngleX_scroll.edit();

        SharedPreferences lowAngleY_scroll = getApplicationContext().getSharedPreferences("LowAngleSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowAngleYEdit = lowAngleY_scroll.edit();

        //casting variables for the image buttons
        ImageButton dot_button = findViewById(R.id.dot_button);
        ImageButton scroll_button = findViewById(R.id.cursor_button);
        ImageButton circle_button = findViewById(R.id.circle_button);

        //Setting on click listeners to the image buttons
        dot_button.setOnClickListener(this);
        scroll_button.setOnClickListener(this);
        circle_button.setOnClickListener(this);

        //casting variables for the seekbars
        scrollHighSpeedX_seekbar = findViewById(R.id.scrollHighSpeedX_seekbar);
        scrollHighSpeedY_seekbar = findViewById(R.id.scrollHighSpeedY_seekbar);
        scrollLowSpeedX_seekbar = findViewById(R.id.scrollLowSpeedX_seekbar);
        scrollLowSpeedY_seekbar = findViewById(R.id.scrollLowSpeedY_seekbar);
        scrollHighAngleX_seekbar = findViewById(R.id.scrollHighAngleX_seekbar);
        scrollHighAngleY_seekbar = findViewById(R.id.scrollHighAngleY_seekbar);
        scrollLowAngleX_seekbar = findViewById(R.id.scrollLowAngleX_seekbar);
        scrollLowAngleY_seekbar = findViewById(R.id.scrollLowAngleY_seekbar);

        //Text For scrollHighSpeedX_seekbar
        scrollHighSpeedRoll_Text.setText("Roll:" + scrollHighSpeedX_seekbar.getProgress()+ "/" + scrollHighSpeedX_seekbar.getProgress());
        //To detect change on scrollHighSpeedX_seekbar
        scrollHighSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollHighSpeedRoll_Text.setText("Roll:" + progress+ "/" + scrollHighSpeedX_seekbar.getProgress());
                scrollHighSpeedXEdit.putInt("HighCursorSpeedXValue",scrollHighSpeedX_seekbar.getProgress());
                scrollHighSpeedXEdit.apply();
            }
        });

        //Text For scrollHighSpeedY_seekbar
        scrollHighSpeedPitch_Text.setText("Pitch:" + scrollHighSpeedY_seekbar.getProgress()+ "/" + scrollHighSpeedY_seekbar.getProgress());
        //To detect change on scrollHighSpeedY_seekbar
        scrollHighSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollHighSpeedPitch_Text.setText("Pitch:" + progress+ "/" + scrollHighSpeedY_seekbar.getProgress());
                scrollHighSpeedYEdit.putInt("HighCursorSpeedYValue",scrollHighSpeedY_seekbar.getProgress());
                scrollHighSpeedYEdit.apply();
            }
        });

        //Text For scrollLowSpeedX_seekbar
        scrollLowSpeedRoll_Text.setText("Roll:" + scrollLowSpeedX_seekbar.getProgress()+ "/" + scrollLowSpeedX_seekbar.getProgress());
        //To detect change on scrollLowSpeedX_seekbar
        scrollLowSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollLowSpeedRoll_Text.setText("Roll:" + progress + "/" + scrollLowSpeedX_seekbar.getProgress());
                scrollLowSpeedXEdit.putInt("LowCursorSpeedXValue",scrollLowSpeedX_seekbar.getProgress());
                scrollLowSpeedXEdit.apply();
            }
        });

        //Text For scrollLowSpeedY_seekbar
        scrollLowSpeedPitch_Text.setText("Pitch:" + scrollLowSpeedY_seekbar.getProgress()+ "/" +scrollLowSpeedY_seekbar.getProgress());
        //To detect change on scrollLowSpeedY_seekbar
        scrollLowSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollLowSpeedPitch_Text.setText("Pitch:" + progress+ "/" + scrollLowSpeedY_seekbar.getProgress());
                scrollLowSpeedYEdit.putInt("LowCursorSpeedYValue",scrollLowSpeedY_seekbar.getProgress());
                scrollLowSpeedYEdit.apply();
            }
        });

        //Text For scrollHighAngleX_seekbar
        scrollHighAngleRoll_Text.setText("Roll:" + scrollHighAngleX_seekbar.getProgress()+ "/" + scrollHighAngleX_seekbar.getProgress());
        //To detect change on scrollHighAngleX_seekbar
        scrollHighAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollHighAngleRoll_Text.setText("Roll:" + progress + "/" + scrollHighAngleX_seekbar.getProgress());
                scrollHighAngleXEdit.putInt("HighCursorAngleXValue",scrollHighAngleX_seekbar.getProgress());
                scrollHighAngleXEdit.apply();
            }
        });

        //Text For scrollHighAngleY_seekbar
        scrollHighAnglePitch_Text.setText("Pitch:" + scrollHighAngleY_seekbar.getProgress()+ "/" + scrollHighAngleY_seekbar.getProgress());
        //To detect change on scrollHighAngleY_seekbar
        scrollHighAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollHighAnglePitch_Text.setText("Pitch:" + progress + "/" + scrollHighAngleY_seekbar.getProgress());
                scrollHighAngleYEdit.putInt("HighCursorAngleYValue",scrollHighAngleY_seekbar.getProgress());
                scrollHighAngleYEdit.apply();
            }
        });

        //Text For scrollLowAngleX_seekbar
        scrollLowAngleRoll_Text.setText("Roll:" + scrollLowAngleX_seekbar.getProgress()+ "/" + scrollLowAngleX_seekbar.getProgress());
        //To detect change on scrollLowAngleX_seekbar
        scrollLowAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollLowAngleRoll_Text.setText("Roll:" + progress+ "/" + scrollLowAngleX_seekbar.getProgress());
                scrollLowAngleXEdit.putInt("LowCursorAngleXValue",scrollLowAngleX_seekbar.getProgress());
                scrollLowAngleXEdit.apply();
            }
        });

        //Text For scrollLowAngleY_seekbar
        scrollLowAnglePitch_Text.setText("Pitch " + scrollLowAngleY_seekbar.getProgress()+ "/" + scrollLowAngleY_seekbar.getProgress());
        //To detect change on scrollLowAngleY_seekbar
        scrollLowAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                scrollLowAnglePitch_Text.setText("Pitch:" + progress+ "/" + scrollLowAngleY_seekbar.getProgress());
                scrollLowAngleYEdit.putInt("LowCursorAngleYValue",scrollLowAngleY_seekbar.getProgress());
                scrollLowAngleYEdit.apply();
            }
        });

    }
    //Method for selecting the different scrolls
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.dot_button:
                // scroll_image = R.drawable.reddot;
                break;
            case R.id.cursor_button:
                // scroll_image = R.drawable.mouse;
                break;
            case R.id.circle_button:
                //scroll_image = R.drawable.circle;
                break;
        }
    }
    public void getsettings (){
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        SHSX = prefs.getInt("HighCursorSpeedXValue", 0);
        SHSY = prefs.getInt("HighCursorSpeedYValue", 0);
        SLSX = prefs.getInt("LowCursorSpeedXValue", 0);
        SLSY = prefs.getInt("LowCursorSpeedYValue", 0);
        SHAX = prefs.getInt("HighCursorAngleXValue", 0);
        SHAY = prefs.getInt("HighCursorAngleYValue", 0);
        SLAX = prefs.getInt("LowCursorAngleXValue", 0);
        SLAY = prefs.getInt("LowCursorAngleYValue", 0);
    }
}