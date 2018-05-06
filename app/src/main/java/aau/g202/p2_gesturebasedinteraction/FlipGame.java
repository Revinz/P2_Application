package aau.g202.p2_gesturebasedinteraction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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

    int pairsFound = 0;

    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_game);

        WinText = findViewById(R.id.wintext);
        WinText.setVisibility(View.INVISIBLE);

        //Find the image buttons
        topLeft = findViewById(R.id.topleft);
        topRight = findViewById(R.id.topright);
        botLeft = findViewById(R.id.botleft);
        botRight = findViewById(R.id.botright);

        //Set all the images to be black
        SetAllBlack();

        rootView = topRight.getRootView();
        rootView.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                Log.w("Select", "Selected!");
                return false;
            }
        });



    }


    //The onClick methods to flip the colors of the images
    //TODO: REFACTOR THIS LATER!!

    public void TopLeftSquareClicked(View v) {
        if (CheckIfAlreadyFlipped(topLeft))
          return;

        topLeft.setBackgroundColor(Color.RED);
        FlippedCards[0] = topLeft;
        CheckIfSecondFlip(topLeft);

    }

    public void TopRightSquareClicked(View v) {
        if (CheckIfAlreadyFlipped(topRight))
            return;

        topRight.setBackgroundColor(Color.BLUE);
        FlippedCards[1] = topRight;
        CheckIfSecondFlip(topRight);
    }

    public void BotLeftSquareClicked(View v) {

        SelectMode.select(rootView);

        if (CheckIfAlreadyFlipped(botLeft))
            return;

        botLeft.setBackgroundColor(Color.BLUE);
        FlippedCards[2] = botLeft;
        CheckIfSecondFlip(botLeft);
    }

    public void BotRightSquareClicked(View v) {
        if (CheckIfAlreadyFlipped(botRight))
            return;

        botRight.setBackgroundColor(Color.RED);
        FlippedCards[3] = botRight;
        CheckIfSecondFlip(botRight);
    }


    void CheckIfSecondFlip(ImageButton secondFlippedCard) {
        if (secondFlip) {
            secondFlip = false;
            CheckIfCorrect(firstFlippedCard, secondFlippedCard);
        }

        else {
            firstFlippedCard = secondFlippedCard;
            secondFlip = true;
        }
    }

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

}
