package com.example.ranja.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by ranja on 11/25/2017.
 */

public class Scrap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scraplist);
    }


    public void done(View v)
    {
        int [] a = new int[4];
        ViewGroup row = (ViewGroup) v.getParent();
        for(int i =0;i<4;i++) {
            ViewGroup l1 = (ViewGroup) row.getChildAt(i);
            int res1 = Integer.parseInt(((TextView) l1.getChildAt(2)).getText().toString());
            if(res1>0)
            {
                a[i] = res1;
            }
            else
            {
                a[i] = 0;
            }
        }
        final int [] b = a;
        try {
            String URL = "jdbc:mysql://10.24.32.31";
            String user = "root";
            String password = "";
            Bundle extras = getIntent().getExtras();
            final  String mobileNumber = extras.getString("mobile");
            final String address = extras.getString("address");

            Log.v("From Category:",mobileNumber);

            java.sql.Connection con = (java.sql.Connection) new com.example.ranja.myapplication.Connection().execute(URL, user, password).get();
            Log.v("DB", "Hey I am connected to make a log for scrap !!!!");

            AsyncTask task =  new AsyncTask() {
                int flag = 0;
                @Override
                protected Integer doInBackground(Object[] objects) {
                    try
                    {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date();
                        String date1 = dateFormat.format(date);
                        java.sql.Connection con = ((java.sql.Connection)objects[0]);
                        Log.v("mobile number",mobileNumber);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM " + "private" + " WHERE Mobile = " + "'"+mobileNumber+"' AND date = "+"'"+date1+"'");

                        if(rs.next()==false)
                        {

                            st.executeUpdate("INSERT INTO private (Mobile,Address,Paper,Plastic,Glass,Organic,date,Accept) VALUE  ('"+mobileNumber+"','"+address+"','"+b[0]+"','"+b[1]+"','"+b[2]+"','"+b[3]+"','"+date1+"','1')");
                            Log.v("Private:", "Entry Successfully added to private!!!!!!!!!!!");
                            flag = 1;
                        }


                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    return flag;
                }

                @Override
                protected void onPostExecute(Object o) {
                    if (flag == 0) {
                        Toast.makeText(getApplicationContext(), "You have already placed order", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Updated your response.Thank you :)", Toast.LENGTH_SHORT).show();

                    }
                }
            }.execute(con);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public void plus(View v)
    {

        ViewGroup row = (ViewGroup) v.getParent();
        TextView res = (TextView) row.getChildAt(2);
        res.setText(Integer.toString(Integer.parseInt(res.getText().toString())+1) );

    }

    public void minus(View v)
    {
        ViewGroup row = (ViewGroup) v.getParent();
        TextView res = (TextView) row.getChildAt(2);
        int x = Integer.parseInt(res.getText().toString())-1;
        if(x >= 0) {
            res.setText(Integer.toString(x));
        }
    }
}
