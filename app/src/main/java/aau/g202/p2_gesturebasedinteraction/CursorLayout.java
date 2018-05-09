package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class CursorLayout extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences highSpeedX_cursor, highSpeedY_cursor, lowSpeedX_cursor, lowSpeedY_cursor, highAngleX_cursor, highAngleY_cursor, lowAngleX_cursor, lowAngleY_cursor;
    private SeekBar cursorHighSpeedX_seekbar, cursorHighSpeedY_seekbar, cursorLowSpeedX_seekbar, cursorLowSpeedY_seekbar, cursorHighAngleX_seekbar, cursorHighAngleY_seekbar,cursorLowAngleX_seekbar, cursorLowAngleY_seekbar;
    public static int cursor_image = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursorlayout);


        //Creating sharedPreferences for the seekbars
        //For High Speed
        highSpeedX_cursor = getApplicationContext().getSharedPreferences("HighCursorSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighSpeedXEdit = highSpeedX_cursor.edit();

        highSpeedY_cursor = getApplicationContext().getSharedPreferences("HighCursorSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighSpeedYEdit = highSpeedY_cursor.edit();

        //For Low Speed
        lowSpeedX_cursor = getApplicationContext().getSharedPreferences("LowCursorSpeedX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowSpeedXEdit = lowSpeedX_cursor.edit();

        lowSpeedY_cursor = getApplicationContext().getSharedPreferences("LowCursorSpeedY", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowSpeedYEdit = lowSpeedY_cursor.edit();

        //For High speed Angle
        highAngleX_cursor = getApplicationContext().getSharedPreferences("HighCursorAngleX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighAngleXEdit = highAngleX_cursor.edit();

        highAngleY_cursor = getApplicationContext().getSharedPreferences("HighCursorAngleY", MODE_PRIVATE);
        final SharedPreferences.Editor cursorHighAngleYEdit = highAngleY_cursor.edit();

        //For Low speed Angle
        lowAngleX_cursor = getApplicationContext().getSharedPreferences("LowCursorAngleX", MODE_PRIVATE);
        final SharedPreferences.Editor cursorLowAngleXEdit = lowAngleX_cursor.edit();

        lowAngleY_cursor = getApplicationContext().getSharedPreferences("LowCursorSpeedY", MODE_PRIVATE);
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
                cursorHighSpeedXEdit.putFloat("CHSX",cursorHighSpeedX_seekbar.getProgress());
                cursorHighSpeedXEdit.apply();

                //To get data use gethighSpeedX_cursor()
                SelectMode.RetrieveSettings();
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
                cursorHighSpeedYEdit.putFloat("CHSY",cursorHighSpeedY_seekbar.getProgress());
                cursorHighSpeedYEdit.apply();

                //To get data use gethighSpeedY_cursor()
                SelectMode.RetrieveSettings();
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
                cursorLowSpeedXEdit.putFloat("CLSX",cursorLowSpeedX_seekbar.getProgress());
                cursorLowSpeedXEdit.apply();

                //To get data use getlowSpeedX_cursor()
                SelectMode.RetrieveSettings();
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
                cursorLowSpeedYEdit.putFloat("CLSY",cursorLowSpeedY_seekbar.getProgress());
                cursorLowSpeedYEdit.apply();

                //To get data use getlowSpeedY_cursor()
                SelectMode.RetrieveSettings();
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
                cursorHighAngleXEdit.putFloat("CHAX",cursorHighAngleX_seekbar.getProgress());
                cursorHighAngleXEdit.apply();

                //To get data use gethighAngleX_cursor()
                SelectMode.RetrieveSettings();
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
                cursorHighAngleYEdit.putFloat("CHAY",cursorHighAngleY_seekbar.getProgress());
                cursorHighAngleYEdit.apply();

                //To get data use gethighAngleY_cursor()
                SelectMode.RetrieveSettings();
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
                cursorLowAngleXEdit.putFloat("CLAX",cursorLowAngleX_seekbar.getProgress());
                cursorLowAngleXEdit.apply();

                //To get data use getlowAngleX_cursor()
                SelectMode.RetrieveSettings();
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
                cursorLowAngleYEdit.putFloat("CLAY",cursorLowAngleY_seekbar.getProgress());
                cursorLowAngleYEdit.apply();

                //To get data use getlowAngleY_cursor()
                SelectMode.RetrieveSettings();
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

    public float gethighSpeedX_cursor(){
        return highSpeedX_cursor.getFloat("CHSX",0)/10;
    }

    public float gethighSpeedY_cursor(){
        return highSpeedY_cursor.getFloat("CHSY",0)/10;
    }

    public float getlowSpeedX_cursor(){
        return lowSpeedX_cursor.getFloat("CLSX",0)/10;
    }

    public float getlowSpeedY_cursor(){
        return lowSpeedY_cursor.getFloat("CLSY",0)/10;
    }

    public float gethighAngleX_cursor(){
        return highAngleX_cursor.getFloat("CHAX",0)/100;
    }

    public float gethighAngleY_cursor(){
        return highAngleY_cursor.getFloat("CHAY",0)/100;
    }

    public float getlowAngleX_cursor(){
        return lowAngleX_cursor.getFloat("CLAX",0)/100;
    }

    public float getlowAngleY_cursor(){
        return highAngleY_cursor.getFloat("CLAY",0)/100;
    }



    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
    }

}