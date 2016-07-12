package com.trifork.ckp.androidmutationtesting;

public final class Angle {

    private final int degrees;

    public Angle(int degrees) {
        this.degrees = degrees;
    }

    public boolean isGreaterThan(Angle otherAngle) {
        return this.degrees > otherAngle.degrees;
    }
}