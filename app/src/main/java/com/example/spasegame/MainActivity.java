package com.example.spasegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Thread ShipThread;
    Button Left;
    Button Right;
    Button Start;
    ImageView view;
    LinearLayout layout;
    SpaceShip MileniumFalcon;
    Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view =(ImageView)findViewById(R.id.Myship);
        layout=(LinearLayout)findViewById(R.id.llBut);
        MileniumFalcon=SpaceShip.getInstance();
        startCoords();
        addButtons();
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
               switch (msg.what){
                   case(0):
                       setViewSpaseShipCoordinates();
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
        setViewSpaseShipCoordinates();

    }
    public void setViewSpaseShipCoordinates(){
        view.setX(MileniumFalcon.getX());
        view.setY(MileniumFalcon.getY());
    }
    private void addButtons(){
        Left =(Button)findViewById(R.id.left);
        Left.setOnClickListener(this);
        Start =(Button)findViewById(R.id.start);
        Start.setOnClickListener(this);
        Right =(Button)findViewById(R.id.right);
        Right.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.start):
                ShipThread.setDaemon(true);
                ShipThread.start();
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
