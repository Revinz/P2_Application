package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.SeekBar;
import android.widget.Toast;

public class ScrollLayout extends Settings{
    private SeekBar scrollHighSpeedY_seekbar, scrollLowSpeedY_seekbar, scrollHighAngleY_seekbar,scrollLowAngleY_seekbar;
    public static int SHSY, SLSY, SHAY, SLAY;

    public static SharedPreferences prefsScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolllayout);

        prefsScroll = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        //Creating sharedPreferences for the seekbars
        //For High Speed
        SharedPreferences highSpeedY_scroll = getApplicationContext().getSharedPreferences("HighScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighSpeedYEdit = highSpeedY_scroll.edit();

        //For Low Speed
        SharedPreferences lowSpeedY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollLowSpeedYEdit = lowSpeedY_scroll.edit();

        //For High speed Angle
        SharedPreferences highAngleY_scroll = getApplicationContext().getSharedPreferences("HighScrollAngleY", MODE_PRIVATE);
        final SharedPreferences.Editor scrollHighAngleYEdit = highAngleY_scroll.edit();

        //For Low speed Angle
        SharedPreferences lowAngleY_scroll = getApplicationContext().getSharedPreferences("LowScrollSpeedY", MODE_PRIVATE);
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
                scrollHighSpeedYEdit.putInt("scrollSpeedValue",scrollHighSpeedY_seekbar.getProgress());
                scrollHighSpeedYEdit.apply();
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
                scrollLowSpeedYEdit.putInt("scrollSpeedValue",scrollLowSpeedY_seekbar.getProgress());
                scrollLowSpeedYEdit.apply();
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
                scrollHighAngleYEdit.putInt("scrollSpeedValue",scrollHighAngleY_seekbar.getProgress());
                scrollHighAngleYEdit.apply();
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
                scrollLowAngleYEdit.putInt("scrollSpeedValue",scrollLowAngleY_seekbar.getProgress());
                scrollLowAngleYEdit.apply();
            }
        });

    }


    public static int getSHSY (){
        SHSY = prefsScroll.getInt("HighScrollSpeedYValue", 0);
        return SHSY;
    }

    public static int getSLSY (){
        SLSY = prefsScroll.getInt("LowScrollSpeedYValue", 0);
        return SLSY;
    }

    public static int getSHAY (){
        SHAY = prefsScroll.getInt("HighScrollAngleYValue", 0);
        return SHAY;
    }

    public static int getSLAY (){
        SLAY = prefsScroll.getInt("LowScrollAngleYValue", 0);
        return SLAY;
    }
}
