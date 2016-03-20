package com.ssn.ex7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Handler handler;
    Button button;
    TextView heading;
    TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button = (Button)findViewById(R.id.button);
        heading = (TextView)findViewById(R.id.heading);
        timer = (TextView)findViewById(R.id.timer);
        handler = new Handler();
        handler.postDelayed(run,1000);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heading.setText("Multithreading works");
            }
        });
    }
    Runnable run = new Runnable() {
        @Override
        public void run() {
            updateTime();
        }
    };

    private void updateTime() {
        timer.setText(String.valueOf(Integer.parseInt(timer.getText().toString())-1));
        if(Integer.parseInt(timer.getText().toString())==0){
            button.setVisibility(View.VISIBLE);
            heading.setText("Press button");
        }else{
            handler.postDelayed(run,1000);
        }
    }
}