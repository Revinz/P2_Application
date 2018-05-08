package aau.g202.p2_gesturebasedinteraction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.security.Permission;

import static aau.g202.p2_gesturebasedinteraction.R.layout.activity_main;
import static aau.g202.p2_gesturebasedinteraction.R.layout.activity_mainmenu;

public class MainMenu extends AppCompatActivity {

    private static final int PERMISSION = 15;
    ImageButton settings;
    Button start;
    Button tutorial ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        try {
            if (!android.provider.Settings.canDrawOverlays(this)) {
                startActivity(new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error checking for permissions", Toast.LENGTH_SHORT).show();
        }


        settings= (ImageButton)findViewById(R.id.settings);
        start = (Button)findViewById(R.id.start);
        tutorial = (Button)findViewById(R.id.tutorial);

        Log.w("OnCreate", "Called");

        //Setup the sensors and modes

        try {
            //Lightsensor ls = new Lightsensor(this);
            Accelerometer accelerometer = new Accelerometer(this);
        } catch (Exception e) {
            Toast.makeText(this, "Error setting up accelerometer", Toast.LENGTH_SHORT).show();
        }

        try {
            //Lightsensor ls = new Lightsensor(this);
            ControlMode modes = new SelectMode(this, this);
            ControlMode ScrollMode = new ScrollMode(this, this);
        } catch (Exception e) {
            Toast.makeText(this, "Error setting up control modes", Toast.LENGTH_SHORT).show();
        }


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

                Intent start = new Intent(MainMenu.this, FlipGame.class);
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

    protected void onResume() {
        Log.w("OnResume", "Called");
        ControlMode.currActivity  = this;
        super.onResume();


    }

}