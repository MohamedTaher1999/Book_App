package com.example.taher.listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taher on 2/13/2019.
 */

public class json {

    private String url;
    private Activity context;

    ArrayList<book> arrayList=new ArrayList<>() ;


    public json(String url , Activity context){

        this.url=url;

        this.context=context;

    }
    RequestQueue mQueue = Volley.newRequestQueue(context);

    public ArrayList<book> jsonparse(){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray itemArray = response.getJSONArray("items");

                            for(int i=0;i<itemArray.length();i++){

                                JSONObject employee=itemArray.getJSONObject(i);

                                String id = employee.getString("id");


                                JSONObject volumeInfoitem = employee.getJSONObject("volumeInfo");
                                String title = volumeInfoitem.getString("title");
                                String publisher = volumeInfoitem.getString("publisher");
                                String publishedDate = volumeInfoitem.getString("publishedDate");

                                //double averageRating = volumeInfoitem.getDouble("averageRating");
                                double averageRating=1;

                                String description = volumeInfoitem.getString("description");

                                JSONObject imageLinks = volumeInfoitem.getJSONObject("imageLinks");
                                String imagelink = imageLinks.getString("smallThumbnail");

                                JSONArray authorsArray = volumeInfoitem.getJSONArray("authors");
                                String [] authorarray=new String[authorsArray.length()];
                                for(int i2=0;i2<authorsArray.length();i2++){
                                    String  value=authorsArray.getString(i2);
                                    authorarray[i2]=value;
                                }
                                arrayList.add(new book(id,title,authorarray,publisher,publishedDate,description,imagelink));

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        mQueue.add(request);

        return arrayList;




    }








}

