package com.trifork.ckp.androidmutationtesting;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AngleTest {

    @Test
    public void returnsTrueWhenComparedToASmallerAngle() throws Exception {
        assertThat(
                new Angle(2).isGreaterThan(new Angle(1)),
                is(true)
        );
    }

    @Test
    public void returnsFalseWhenComparedToAGreaterAngle() throws Exception {
        assertThat(
                new Angle(1).isGreaterThan(new Angle(2)),
                is(false)
        );
    }

    @Test
    public void returnsFalseWhenComparedToAngleWithSameDegrees() throws Exception {
        assertThat(
                new Angle(2).isGreaterThan(new Angle(2)),
                is(false)
        );
    }
}