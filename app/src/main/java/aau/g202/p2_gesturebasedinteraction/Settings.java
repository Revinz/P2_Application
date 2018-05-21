package aau.g202.p2_gesturebasedinteraction;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    Button bnSelect, bnScroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bnSelect = findViewById(R.id.bnCursor);
        bnScroll = findViewById(R.id.bnScroll);


        bnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                bnSelect.setEnabled( false);
                Intent openSettings = new Intent(Settings.this, SimpleSettingsLayout.class);
                startActivity(openSettings);

            }
        });

        bnScroll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                bnScroll.setEnabled( false);
                Intent openSettings = new Intent(Settings.this, ScrollLayout.class);
                startActivity(openSettings);

            }
            });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
        bnScroll.setEnabled( true);
        bnSelect.setEnabled( true);
    }
}