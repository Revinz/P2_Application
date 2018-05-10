package aau.g202.p2_gesturebasedinteraction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class android_startpage2 extends AppCompatActivity {

    private Button button_facebook;
    private Button button_game;
    private Button button_app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_startpage2);

        button_facebook = (Button) findViewById(R.id.button2);
        button_game = (Button) findViewById(R.id.button3);
        button_app = (Button) findViewById(R.id.button);

        button_facebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });


        button_game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openGame();
            }
        });

        button_app.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openApp();
            }
        });

    }

    public void openFacebook() {
        button_facebook.setEnabled(false);
        Intent intent = new Intent(this, FacebookScroll.class);
        startActivity(intent);
    }

    public void openGame() {
        button_game.setEnabled(false);
        Intent intent = new Intent(this, FlipGame.class);
        startActivity(intent);
    }

    public void openApp() {
        button_game.setEnabled(false);
        this.finish();
        //Intent intent = new Intent(this, MainMenu.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        //startActivityIfNeeded(intent, 142); //random requestcode

    }

    @Override
    protected void onResume() {
        super.onResume();

        button_facebook.setEnabled(true);
        button_app.setEnabled(true);
        button_game.setEnabled(true);
        ControlMode.currActivity = this;
    }
}
