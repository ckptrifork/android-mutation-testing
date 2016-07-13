package com.trifork.ckp.androidmutationtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Constants
    private static final int INITIAL_DEGREES_ANGLE_A = 50;
    private static final int INITIAL_DEGREES_ANGLE_B = 100;

    // Views
    private SeekBar seekBarAngleA, seekBarAngleB;
    private TextView valueAngleA, valueAngleB, result;

    // Model
    private Angle angleA = new Angle(INITIAL_DEGREES_ANGLE_A);
    private Angle angleB = new Angle(INITIAL_DEGREES_ANGLE_B);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obtainViewReferences();
        defineViewBehaviour();
    }

    private void obtainViewReferences() {
        seekBarAngleA = (SeekBar) findViewById(R.id.seekbar_angle_a);
        seekBarAngleB = (SeekBar) findViewById(R.id.seekbar_angle_b);
        valueAngleA = (TextView) findViewById(R.id.value_angle_a);
        valueAngleB = (TextView) findViewById(R.id.value_angle_b);
        result = (TextView) findViewById(R.id.result);
    }

    private void defineViewBehaviour() {
        seekBarAngleA.setProgress(INITIAL_DEGREES_ANGLE_A);
        seekBarAngleB.setProgress(INITIAL_DEGREES_ANGLE_B);
        valueAngleA.setText(Integer.toString(INITIAL_DEGREES_ANGLE_A));
        valueAngleB.setText(Integer.toString(INITIAL_DEGREES_ANGLE_B));

        seekBarAngleA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        seekBarAngleB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
