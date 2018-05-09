package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

public class ScrollLayout extends AppCompatActivity {
    static SharedPreferences highSpeedY_scroll, lowSpeedY_scroll, highAngleY_scroll, lowAngleY_scroll;
    public SeekBar scrollHighSpeedY_seekbar, scrollLowSpeedY_seekbar, scrollHighAngleY_seekbar,scrollLowAngleY_seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolllayout);

        //Creating sharedPreferences for the seekbars
        //For High Speed
        highSpeedY_scroll = getApplicationContext().getSharedPreferences("HighScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedYEdit = highSpeedY_scroll.edit();

        //For Low Speed
        lowSpeedY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedYEdit = lowSpeedY_scroll.edit();

        //For High speed Angle
        highAngleY_scroll = getApplicationContext().getSharedPreferences("HighScrollAngleY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleYEdit = highAngleY_scroll.edit();

        //For Low speed Angle
        lowAngleY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
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

                //To get data use gethighSpeedY_scroll()
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

                //To get data use getlowSpeedY_scroll()
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

                //To get data use gethighAngleY_scroll()
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

                //To get data use getlowAngleY_scroll()
                ScrollMode.RetrieveSettings();
            }
        });

    }

    public static float gethighSpeedY_scroll(){
        return highSpeedY_scroll.getFloat("SHSY",0)/10;
    }

    public static float getlowSpeedY_scroll(){
        return lowSpeedY_scroll.getFloat("SLSY",0)/10;
    }

    public static float gethighAngleY_scroll(){
        return highAngleY_scroll.getFloat("SHAY",0)/100;
    }

    public static float getlowAngleY_scroll(){
        return lowAngleY_scroll.getFloat("SLAY",0)/100;
    }
}
