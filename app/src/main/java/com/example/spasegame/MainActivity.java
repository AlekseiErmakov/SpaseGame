package com.example.spasegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Thread t;
    Button Left;
    Button Right;
    Button Start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t =new Thread(){
            @Override
            public void run() {
                while (!interrupted()){
                    runOnUiThread(new Runnable() {
                        SpaseShip ship=SpaseShip.getInstance();
                        @Override
                        public void run() {

                        }
                    });
                }
            }
        };
    }
    private void addButtons(){
        Left =(Button)findViewById(R.id.left);
        Left.setOnClickListener(this);
        Start =(Button)findViewById(R.id.start);
        Start.setOnClickListener(this);
        Right =(Button)findViewById(R.id.right);
        Start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
