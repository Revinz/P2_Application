package aau.g202.p2_gesturebasedinteraction;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TutorialActivity extends AppCompatActivity {


    private AnimationDrawable gifs[] = new AnimationDrawable[10];
    ImageView gifView;

    private String[] gifTexts = new String[10];
    TextView gifTex
    private int currImageNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        gifView = findViewById(R.id.gifView);
    }

    //Show the next image
    private void NextImage() {
        currImageNumber++;
    }

    //Show the previous image
    private void PrevImage() {
        currImageNumber--;
    }

    // Stops all the gifs
    private void StopAllGifs() {

    }

    // Shows the gif
    private void ShowGif(int index) {

        if (index >= gifs.length)
            return;



    }

}
