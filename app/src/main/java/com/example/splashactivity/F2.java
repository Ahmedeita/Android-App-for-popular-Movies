package com.example.splashactivity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splashactivity.model.Result;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class F2 extends Fragment {
    TextView textView;
    ImageView post;


    public F2() {
        // Required empty public constructor
    }

    public static F2 getInstance(Result movie) {
        F2 f2=new F2();
        Bundle bundle=new Bundle();
        bundle.putParcelable("movie",movie);
        f2.setArguments(bundle);
        return f2;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle=getArguments();
        Result result=bundle.getParcelable("movie");
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+result.getPosterPath()).into(post);
        textView.setText(result.getOriginalTitle());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_f2, container, false);

        post = v.findViewById(R.id.poster);

        textView = v.findViewById(R.id.textv);
        return v;
    }

}
