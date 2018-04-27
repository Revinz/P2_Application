package aau.g202.p2_gesturebasedinteraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static aau.g202.p2_gesturebasedinteraction.R.layout.activity_mainmenu;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_mainmenu);
        setContentView(R.layout.activity_main);
    }

}