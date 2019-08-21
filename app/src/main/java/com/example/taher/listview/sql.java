package com.example.taher.listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/**
 * Created by Taher on 2/17/2019.
 */

public class sql extends SQLiteOpenHelper {
    public  static  final  String DBname = "data.dp" ;

    public sql(Context context) {
        super(context, DBname, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE  mytable (book_title TEXT , Book_image TEXT , Book_Publisher TEXT , Book_PublishedDate TEXT , Book_Description TEXT , Book_id TEXT PRIMARY KEY , Book_Authors TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS mytable ");
        onCreate(db);


    }
   // public  boolean insert (String book_title,String Book_image,String Book_Publisher,String Book_PublishedDate,String Book_Description,String Book_id,String Book_Authors  )


     public  boolean insert (String book_title,String Book_image,String Book_Publisher,String Book_PublishedDate,String Book_Description,String Book_id,String Book_Authors  )
    {
        SQLiteDatabase db = this.getWritableDatabase() ;
        ContentValues contentValues = new ContentValues();
        contentValues.put("book_title" , book_title);
        contentValues.put("Book_image",Book_image);
        contentValues.put("Book_Publisher" ,Book_Publisher);
        contentValues.put("Book_PublishedDate",Book_PublishedDate);
        contentValues.put("Book_Description" , Book_Description);
        contentValues.put("Book_id",Book_id);
        contentValues.put("Book_Authors" , Book_Authors);

        int r = (int) db.insert("mytable" ,null , contentValues);
        if(r== -1 )
        {
            return  false ;
        }
        else
            return  true ;

    }






    public ArrayList<book> get_data ()
    {
        ArrayList <book> arrayList= new ArrayList() ;
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM mytable", null );

        while (res.moveToNext())
        {   String s1 = res.getString(0);
            String s2 = res.getString(1);
            String s3 = res.getString(2);
            String s4 = res.getString(3);
            String s5 = res.getString(4);
            String s6 = res.getString(5);
            String [] s7=new String[1];
             s7[0] = res.getString(6);




            arrayList.add( new book(s6,s1,s7,s3,s4,s5,s2));

        }

        return  arrayList ;

    }





    public Integer Delete (String Book_id )
    {
        SQLiteDatabase db =this.getWritableDatabase() ;
        return db.delete("mytable" , "Book_id = ?" ,new String[]{Book_id}) ;

    }


}
