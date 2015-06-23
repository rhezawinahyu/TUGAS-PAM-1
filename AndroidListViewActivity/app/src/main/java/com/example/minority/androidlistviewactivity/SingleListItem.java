package com.example.minority.androidlistviewactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleListItem extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.list_data_film);

        TextView txtName = (TextView) findViewById(R.id.name);
        TextView txtRating = (TextView) findViewById(R.id.rating);
        TextView txtGenre = (TextView) findViewById(R.id.genre);
        TextView txtRelease = (TextView) findViewById(R.id.release);
        TextView txtDuration = (TextView) findViewById(R.id.duration);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String rating = i.getStringExtra("rating");
        String genre = i.getStringExtra("genre");
        String release = i.getStringExtra("release");
        String duration = i.getStringExtra("duration");

        ImageView imageView = (ImageView) findViewById(R.id.image);


        if(name.equalsIgnoreCase("Jurassic World")){
            imageView.setImageResource(R.drawable.jurrasic);
            rating = "7.5/10";
            genre = "Action, Adventure, Sci-fi";
            release = "12 June 2015 (USA)";
            duration = "124 min";
        } else if(name.equalsIgnoreCase("Spy")){
            imageView.setImageResource(R.drawable.spy);
            rating = "7.6/10";
            genre = "Action, Comedy, Crime";
            release = "5 June 2015 (USA)";
            duration = "120 min";
        } else if(name.equalsIgnoreCase("San Andreas")){
            imageView.setImageResource(R.drawable.sanandreas);
            rating = "6.6/10";
            genre = "Action, Drama, Thriller";
            release = "29 May 2015 (USA)";
            duration = "114 min";
        }else if(name.equalsIgnoreCase("Pitch Perfect 2")){
            imageView.setImageResource(R.drawable.pitch);
            rating = "7/10";
            genre = "Comedy, Music";
            release = "15 May 2015 (USA)";
            duration = "115 min";
        }else if(name.equalsIgnoreCase("Insidious : Chapter 3")){
            imageView.setImageResource(R.drawable.insidious);
            rating = "6.7/10";
            genre = "Horror";
            release = "5 June 2015 (USA)";
            duration = "97 min";
        } else if(name.equalsIgnoreCase("Entourage")){
            imageView.setImageResource(R.drawable.entourage);
            rating = "7.5/10";
            genre = "Comedy";
            release = "3 june 2015 (USA)";
            duration = "104 min";
        } else if(name.equalsIgnoreCase("Mad Max : Fury Road")){
            imageView.setImageResource(R.drawable.madmax);
            rating = "8.6/10";
            genre = "Action, Adventure, Sci-fi";
            release = "15 May 2015 (USA)";
            duration = "120 Min";
        } else if(name.equalsIgnoreCase("Avengers Age Of Ultron")){
            imageView.setImageResource(R.drawable.avenger);
            rating = "8.0/10";
            genre = "Action, Adventure, Sci-fi";
            release = "1 May 2015";
            duration = "141 min";
        } else if(name.equalsIgnoreCase("Tomorrowland")){
            imageView.setImageResource(R.drawable.tomorrowland);
            rating = "6.7/10";
            genre = "Action, Adventure, Family";
            release = "22 May 2015 (USA)";
            duration = "130 min";
        } else if(name.equalsIgnoreCase("Love and Mercy")){
            imageView.setImageResource(R.drawable.lovemercy);
            rating = "7.9/10";
            genre = "Biography, Drama, Music";
            release = "4 June 2015 (Israel)";
            duration = "121 min";
        }
        txtName.setText     ("Name            \t : " + name);
        txtRating.setText   ("Rating          \t : " + rating);
        txtGenre.setText    ("Genre           \t : " + genre);
        txtRelease.setText  ("Release Date : " + release);
        txtDuration.setText ("Duration        \t : " + duration);
    }
}