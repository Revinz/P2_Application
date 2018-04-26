package aau.g202.p2_gesturebasedinteraction;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class Settings extends AppCompatActivity {

    //initializing variables
    SeekBar cursor_seekbar, scroll_seekbar;
    ImageButton dot_button, cursor_button, circle_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //casting variables
        scroll_seekbar = (SeekBar) findViewById(R.id.scroll_seekbar);
        cursor_seekbar = (SeekBar) findViewById(R.id.cursor_seekbar);
        dot_button = (ImageButton) findViewById(R.id.dot_button);
        cursor_button = (ImageButton) findViewById(R.id.cursor_button);
        circle_button = (ImageButton) findViewById(R.id.circle_button);

        //three image button
        //one method for selecting different cursor's
        //one-two methods for sensitivy
    }
}
