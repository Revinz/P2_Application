package aau.g202.p2_gesturebasedinteraction;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class TutorialActivity extends AppCompatActivity {

        //Update this number and the SetupGifReference when adding/removing gifs
        int totalGifs = 4; //The total amount of gifs

        // Read information about AnimationDrawable at
        // https://developer.android.com/reference/android/graphics/drawable/AnimationDrawable.html
        private AnimationDrawable gifs[] = new AnimationDrawable[totalGifs];
        private int[] gifReferences = new int[totalGifs]; //R.drawable._ references to the gifs, that are of type int
        ImageView gifView;
        Button bnPrev, bnNext;

        //The current gif image number
        private int currGifNumber = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tutorial);

            SetupGifReferences();

            bnPrev = findViewById(R.id.bnPrev);
            bnNext = findViewById(R.id.bnNext);

            gifView = findViewById(R.id.gifView);

            ControlMode.currActivity = this;

        }

        @Override
        protected void onStart() {
            super.onStart();
            ShowGif();
            gifs[0].start(); //Play the first gif on start.
        }

        //Setup all the gif references needed
        private void SetupGifReferences() {
            gifReferences[0] = R.drawable.selectmovement_gif;
            gifReferences[1] = R.drawable.select_gif;
            gifReferences[2] = R.drawable.switchmode_gif;
            gifReferences[3] = R.drawable.scroll_gif;

        }


        //Go to the next gif
        public void NextGif(View v) {
            if (currGifNumber < totalGifs - 1)
            {
                currGifNumber++;
                ShowGif();
            }
        }

        //Go back to the previous gif
        public void PrevGif(View v) {

            if (currGifNumber > 0)
            {
                currGifNumber--;
                ShowGif();
            }
        }


        // Stops all the gifs
        private void StopAllGifs() {

            for (AnimationDrawable gif : gifs) //For each gif in gifs -- stop the gif
                if (gif != null)
                    gif.stop();

        }

        // Shows the gif
        private void ShowGif() {
            //Stop all gifs
            StopAllGifs();

            //Set the XML file to be the background of the imageview
            gifView.setBackgroundResource(gifReferences[currGifNumber]);

            //Convert the background into an animation
            gifs[currGifNumber] = (AnimationDrawable)gifView.getBackground();

            gifs[currGifNumber].start(); // Plays the animation, except on start.
            updateButtons();

        }

        //Updates the color on the buttons
        void updateButtons() {
            if (currGifNumber <= 0) {
                bnPrev.setBackgroundColor(getApplicationContext().getColor(R.color.colorDisabled));
            }

            else if (currGifNumber >= totalGifs - 1)
                bnNext.setBackgroundColor(getApplicationContext().getColor(R.color.colorDisabled));

            else {
                bnNext.setBackgroundColor(getApplicationContext().getColor(R.color.colorPrimary));
                bnPrev.setBackgroundColor(getApplicationContext().getColor(R.color.colorPrimary));
            }
        }

}
