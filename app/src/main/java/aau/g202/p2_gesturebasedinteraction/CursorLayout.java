package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class CursorLayout extends Settings implements View.OnClickListener{
    private SeekBar cursorHighSpeedX_seekbar, cursorHighSpeedY_seekbar, cursorLowSpeedX_seekbar, cursorLowSpeedY_seekbar, cursorHighAngleX_seekbar, cursorHighAngleY_seekbar,cursorLowAngleX_seekbar, cursorLowAngleY_seekbar;
    public static int cursor_image = 0;
    public static int CHSX, CHSY, CLSX, CLSY, CHAX, CHAY, CLAX, CLAY;
    public static SharedPreferences prefsCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursorlayout);

        prefsCursor = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        //Creating sharedPreferences for the seekbars
        //For High Speed
        SharedPreferences highSpeedX_cursor = getApplicationContext().getSharedPreferences("HighCursorSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighSpeedXEdit = highSpeedX_cursor.edit();

        SharedPreferences highSpeedY_cursor = getApplicationContext().getSharedPreferences("HighCursorSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighSpeedYEdit = highSpeedY_cursor.edit();

        //For Low Speed
        SharedPreferences lowSpeedX_cursor = getApplicationContext().getSharedPreferences("LowCursorSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowSpeedXEdit = lowSpeedX_cursor.edit();

        SharedPreferences lowSpeedY_cursor = getApplicationContext().getSharedPreferences("LowCursorSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowSpeedYEdit = lowSpeedY_cursor.edit();

        //For High speed Angle
        SharedPreferences highAngleX_cursor = getApplicationContext().getSharedPreferences("HighCursorAngleX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighAngleXEdit = highAngleX_cursor.edit();

        SharedPreferences highAngleY_cursor = getApplicationContext().getSharedPreferences("HighCursorAngleY", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighAngleYEdit = highAngleY_cursor.edit();

        //For Low speed Angle
        SharedPreferences lowAngleX_cursor = getApplicationContext().getSharedPreferences("LowCursorAngleX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowAngleXEdit = lowAngleX_cursor.edit();

        SharedPreferences lowAngleY_cursor = getApplicationContext().getSharedPreferences("LowCursorSpeedY", MODE_PRIVATE);
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

        //To detect change on cursorHighSpeedX_seekbar
        cursorHighSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighSpeedX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                cursorHighSpeedXEdit.putInt("cursorSpeedValue",cursorHighSpeedX_seekbar.getProgress());
                cursorHighSpeedXEdit.apply();
            }
        });

        //To detect change on cursorHighSpeedY_seekbar
        cursorHighSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                cursorHighSpeedYEdit.putInt("cursorSpeedValue",cursorHighSpeedY_seekbar.getProgress());
                cursorHighSpeedYEdit.apply();
            }
        });


        //To detect change on cursorLowSpeedX_seekbar
        cursorLowSpeedX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowSpeedX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                cursorLowSpeedXEdit.putInt("cursorSpeedValue",cursorLowSpeedX_seekbar.getProgress());
                cursorLowSpeedXEdit.apply();
            }
        });

        //To detect change on cursorLowSpeedY_seekbar
        cursorLowSpeedY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowSpeedY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                cursorLowSpeedYEdit.putInt("cursorSpeedValue",cursorLowSpeedY_seekbar.getProgress());
                cursorLowSpeedYEdit.apply();
            }
        });

        //To detect change on cursorHighAngleX_seekbar
        cursorHighAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighAngleX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                cursorHighAngleXEdit.putInt("cursorSpeedValue",cursorHighAngleX_seekbar.getProgress());
                cursorHighAngleXEdit.apply();
            }
        });

        //To detect change on cursorHighAngleY_seekbar
        cursorHighAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorHighAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                cursorHighAngleYEdit.putInt("cursorSpeedValue",cursorHighAngleY_seekbar.getProgress());
                cursorHighAngleYEdit.apply();
            }
        });

        //To detect change on cursorLowAngleX_seekbar
        cursorLowAngleX_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowAngleX_seekbar.getMax(), Toast.LENGTH_SHORT).show();
                cursorLowAngleXEdit.putInt("cursorSpeedValue",cursorLowAngleX_seekbar.getProgress());
                cursorLowAngleXEdit.apply();
            }
        });

        //To detect change on cursorLowAngleY_seekbar
        cursorLowAngleY_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
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
                Toast.makeText(CursorLayout.this, "Value: " + progress + "/"+ cursorLowAngleY_seekbar.getMax(), Toast.LENGTH_SHORT).show();
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
    public static int getCursor_image(){
        return cursor_image;
    }

    public static int getCHSX (){
        CHSX = prefsCursor.getInt("HighCursorSpeedXValue", 0);
        return CHSX;
    }

    public static int getCHSY (){
        CHSY = prefsCursor.getInt("HighCursorSpeedYValue", 0);
        return CHSY;
    }

    public static int getCLSX (){
        CLSX = prefsCursor.getInt("LowCursorSpeedXValue", 0);
        return CLSX;
    }

    public static int getCLSY (){
        CLSY = prefsCursor.getInt("LowCursorSpeedYValue", 0);
        return CLSY;
    }

    public static int getCHAX (){
        CHAX = prefsCursor.getInt("HighCursorAngleXValue", 0);
        return CHAX;
    }

    public static int getCHAY (){
        CHAY = prefsCursor.getInt("HighCursorAngleYValue", 0);
        return CHAY;
    }

    public static int getCLAX (){
        CLAX = prefsCursor.getInt("LowCursorAngleXValue", 0);
        return CLAX;
    }

    public static int getCLAY (){
        CLAY = prefsCursor.getInt("LowCursorAngleYValue", 0);
        return CLAY;
    }

}