package aau.g202.p2_gesturebasedinteraction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.security.Permission;

import static aau.g202.p2_gesturebasedinteraction.R.layout.activity_main;
import static aau.g202.p2_gesturebasedinteraction.R.layout.activity_mainmenu;

public class MainMenu extends AppCompatActivity {

    private static final int PERMISSION = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        if (!android.provider.Settings.canDrawOverlays(this)) {

            startActivity(new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
        }

        ImageButton settings= (ImageButton)findViewById(R.id.settings);
        Button start = (Button)findViewById(R.id.start);
        Button tutorial = (Button)findViewById(R.id.tutorial);



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