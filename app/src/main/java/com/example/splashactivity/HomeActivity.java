package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;

import com.example.splashactivity.model.Result;

public class HomeActivity extends AppCompatActivity {
   boolean orient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new F1()).commit();
        FrameLayout frame2 = findViewById(R.id.cont2);
        if(frame2!=null)
            orient=true;
        else
            orient=false;
    }

    public void setMovie(Result result) {
        if(!orient)
        {
            Intent i=new Intent(HomeActivity.this,DetailsActivity.class);
            i.putExtra("movie", result);
            startActivity(i);
        }
        else {
            F2 f2=F2.getInstance(result);
            getSupportFragmentManager().beginTransaction().replace(R.id.cont2,f2).commit();
        }
    }
}
