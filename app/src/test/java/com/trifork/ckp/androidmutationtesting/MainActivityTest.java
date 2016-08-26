package com.trifork.ckp.androidmutationtesting;

import android.widget.SeekBar;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class MainActivityTest {

    private SeekBar seekBarAngleA, seekBarAngleB;
    private TextView valueAngleA, valueAngleB, result;

    @Before
    public void setUp() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        this.seekBarAngleA = (SeekBar) activity.findViewById(R.id.seek_bar_angle_a);
        this.seekBarAngleB = (SeekBar) activity.findViewById(R.id.seek_bar_angle_b);
        this.valueAngleA = (TextView) activity.findViewById(R.id.value_angle_a);
        this.valueAngleB = (TextView) activity.findViewById(R.id.value_angle_b);
        this.result = (TextView) activity.findViewById(R.id.result);
    }

    @Test
    public void testInitialState() throws Exception {
        assertThat(result.getText().toString(), is("B"));
    }

    @Test
    public void testGreatestAngleIsA() throws Exception {
        seekBarAngleA.setProgress(90);
        seekBarAngleB.setProgress(10);

        assertThat(valueAngleA.getText().toString(), is("90"));
        assertThat(valueAngleB.getText().toString(), is("10"));
        assertThat(result.getText().toString(), is("A"));
    }

    @Test
    public void testGreatestAngleIsB() throws Exception {
        seekBarAngleA.setProgress(10);
        seekBarAngleB.setProgress(90);

        assertThat(valueAngleA.getText().toString(), is("10"));
        assertThat(valueAngleB.getText().toString(), is("90"));
        assertThat(result.getText().toString(), is("B"));
    }

    @Test
    public void testAnglesAreEqual() throws Exception {
        seekBarAngleA.setProgress(50);
        seekBarAngleB.setProgress(50);

        assertThat(valueAngleA.getText().toString(), is("50"));
        assertThat(valueAngleB.getText().toString(), is("50"));
        assertThat(result.getText().toString(), isEmptyString());
    }
}