package com.example.taher.listview;

/**
 * Created by Taher on 2/4/2019.
 */


public class book
{
    private String id;
    private String title;
    private String[] authors;
    private String publisher;
    private String publishedDate;
    //private Double averageRating;
    private String description;
    private String imagelink;



   public book(String id, String title, String[] authors, String publisher, String publishedDate, String description, String imagelink) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        //this.averageRating = averageRating;
        this.description = description;
        this.imagelink = imagelink;
    }

    public String getId(){

        return id;
    }
    public String getTitle(){

        return title;
    }
    public String[] getAuthors(){

        return authors;

    }
    public String getPublisher(){

        return publisher;
    }
    public String getPublishedDate(){

        return publishedDate;
    }

    public String getDescription(){

        return description;
    }
    public String getImagelink(){

        return imagelink;
    }










}
