package com.example.suthirthanagesh.buyer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Scrap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap);
       // Log.v("DB","Connected!!!!!");
        int value = getIntent().getExtras().getInt("bucketno");
        //Log.v("db",""+value);
        List i;

        try {
            i = new retrieve().execute(value).get();
            TextView text=(TextView) findViewById(R.id.scraptext);
           int g=i.size();
           g=g-1;
           int y=0;
           String st="\n";
           while(g>-1)
           {
                st= st +" " +(String) i.get(g);
               Log.i("dis",""+st);

               y++;
               if(y%3==0)
               {
                   y=0;
                   Button myButton = new Button(this);
                   myButton.setText(st);
                   LinearLayout ll = (LinearLayout)findViewById(R.id.scraptext);
                   LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                   ll.addView(myButton, lp);
                   st="\n";
               }
               g--;

           }

            //Log.i("ret",""+i.get(0));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
