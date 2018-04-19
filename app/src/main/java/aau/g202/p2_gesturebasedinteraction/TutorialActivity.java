package aau.g202.p2_gesturebasedinteraction;

import android.graphics.drawable.AnimationDrawable;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TutorialActivity extends AppCompatActivity {

        // Read information about AnimationDrawable at
        // https://developer.android.com/reference/android/graphics/drawable/AnimationDrawable.html
        private AnimationDrawable gifs[] = new AnimationDrawable[5];
        ImageView gifView;

        private int currImageNumber = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tutorial);

            ImageView gifView = findViewById(R.id.gifView);
            gifView.setBackgroundResource(R.drawable.testgif);

            //Get the background -- which consists of multiple images.
            gifs[0] = (AnimationDrawable)gifView.getBackground();

            Button bnNext = findViewById(R.id.bnNext);
            Button bnPrev = findViewById(R.id.bnPrev);





        }

        @Override
        public void onStart() {
            super.onStart();
            gifs[0].start(); //Play the gif.
        }


        //Show the next image
        public void NextImage(View v) {

            currImageNumber++;
            Log.v("Test", "NextImage");
        }

        //Show the previous image
        public void PrevImage(View v) {
            Log.v("Test", "PrevImage");
            currImageNumber--;
        }

        // Stops all the gifs
        private void StopAllGifs() {

        }

        // Shows the gif
        private void ShowGif() {

            if (currImageNumber >= gifs.length)
                return;

        }

}
