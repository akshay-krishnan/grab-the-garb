package com.example.ranja.myapplication;



        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.concurrent.ExecutionException;

        import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Scrap2 extends AppCompatActivity implements View.OnClickListener{
    int size;
    List i;
    int value;
    String st2;
    private static final String URL = "jdbc:mysql://10.24.32.31";
    private static final String user = "root";
    private static final String password = "";

    java.sql.Connection con = (java.sql.Connection) new com.example.ranja.myapplication.Connection().execute(URL, user, password).get();

    public Scrap2() throws ExecutionException, InterruptedException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayout parent;
        Button b1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap2);
        // Log.v("DB","Connected!!!!!");
        value = getIntent().getExtras().getInt("bucketno");
        //Log.v("db",""+value);


        try {
            i = new retrieve().execute(value).get();
            parent=(LinearLayout)findViewById(R.id.scraptext);
            int g=i.size();
            size=g;
            int f=g;

            g=0;
            int y=0;
            int k=1;
            String st="\n";
            while(g<f)
            {
                st= st +(String) i.get(g)+"    ";
                // Log.i("dis",""+st);

                y++;
                if(y%3==0)
                {
                    y=0;
                    b1=new Button(Scrap2.this);
                    b1.setId(k);
                    b1.setOnClickListener(Scrap2.this);

                    b1.setText(st);
                    b1.setTag(k);
                    k++;
                    parent.addView(b1);

                    st="\n";
                }
                g++;

            }

            //Log.i("ret",""+i.get(0));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onClick(View v)
    {
        size=size/3;


        st2=v.getTag().toString();
        Log.i("re",""+st2);

        Toast.makeText(getApplicationContext(), "" + st2, Toast.LENGTH_SHORT).show();
        AsyncTask update=new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection con = ((java.sql.Connection)objects[0]);
                    //Connection con = DriverManager.getConnection(URL, user, password);

                    //con.setCatalog("tricon");
                    Statement st = con.createStatement();
                    Log.v("DB","Connected!!!!!");
                    String mobileNumber=(String) i.get(3*(Integer.parseInt(st2)-1));
                    Log.i("rewe",""+mobileNumber);
                    String n1;
                    if(value==1)
                        n1 ="Paper";
                    else if(value==2)
                        n1="Plastic";
                    else if(value==3)
                        n1="Glass";
                    else
                        n1="Organic";
                    st.executeUpdate("UPDATE private SET "+n1+"= 0 WHERE Mobile = "+mobileNumber);


                         /*   if(rs.next()==true)
                            {

                                //st.executeUpdate("UPDATE private SET  "+n1+" ='0' ");
                                Log.v("Govt:", "Entry Successfully added to govt!!!!!!!!!!!");
                                rs.updateString(""+n1+"","0");
                                return null;
                            }*/
                    // String id=rs.getString("Mobile");


                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute(con);
        size--;

    }


}
