package com.example.taher.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    TextView t,book_Publisher,book_publisheddate,Des;
    ImageView bookimage;
    String book_title,Book_image,Book_Publisher,Book_PublishedDate,Book_Description,Book_id,Book_Authors;
    Button btn_fav;
    public sql dp =new sql(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t=(TextView)findViewById(R.id.book_title);
        book_Publisher=(TextView)findViewById(R.id.book_publisher);
        book_publisheddate=(TextView)findViewById(R.id.Book_PublishedDate);
        Des=(TextView)findViewById(R.id.des);
        bookimage=(ImageView)findViewById(R.id.book_image);
        btn_fav=(Button)findViewById(R.id.btn_fav);

        book_title=getIntent().getStringExtra("Book_Title");
        Book_image=getIntent().getStringExtra("Book_image");
        Book_Publisher=getIntent().getStringExtra("Book_Publisher");
        Book_PublishedDate=getIntent().getStringExtra("Book_PublishedDate");
        Book_Description=getIntent().getStringExtra("Book_Description");
        Book_id=getIntent().getStringExtra("Book_id");
        Book_Authors=getIntent().getStringExtra("Book_Authors");


        book_Publisher.setText("Publisher in "+Book_Publisher);
        book_publisheddate.setText("Published at "+Book_PublishedDate);
        Des.setText(Book_Description);
        t.setText( book_title);
        Picasso.with(this).load(Book_image).into(bookimage);

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean rr = dp.insert(book_title,Book_image,Book_Publisher,Book_PublishedDate,Book_Description,Book_id,Book_Authors);

               // boolean rr = dp.insert() ;
                if (rr == true)
                {
                    Toast.makeText(DetailsActivity.this , "Storing in Your Favouirte" , Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(DetailsActivity.this , "Aleardy Stored " , Toast.LENGTH_LONG).show();



            }
        });



    }
}
