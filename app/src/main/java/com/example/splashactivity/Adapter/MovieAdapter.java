package com.example.splashactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashactivity.HomeActivity;
import com.example.splashactivity.R;
import com.example.splashactivity.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    List<Result>results;
    Context context;

    public MovieAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new  MovieHolder (LayoutInflater.from(context).inflate(R.layout.moviecard,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Result result = results.get(position);
        holder.titleText.setText(result.getTitle());
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+result.getPosterPath()).into(holder.posterView);

    }

    @Override
    public int getItemCount() {
        return results!=null?results.size():0;
    }

    public void setData(List<Result> lr) {
        results=lr;
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView posterView;
        TextView titleText;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            posterView=itemView.findViewById(R.id.poster_view);
            titleText=itemView.findViewById(R.id.textview1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((HomeActivity)context).setMovie(results.get(getAdapterPosition()));
                }
            });

        }
    }
}
