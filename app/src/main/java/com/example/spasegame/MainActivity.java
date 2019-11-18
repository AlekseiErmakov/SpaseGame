package com.example.spasegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Thread ShipThread;
    Button Left;
    Button Right;
    Button Start;
    ImageView view;
    ImageView rock;
    LinearLayout layout;
    SpaceShip MileniumFalcon;
    Handler handler;
    Music musicplayer;
    Rocket rocket;
    Thread rocke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rocket = new Rocket(-100,-100);
        view =(ImageView)findViewById(R.id.Myship);
        rock =(ImageView)findViewById(R.id.shiprocket);
        layout=(LinearLayout)findViewById(R.id.llBut);
        MileniumFalcon=SpaceShip.getInstance();
        startCoords();
        addButtons();
        musicplayer = new Music(this);
        sendRocket();


        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
               switch (msg.what){
                   case(0):
                       setViewSpaseShipCoordinates();
                   case(1):
                       setViewRocket();
               }
            }

        };
        ShipThread =new Thread(){
            public void run(){
                while(true){
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }

                }
            }
        };

    }

    private void startCoords(){
        layout.setX(-80);
        layout.setY(1300);
        MileniumFalcon.setX(300);
        MileniumFalcon.setY(900);
        rock.setX(-100);
        rock.setY(-100);
        setViewSpaseShipCoordinates();
        setViewRocket();

    }
    public void setViewSpaseShipCoordinates(){
        view.setX(MileniumFalcon.getX());
        view.setY(MileniumFalcon.getY());

    }
    public void setViewRocket(){
        rock.setX(rocket.getX());
        rock.setY(rocket.getY());
    }
    private void addButtons(){
        Left =(Button)findViewById(R.id.left);
        Left.setOnClickListener(this);
        Start =(Button)findViewById(R.id.start);
        Start.setOnClickListener(this);
        Right =(Button)findViewById(R.id.right);
        Right.setOnClickListener(this);

    }

    public void sendRocket(){
        rocke = new Thread(){
            @Override
            public void run() {
                rocketFlight();
            }
            public void rocketFlight(){
                rocket.setX(MileniumFalcon.getX());
                rocket.setY(MileniumFalcon.getY());
                handler.sendEmptyMessage(1);
                while(rocket.decY()>-100){
                    rocket.decY();
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException ex){

                    }
                    handler.sendEmptyMessage(1);
                }
                rocketFlight();
            }
        };

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.start):
                musicplayer.playmusic();
                ShipThread.setDaemon(true);
                ShipThread.start();
                rocke.start();

                break;
            case (R.id.left):
                MileniumFalcon.goLeft();
                break;
            case (R.id.right):
                MileniumFalcon.goRight();
                break;
        }
    }



}
