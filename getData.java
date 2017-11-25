package com.example.ranja.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ranja on 11/25/2017.
 */

public class getData extends AsyncTask<String,Void,String> {
   protected StringBuilder result = new StringBuilder();



    @Override
   protected String doInBackground(String... strings) {

       try {

           URL url = new URL(strings[0]);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           conn.setRequestMethod("GET");
           BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           String line;
           while ((line = rd.readLine()) != null) {
               result.append(line);
           }
           rd.close();

       }
       catch (Exception e)
       {
           e.printStackTrace();

       }
       return result.toString();
   }



}
