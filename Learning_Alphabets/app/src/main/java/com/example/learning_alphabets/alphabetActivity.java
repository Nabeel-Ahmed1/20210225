package com.example.learning_alphabets;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class alphabetActivity extends AppCompatActivity {
    //private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        String name= getIntent().getStringExtra("name").toLowerCase();
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();

        int id=getResources().getIdentifier(name,"drawable",getPackageName());
        ImageView image=(ImageView) findViewById(R.id.imageView);
        image.setImageResource(id);

        int mid=getResources().getIdentifier(name,"raw",getPackageName());
        MediaPlayer mp=MediaPlayer.create(getApplicationContext(),mid);
        mp.start();

    }
}