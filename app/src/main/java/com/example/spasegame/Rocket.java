package com.example.spasegame;

public class Rocket extends Missile{
    private float x;
    private float y;
    private float devX=20;
    private float devY=20;
    private int speed;

    public Rocket(float x,float y){
        this.x=x+devX;
        this.y=y+devY;
    }


}
