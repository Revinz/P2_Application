package aau.g202.p2_gesturebasedinteraction;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Settings extends AppCompatActivity implements View.OnClickListener{

    //initializing variables
    SeekBar cursor_seekbar, scroll_seekbar;
    ImageButton dot_button, cursor_button, circle_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //casting variables
        scroll_seekbar = findViewById(R.id.scroll_seekbar);
        cursor_seekbar = findViewById(R.id.cursor_seekbar);
        dot_button = findViewById(R.id.dot_button);
        cursor_button = findViewById(R.id.cursor_button);
        circle_button = findViewById(R.id.circle_button);

        //Setting on click listeners to the image buttons
        dot_button.setOnClickListener(this);
        cursor_button.setOnClickListener(this);
        circle_button.setOnClickListener(this);

        //To detect change on scroll_seekbar
        scroll_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
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

            }
        });

        //To detect change on cursor_seekbar
        cursor_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
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
