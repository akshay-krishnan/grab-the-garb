package com.example.ranja.myapplication;

/**
 * Created by ranja on 11/26/2017.
 */


        import android.os.AsyncTask;
        import android.util.Log;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;

        import static android.content.ContentValues.TAG;

/**
 * Created by suthirtha Nagesh on 11/25/2017.
 */

public class retrieve extends AsyncTask<Integer, Void, List> {

    private static final String URL = "jdbc:mysql://10.24.32.31";
    private static final String user = "root";
    private static final String password = "";
    @Override
    protected List doInBackground(Integer... i) {

        // Do some background work
        Log.d(TAG, "Connecting....");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, user, password);
            con.setCatalog("tricon");
            Statement st = con.createStatement();
            Log.v("DB","Connected!!!!!");
            ResultSet rs=st.executeQuery("SELECT * FROM  private");
            // String id=rs.getString("Mobile");

            int i1=(int)i[0];
            String s;
            if(i1==1)
                s="Paper";
            else if(i1==2)
                s="Plastic";
            else if(i1==3)
                s="Glass";
            else
                s="Organic";
            List<String> zoom = new ArrayList<>();

            while(rs.next()) {

                int id = rs.getInt(s);
                if(id>0)
                {
                    zoom.add(rs.getString("Mobile"));
                    zoom.add(rs.getString("Address"));
                    zoom.add(Integer.toString(id));
                }

            }
            return zoom;


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
