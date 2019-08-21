package com.example.taher.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Button sport =(Button)findViewById(R.id.sport);
        Button life =(Button)findViewById(R.id.life);
        Button love =(Button)findViewById(R.id.love);
        Button time =(Button)findViewById(R.id.time);
        Button favourite =(Button)findViewById(R.id.favourite);


        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choice.this,MainActivity.class);
                intent.putExtra("choice","sport");
                startActivity(intent);



            }
        });

        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choice.this,MainActivity.class);
                intent.putExtra("choice","life");
                startActivity(intent);



            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choice.this,MainActivity.class);
                intent.putExtra("choice","love");
                startActivity(intent);



            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choice.this,MainActivity.class);
                intent.putExtra("choice","time");
                startActivity(intent);



            }
        });
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choice.this,MainActivity.class);
                intent.putExtra("choice","favourite");
                startActivity(intent);



            }
        });









    }
}
