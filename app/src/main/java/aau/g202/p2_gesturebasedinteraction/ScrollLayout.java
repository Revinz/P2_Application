package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

public class ScrollLayout extends AppCompatActivity {
    public SeekBar scrollHighSpeedY_seekbar, scrollLowSpeedY_seekbar, scrollHighAngleY_seekbar,scrollLowAngleY_seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolllayout);

        //Creating sharedPreferences for the seekbars
        //For High Speed
        final SharedPreferences highSpeedY_scroll = getApplicationContext().getSharedPreferences("HighScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedYEdit = highSpeedY_scroll.edit();

        //For Low Speed
        final SharedPreferences lowSpeedY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedYEdit = lowSpeedY_scroll.edit();

        //For High speed Angle
        final SharedPreferences highAngleY_scroll = getApplicationContext().getSharedPreferences("HighScrollAngleY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleYEdit = highAngleY_scroll.edit();

        //For Low speed Angle
        final SharedPreferences lowAngleY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowAngleYEdit = lowAngleY_scroll.edit();


        //casting variables for the seekbars
        scrollHighSpeedY_seekbar = findViewById(R.id.scrollHighSpeedY_seekbar);
        scrollLowSpeedY_seekbar = findViewById(R.id.scrollLowSpeedY_seekbar);
        scrollHighAngleY_seekbar = findViewById(R.id.scrollHighAngleY_seekbar);
        scrollLowAngleY_seekbar = findViewById(R.id.scrollLowAngleY_seekbar);

        //To detect change on scrollHighSpeedY_seekbar
        scrollHighSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollHighSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollHighSpeedYEdit.putFloat("SHSY",scrollHighSpeedY_seekbar.getProgress());
                scrollHighSpeedYEdit.apply();

                //To get data use getFloatScrollSpeed(highSpeedY_scroll,"SHSY")
                ScrollMode.RetrieveSettings();
            }
        });

        //To detect change on scrollLowSpeedY_seekbar
        scrollLowSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(ScrollLayout.this, "Value: " + progress + "/"+ scrollLowSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                scrollLowSpeedYEdit.putFloat("SLSY",scrollLowSpeedY_seekbar.getProgress());
                scrollLowSpeedYEdit.apply();

                //To get data use getFloatScrollSpeed(lowSpeedY_scroll,"SLSY")
                ScrollMode.RetrieveSettings();
            }
        });

        //To detect change on scrollHighAngleY_seekbar
        scrollHighAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 5;

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
                scrollHighAngleYEdit.putFloat("SHAY",scrollHighAngleY_seekbar.getProgress());
                scrollHighAngleYEdit.apply();

                //To get data use getFloatScrollAngle(highAngleY_scroll,"SHAY")
                ScrollMode.RetrieveSettings();
            }
        });

        //To detect change on scrollLowAngleY_seekbar
        scrollLowAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            //Setting start progress
            int progress = 5;

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
                scrollLowAngleYEdit.putFloat("SLAY",scrollLowAngleY_seekbar.getProgress());
                scrollLowAngleYEdit.apply();

                //To get data use getFloatScrollAngle(lowAngleY_scroll,"SLAY")
                ScrollMode.RetrieveSettings();
            }
        });

    }

    public float getFloatScrollSpeed(SharedPreferences Data_pref, String key){
        return Data_pref.getFloat(key,0)/10;
    }

    public float getFloatScrollAngle(SharedPreferences Data_pref, String key){
        return Data_pref.getFloat(key,0)/100;
    }
}
