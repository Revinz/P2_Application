package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class ScrollLayout extends Settings{
    private SeekBar scrollHighSpeedX_seekbar, scrollHighSpeedY_seekbar, scrollLowSpeedX_seekbar, scrollLowSpeedY_seekbar, scrollHighAngleX_seekbar, scrollHighAngleY_seekbar,scrollLowAngleX_seekbar, scrollLowAngleY_seekbar;
    private TextView scrollHighSpeedRoll_Text, scrollHighSpeedPitch_Text, scrollLowSpeedRoll_Text,scrollLowSpeedPitch_Text, scrollHighAngleRoll_Text, scrollHighAnglePitch_Text,scrollLowAngleRoll_Text, scrollLowAnglePitch_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Creating sharedPreferences for the seekbars
        //For High Speed
        SharedPreferences highSpeedX_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedXEdit = highSpeedX_scroll.edit();

        SharedPreferences highSpeedY_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedYEdit = highSpeedY_scroll.edit();

        //For Low Speed
        SharedPreferences lowSpeedX_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedXEdit = lowSpeedX_scroll.edit();

        SharedPreferences lowSpeedY_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedYEdit = lowSpeedY_scroll.edit();

        //For High speed Angle
        SharedPreferences highAngleX_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleXEdit = highAngleX_scroll.edit();

        SharedPreferences highAngleY_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleYEdit = highAngleX_scroll.edit();

        //For Low speed Angle
        SharedPreferences lowAngleX_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowAngleXEdit = lowAngleX_scroll.edit();

        SharedPreferences lowAngleY_scroll = getApplicationContext().getSharedPreferences("scrollSpeed", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowAngleYEdit = lowAngleY_scroll.edit();


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
                scrollHighSpeedXEdit.putInt("scrollSpeedValue",scrollHighSpeedX_seekbar.getProgress());
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
                scrollHighSpeedYEdit.putInt("scrollSpeedValue",scrollHighSpeedY_seekbar.getProgress());
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
                scrollLowSpeedXEdit.putInt("scrollSpeedValue",scrollLowSpeedX_seekbar.getProgress());
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
                scrollLowSpeedYEdit.putInt("scrollSpeedValue",scrollLowSpeedY_seekbar.getProgress());
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
                scrollHighAngleXEdit.putInt("scrollSpeedValue",scrollHighAngleX_seekbar.getProgress());
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
                scrollHighAngleYEdit.putInt("scrollSpeedValue",scrollHighAngleY_seekbar.getProgress());
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
                scrollLowAngleXEdit.putInt("scrollSpeedValue",scrollLowAngleX_seekbar.getProgress());
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
                scrollLowAngleYEdit.putInt("scrollSpeedValue",scrollLowAngleY_seekbar.getProgress());
                scrollLowAngleYEdit.apply();
            }
        });

    }
}
