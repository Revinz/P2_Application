package aau.g202.p2_gesturebasedinteraction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    //initializing variables
    private Switch AutoTurnOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,new MainSettingsFragment()).commit();


        SharedPreferences turnOnAuto = getApplicationContext().getSharedPreferences("TurnOnB", MODE_PRIVATE);
        final SharedPreferences.Editor AutoTurnOnEdit = turnOnAuto.edit();



        //Casting variables for the switch
        //AutoTurnOn = findViewById(R.id.LightSensor_Switch);


        //To detect change on the switch
        AutoTurnOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                AutoTurnOnEdit.putBoolean("LightSensorValue",AutoTurnOn.isChecked());
                AutoTurnOnEdit.apply();
            }
        });
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

