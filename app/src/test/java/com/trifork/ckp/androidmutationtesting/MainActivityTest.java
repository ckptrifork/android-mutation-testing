package com.trifork.ckp.androidmutationtesting;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void testInitialGreatestAngleIsB() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        TextView result = (TextView) activity.findViewById(R.id.result);
        assertEquals("B", result.getText().toString());
    }
}