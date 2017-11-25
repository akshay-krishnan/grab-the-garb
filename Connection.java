package com.example.ranja.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.DriverManager;
import java.sql.Statement;

import static android.content.ContentValues.TAG;

/**
 * Created by ranja on 11/25/2017.
 */

public class Connection extends AsyncTask<String,Void,Object>{

        @Override
        protected Object doInBackground(String... params) {

            // Do some background work
            Log.d("DB", "Connecting....");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection(params[0], params[1], params[2]);
                con.setCatalog("tricon");
                /*
                Statement st = con.createStatement();
                Log.v("DB","Connected!!!!!");
                st.executeUpdate("INSERT INTO " + params[3]+ " VALUES "+ params[4]);
                */

                return con;


            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }
    }

