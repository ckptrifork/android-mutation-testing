package com.trifork.ckp.androidmutationtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    private SeekBar seekbarAngleA, seekbarAngleB;
    private TextView valueAngleA, valueAngleB, result;

    // Model
    private Angle angleA = new Angle(50);
    private Angle angleB = new Angle(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obtainViewReferences();
        defineViewBehaviour();
    }

    private void obtainViewReferences() {
        seekbarAngleA = (SeekBar) findViewById(R.id.seekbar_angle_a);
        seekbarAngleB = (SeekBar) findViewById(R.id.seekbar_angle_b);
        valueAngleA = (TextView) findViewById(R.id.value_angle_a);
        valueAngleB = (TextView) findViewById(R.id.value_angle_b);
        result = (TextView) findViewById(R.id.result);
    }

    private void defineViewBehaviour() {
        seekbarAngleA.setProgress(50);
        seekbarAngleB.setProgress(100);
        valueAngleA.setText(Integer.toString(50));
        valueAngleB.setText(Integer.toString(100));

        seekbarAngleA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueAngleA.setText(Integer.toString(progress));
                angleA = new Angle(progress);
                calculateResult();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbarAngleB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueAngleB.setText(Integer.toString(progress));
                angleB = new Angle(progress);
                calculateResult();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        calculateResult();
    }

    private void calculateResult() {
        String resultText = "";
        if (angleA.isGreaterThan(angleB)) {
            resultText = "A";
        } else if (angleB.isGreaterThan(angleA)) {
            resultText = "B";
        }
        result.setText(resultText);
    }
}
