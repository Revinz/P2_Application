package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollLayout extends Settings{
    private SeekBar scrollHighSpeedX_seekbar, scrollHighSpeedY_seekbar, scrollLowSpeedX_seekbar, scrollLowSpeedY_seekbar, scrollHighAngleX_seekbar, scrollHighAngleY_seekbar,scrollLowAngleX_seekbar, scrollLowAngleY_seekbar;
    private TextView scrollHighSpeedRoll_Text, scrollHighSpeedPitch_Text, scrollLowSpeedRoll_Text,scrollLowSpeedPitch_Text, scrollHighAngleRoll_Text, scrollHighAnglePitch_Text,scrollLowAngleRoll_Text, scrollLowAnglePitch_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolllayout);

        //Creating sharedPreferences for the seekbars
        //For High Speed
        SharedPreferences highSpeedX_scroll = getApplicationContext().getSharedPreferences("HighScrollSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedXEdit = highSpeedX_scroll.edit();

        SharedPreferences highSpeedY_scroll = getApplicationContext().getSharedPreferences("HighScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedYEdit = highSpeedY_scroll.edit();

        //For Low Speed
        SharedPreferences lowSpeedX_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedXEdit = lowSpeedX_scroll.edit();

        SharedPreferences lowSpeedY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedYEdit = lowSpeedY_scroll.edit();

        //For High speed Angle
        SharedPreferences highAngleX_scroll = getApplicationContext().getSharedPreferences("HighScrollAngleX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleXEdit = highAngleX_scroll.edit();

        SharedPreferences highAngleY_scroll = getApplicationContext().getSharedPreferences("HighScrollAngleY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleYEdit = highAngleY_scroll.edit();

        //For Low speed Angle
        SharedPreferences lowAngleX_scroll = getApplicationContext().getSharedPreferences("LowScrollAngleX", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowAngleXEdit = lowAngleX_scroll.edit();

        SharedPreferences lowAngleY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollHighSpeedX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollHighSpeedXEdit.putInt("scrollSpeedValue",scrollHighSpeedX_seekbar.getProgress());
                scrollHighSpeedXEdit.apply();
            }
        });

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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollHighSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollHighSpeedYEdit.putInt("scrollSpeedValue",scrollHighSpeedY_seekbar.getProgress());
                scrollHighSpeedYEdit.apply();
            }
        });


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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollLowSpeedX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollLowSpeedXEdit.putInt("scrollSpeedValue",scrollLowSpeedX_seekbar.getProgress());
                scrollLowSpeedXEdit.apply();
            }
        });

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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollLowSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollLowSpeedYEdit.putInt("scrollSpeedValue",scrollLowSpeedY_seekbar.getProgress());
                scrollLowSpeedYEdit.apply();
            }
        });

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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollHighAngleX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollHighAngleXEdit.putInt("scrollSpeedValue",scrollHighAngleX_seekbar.getProgress());
                scrollHighAngleXEdit.apply();
            }
        });

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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollHighAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollHighAngleYEdit.putInt("scrollSpeedValue",scrollHighAngleY_seekbar.getProgress());
                scrollHighAngleYEdit.apply();
            }
        });

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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollLowAngleX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollLowAngleXEdit.putInt("scrollSpeedValue",scrollLowAngleX_seekbar.getProgress());
                scrollLowAngleXEdit.apply();
            }
        });

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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollLowAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollLowAngleYEdit.putInt("scrollSpeedValue",scrollLowAngleY_seekbar.getProgress());
                scrollLowAngleYEdit.apply();
            }
        });

    }
}
