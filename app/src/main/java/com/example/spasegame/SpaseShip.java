package com.example.spasegame;

import android.media.Image;

public class SpaseShip {
    private double X;
    private double Y;
    private Image Look;

    private static final SpaseShip ourInstance = new SpaseShip();

    public static SpaseShip getInstance() {
        return ourInstance;
    }

    private SpaseShip() {
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public Image getLook() {
        return Look;
    }
    public void incrementY(){
        if (Y<300)
            Y++;
    }
    public void decrementY(){
        if(Y>0)
            Y--;
    }
}
