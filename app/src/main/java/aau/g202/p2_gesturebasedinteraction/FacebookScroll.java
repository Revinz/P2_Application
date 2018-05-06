package aau.g202.p2_gesturebasedinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FacebookScroll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_scroll);

        ControlMode.currActivity = this;
    }
}
