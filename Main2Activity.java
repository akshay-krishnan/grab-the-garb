package com.example.ranja.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonOne = (Button) findViewById(R.id.button);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(Main2Activity.this,Scrap2.class);
                scra.putExtra("bucketno", 1);
                startActivity(scra);
            }
        });
        Button buttonTwo = (Button) findViewById(R.id.button2);
        buttonTwo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(Main2Activity.this,Scrap2.class);
                scra.putExtra("bucketno", 2);
                startActivity(scra);
            }
        });
        Button buttonThree = (Button) findViewById(R.id.button3);
        buttonThree.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(Main2Activity.this,Scrap2.class);
                scra.putExtra("bucketno", 3);
                startActivity(scra);
            }
        });
        Button buttonFour = (Button) findViewById(R.id.button4);
        buttonFour.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(Main2Activity.this,Scrap2.class);
                scra.putExtra("bucketno", 4);
                startActivity(scra);
            }
        });
    }

}
