package aau.g202.p2_gesturebasedinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;

public class FacebookScroll extends AppCompatActivity {

    public static ScrollView scrollView;
    public static ImageView botImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_scroll);

        ControlMode.currActivity = this;

        scrollView = findViewById(R.id.scrollViewFB);
        botImage = findViewById(R.id.botImageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
    }
}
