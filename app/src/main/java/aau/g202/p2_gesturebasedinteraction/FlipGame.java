package aau.g202.p2_gesturebasedinteraction;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FlipGame extends AppCompatActivity {

    ImageButton topLeft, topRight, botLeft, botRight;
    TextView WinText;

    boolean secondFlip = false;
    ImageButton firstFlippedCard;

    ImageButton[] FlippedCards = new ImageButton[4];
    public static Activity flipGameAct;
    int pairsFound = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_game);

        Log.w("OnCreate - FLIPGAME", "Called");

        WinText = findViewById(R.id.wintext);
        WinText.setVisibility(View.INVISIBLE);

        //Find the image buttons
        topLeft = findViewById(R.id.topleft);
        topRight = findViewById(R.id.topright);
        botLeft = findViewById(R.id.botleft);
        botRight = findViewById(R.id.botright);

        flipGameAct = this;
        //Set all the images to be black
        SetAllBlack();


    }


    //The onClick methods to flip the colors of the images
    //TODO: REFACTOR THIS LATER!!

    public void TopLeftSquareClicked(View v) {

        Flip(topLeft, Color.RED, 0);
    }

    public void TopRightSquareClicked(View v) {

        Flip(topRight, Color.BLUE, 1);

    }

    public void BotLeftSquareClicked(View v) {

        Flip(botLeft, Color.BLUE, 2);

    }

    public void BotRightSquareClicked(View v) {

        Flip(botRight, Color.RED, 3);

    }

    //Flips the card if it isn't already flipped.
    void Flip(ImageButton button, int color, int Index) {
        if (CheckIfAlreadyFlipped(button))
            return;

        button.setBackgroundColor(color);
        FlippedCards[Index] = button; //Add the flipped tile to the array of flipped cards
        CheckIfSecondFlip(button);
    }

    //Checks if it is the second flip
    void CheckIfSecondFlip(ImageButton secondFlippedCard) {

        //If it is the second flip, check if the flipped cards are matching
        if (secondFlip) {
            secondFlip = false;
            CheckIfCorrect(firstFlippedCard, secondFlippedCard);
        }

        //Else it is the first flipped card
        else {
            firstFlippedCard = secondFlippedCard;
            secondFlip = true;
        }
    }

    //Checks if the tile is already flipped
    boolean CheckIfAlreadyFlipped(ImageButton _card) {
        for (ImageButton card : FlippedCards)
            if (card == _card)
                return true;


        return false;
    }

    //Sets all the images to black and set them to not flipped them
    void SetAllBlack() {
        topLeft.setBackgroundColor(Color.BLACK);
        topRight.setBackgroundColor(Color.BLACK);
        botLeft.setBackgroundColor(Color.BLACK);
        botRight.setBackgroundColor(Color.BLACK);
    }

    void CheckIfCorrect(ImageButton firstFlipped, ImageButton secondFlipped) {

        ColorDrawable first = (ColorDrawable)firstFlipped.getBackground();
        ColorDrawable second = (ColorDrawable)secondFlipped.getBackground();


        if (first.getColor() == second.getColor()) {
            pairsFound++;
            firstFlippedCard = null;
        }

        else if (first.getColor() != second.getColor()) {
            //Set the background back to black
            firstFlipped.setBackgroundColor(Color.BLACK);
            secondFlipped.setBackgroundColor(Color.BLACK);

            Toast.makeText(this, "Wrong! Try again!", Toast.LENGTH_SHORT).show();

            //Remove them from the flipped cards
            for (int i = 0; i < FlippedCards.length; i++)
                if (FlippedCards[i] == firstFlipped || FlippedCards[i] == secondFlipped)
                    FlippedCards[i] = null;

            //Reset the first flipped card
            firstFlippedCard = null;
            return;
        }

        //Check if the player got both of the pairs
        if (pairsFound >= 2)
            Won();


    }

    void Won() {
        WinText.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ControlMode.currActivity = this;
    }
}
