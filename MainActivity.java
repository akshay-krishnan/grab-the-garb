package com.example.ranja.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity {
    protected String mobileNumber;
    protected String address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







    }

    private int register()
    {   EditText mobile = (EditText) findViewById(R.id.mobile);
        EditText address1 = (EditText) findViewById(R.id.address1);

        mobileNumber = mobile.getText().toString();
        address = address1.getText().toString();
        if (mobileNumber.matches("") || (address.matches("")))
        {
            Toast.makeText(this, "Please fill the details!!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return 1;


    }
    public void next(View v)
    {
        if(register()==0)
         {
            return ;
        }
        String URL = "jdbc:mysql://10.24.32.31";
        String user = "root";
        String password = "";
        try
        {
            java.sql.Connection  con = (java.sql.Connection) new com.example.ranja.myapplication.Connection().execute(URL,user,password).get();
            Log.v("DB","Hey I am connected !!!!");

            int flag = (int) new AsyncTask() {
                int flag = 0;
                @Override
                protected Integer doInBackground(Object[] objects) {
                    try
                    {   java.sql.Connection con = ((java.sql.Connection)objects[0]);
                        Log.v("mobile number",mobileNumber);
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM " + "userreg" + " WHERE MOBILE = " + mobileNumber);

                        if(rs.next()==false)
                        {
                            Log.v("DB:", "Result is empty !!!!!!!!!!!");
                            st.executeUpdate("INSERT INTO userreg (Mobile,Address) VALUE  ('"+mobileNumber+"','"+address+"')");
                            Log.v("DB:", "Enter Successfully added !!!!!!!!!!!");
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
                        Toast.makeText(getApplicationContext(), "Already registered!!", Toast.LENGTH_SHORT).show();
                        }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                    }
                }
            }.execute(con).get();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d("DB:","Hey I am not connected !!!!");

        }



        Intent intent1 = new Intent(this, Category.class);

        startActivity(intent1);





    }

    private String getMobileNumber()
    {
        return mobileNumber;
    }

    private String getAddress()
    {
        return address;
    }


}
