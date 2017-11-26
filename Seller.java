package com.example.ranja.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Seller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);


        Switch sw = (Switch) findViewById(R.id.toggle);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    startActivity2();

            }


        });




    }

        private void startActivity2()
        {
            Intent intent1 = new Intent(this, Main2Activity.class);
            startActivity(intent1);
        }

        public void startActivity1(View v)
        {
            Bundle extras = getIntent().getExtras();
            String mobileNumber = extras.getString("mobile");
            String address = extras.getString("address");

            Intent intent1 = new Intent(this, Category.class);

            extras.putString("mobile", mobileNumber);
            extras.putString("address", address);
            intent1.putExtras(extras);
            startActivity(intent1);
        }
    }



