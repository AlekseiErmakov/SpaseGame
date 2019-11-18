package com.example.spasegame;

public class Rocket extends Missile{
    private float x;
    private float y;
    private float devX=100;
    private float devY=20;
    private int speed;

    public Rocket(float x,float y){
        this.x=x+devX;
        this.y=y+devY;
    }
    public float decY(){
        y-=7;
        return y;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x+devX;
    }

    public void setY(float y) {
        this.y = y+devY;
    }

}
