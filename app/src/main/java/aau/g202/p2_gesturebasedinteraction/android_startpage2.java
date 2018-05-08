package aau.g202.p2_gesturebasedinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class android_startpage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_startpage2);

        setContentView(R.layout.content_layout_id);


        //to facebook
        final button buttun3 = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
                setContentView(R.layout.content_layout_id);

                //to game
                final Button button2 = findViewById(R.id.button_id);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Code here executes on main thread after user presses button
                    }

                        //to app
                        setContentView(R.layout.content_layout_id);

                        final Button button = findViewById(R.id.button_id);
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                // Code here executes on main thread after user presses button
                            }
            }
}
