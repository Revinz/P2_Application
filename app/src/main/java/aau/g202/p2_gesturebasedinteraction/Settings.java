package aau.g202.p2_gesturebasedinteraction;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

public class Settings extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,new MainSettingsFragment()).commit();
    }

    public static class MainSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}

    //TODO (Niklas): Missing sensitivity for high speed and high speed angle
    //TODO: AND getters for access to the settings in other classes.

    /** Make sure to have all of these as settings **/

    // low speed -- both for x (roll) and y (pitch)

    // high speed -- both for x (roll) and y (pitch)

    // low speed angle -- both for x (roll) and y (pitch)

    // high speed angle -- both for x (roll) and y (pitch)

    // Total: 8 sensitivity settings


    /******* GETTERS *******/

    // Insert getters here

