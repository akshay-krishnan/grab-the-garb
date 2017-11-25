package com.example.ranja.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by ranja on 11/25/2017.
 */

public class Category extends AppCompatActivity {
    private String mobile ;
    private String add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);



    }


    public void garbage(View v)
    {
        String URL = "jdbc:mysql://10.24.32.31";
        String user = "root";
        String password = "";




        try {

            final String mobileNumber = this.getMobile();
            final String address = this.getAdd();
            Log.v("From Category:",mobileNumber);

            java.sql.Connection con = (java.sql.Connection) new com.example.ranja.myapplication.Connection().execute(URL, user, password).get();
            Log.v("DB", "Hey I am connected to make a log on garbage !!!!");

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
                        ResultSet rs = st.executeQuery("SELECT * FROM " + "govt" + " WHERE Mobile = " + "'"+mobileNumber+"' AND date = "+"'"+date1+"'");

                        if(rs.next()==false)
                        {

                            st.executeUpdate("INSERT INTO govt (Mobile,Address,date,Pickup) VALUE  ('"+mobileNumber+"','"+address+"','"+date1+"','1')");
                            Log.v("Govt:", "Entry Successfully added to govt!!!!!!!!!!!");
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
                        Toast.makeText(getApplicationContext(), "You have already ticked for today", Toast.LENGTH_SHORT).show();
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

    private String getMobile()
    {
        Bundle extras = getIntent().getExtras();
         String mobileNumber = extras.getString("mobile");
        return mobileNumber;

    }

    private String getAdd()
    {   Bundle extras = getIntent().getExtras();
        String address = extras.getString("address");
        return address;
    }


    public void scrap(View v)
    {
        Intent intent1 = new Intent(this, Scrap.class);

        Bundle extras = new Bundle();
        extras.putString("mobile",this.getMobile());
        extras.putString("address",this.getAdd());
        intent1.putExtras(extras);
        startActivity(intent1);

    }
}
