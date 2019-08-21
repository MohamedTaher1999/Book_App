package com.example.taher.listview;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.taher.listview.book;
import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>{


    public static class ViewHolder extends RecyclerView .ViewHolder{
        public TextView title,author;
        public ImageView photo;
        RelativeLayout parentlayout;



        public ViewHolder(View itemView) {
            super(itemView);

            title=(TextView) itemView.findViewById(R.id.Title);
            author=(TextView)itemView.findViewById(R.id.author);
            photo=(ImageView) itemView.findViewById(R.id.image);
            parentlayout=itemView.findViewById(R.id.parent);


        }
    }
    private Context context;
    private List<book>books;

    public adapter(Context c, ArrayList<book>lst){

        this.context=c;
        this.books=lst;


    }


    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(adapter.ViewHolder holder, int position) {


        final book b = books.get(position);

        holder.title.setText(b.getTitle());
        holder.author.setText(b.getAuthors()[0]);
       Picasso.with(context).load(b.getImagelink()).into(holder.photo);
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("Book_Title",b.getTitle());
                intent.putExtra("Book_image",b.getImagelink());
                intent.putExtra("Book_Publisher",b.getPublisher());
                intent.putExtra("Book_PublishedDate",b.getPublishedDate());
                intent.putExtra("Book_Description",b.getDescription());
                if(b.getAuthors().length==1){
                intent.putExtra("Book_Authors",b.getAuthors()[0]);}
                else {
                    intent.putExtra("Book_Authors",b.getAuthors()[0]+" and "+b.getAuthors()[1]);

                }

                intent.putExtra("Book_id",b.getId());



                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}

