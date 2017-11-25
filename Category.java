package com.example.ranja.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ranja on 11/25/2017.
 */

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);



    }


    public void garbage(View v)
    {

    }

    public void scrap(View v)
    {
        Intent intent1 = new Intent(this, Scrap.class);

        startActivity(intent1);
    }
}
