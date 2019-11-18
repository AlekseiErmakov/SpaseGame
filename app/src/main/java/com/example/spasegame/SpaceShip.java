package com.example.spasegame;

import androidx.annotation.NonNull;

public class SpaceShip {
    private float x;
    private float y;
    private static SpaceShip instance;

    private SpaceShip(){}
    public void setY(float y) {
        this.y= y;
    }

    public void setInstance(SpaceShip instance) {
        this.instance = instance;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x= x;
    }

    public float getX() {
        return x;
    }
    public void goRight(){
        x+=10;
    }
    public void goLeft(){
        x-=10;
    }
    public static SpaceShip getInstance() {
        if(instance==null){
            instance=new SpaceShip();
        }
        return instance;
    }

    @NonNull
    @Override
    public String toString() {
        return "Millennium_Falcon";
    }
}
