package aau.g202.p2_gesturebasedinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView AccelerometerReadings = findViewById(R.id.AcReadings);
        Accelerometer accelerometer = new Accelerometer(this, AccelerometerReadings);
        AccelerometerReadings.setText(accelerometer.toString());
    }
}
