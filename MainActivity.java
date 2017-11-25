package com.example.suthirthanagesh.buyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = (Button) findViewById(R.id.button);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(MainActivity.this,Scrap.class);
                scra.putExtra("bucketno", 1);
                startActivity(scra);
            }
        });
        Button buttonTwo = (Button) findViewById(R.id.button2);
        buttonTwo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(MainActivity.this,Scrap.class);
                scra.putExtra("bucketno", 2);
                startActivity(scra);
            }
        });
        Button buttonThree = (Button) findViewById(R.id.button3);
        buttonThree.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(MainActivity.this,Scrap.class);
                scra.putExtra("bucketno", 3);
                startActivity(scra);
            }
        });
        Button buttonFour = (Button) findViewById(R.id.button4);
        buttonFour.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent scra=new Intent(MainActivity.this,Scrap.class);
                scra.putExtra("bucketno", 4);
                startActivity(scra);
            }
        });
    }
}
