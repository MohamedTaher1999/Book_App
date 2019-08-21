package com.example.taher.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(5000);


                }
                catch (Exception e)
                {

                    e.printStackTrace();

                }
                finally {


                    Intent intent = new Intent(Start.this,Choice.class);
                    startActivity(intent);

                }
            }
        };
        thread.start();


    }


}
