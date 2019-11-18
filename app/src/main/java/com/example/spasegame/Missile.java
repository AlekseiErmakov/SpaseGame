package com.example.spasegame;

public abstract class Missile {
    private float x;
    private float y;
    private int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

}
