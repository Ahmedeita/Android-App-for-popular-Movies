package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.splashactivity.model.Result;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        if(intent!=null && intent.hasExtra("movie"))
        {
            Result movie = intent.getExtras().getParcelable("movie");
            F2 f2=F2.getInstance(movie);
            getSupportFragmentManager().beginTransaction().replace(R.id.cont2,f2).commit();
        }

    }
}
