package aau.g202.p2_gesturebasedinteraction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static aau.g202.p2_gesturebasedinteraction.R.layout.activity_main;
import static aau.g202.p2_gesturebasedinteraction.R.layout.activity_mainmenu;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        ImageButton settings= (ImageButton)findViewById(R.id.settings);
        Button start = (Button)findViewById(R.id.start);
        Button tutorial = (Button)findViewById(R.id.tutorial);



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.SYSTEM_ALERT_WINDOW}, 1);
        }

        //Setup the sensors and modes
        //Lightsensor ls = new Lightsensor(this);
        Accelerometer accelerometer = new Accelerometer(this);
        ControlMode modes = new SelectMode(this, this);
        ControlMode ScrollMode = new ScrollMode(this, this);

        ControlMode.currActivity = this;

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
               Intent openSettings = new Intent(MainMenu.this, Settings.class);
               startActivity(openSettings);

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent start = new Intent(MainMenu.this, FacebookScroll.class);
                startActivity(start);

            }
        });

        tutorial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
               // Intent openTutorial = new Intent(MainMenu.this, TutorialActivity.class);
               // startActivity(openTutorial);

            }
        });
    }

}