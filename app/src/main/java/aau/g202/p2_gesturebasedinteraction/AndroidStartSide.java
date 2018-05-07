package aau.g202.p2_gesturebasedinteraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AndroidStartSide extends AppCompatActivity
{

    button b_facebook, b_game, b_app;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.AndroidStartSide);

        b_facebook.setOnClickLestener(new View.OnClickListener()
        {
        public void onClick(view v)
        {
            //go to face
        }


    });

    b_game.setOnClickLestener(new View.OnClickListener()
    {
        public void onClick(view v)
        {
            //go to game
        }


    });

    b_app.setOnClickLestener(new View.OnClickListener()
        {
    public void onClick(view v)
        {
        //go to back in the app
        }


        });
        }

}
