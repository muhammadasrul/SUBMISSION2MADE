package com.acun.submission2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewMovieAdapter extends RecyclerView.Adapter<CardViewMovieAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Movie> listMovie;

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    public CardViewMovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_cardview, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Movie movie = getListMovie().get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPoster())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPoster);

        holder.tvTitle.setText(movie.getTitle());
        holder.tvRating.setText(movie.getRating());
        holder.tvRelease.setText(movie.getDate());
        holder.tvShowtime.setText(movie.getShowtime());
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPoster;
        TextView tvTitle, tvRelease, tvRating, tvShowtime;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_movie);
            tvTitle = itemView.findViewById(R.id.txt_movie_title);
            tvRelease = itemView.findViewById(R.id.txt_movie_release);
            tvRating = itemView.findViewById(R.id.txt_movie_rating);
            tvShowtime = itemView.findViewById(R.id.txt_movie_showtime);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Movie movie =getListMovie().get(position);

            movie.setTitle(movie.getTitle());
            movie.setOverview(movie.getOverview());

            Intent moveToMovieDetailIntent = new Intent(itemView.getContext(), MovieDetailActivity.class);
            moveToMovieDetailIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
            context.startActivity(moveToMovieDetailIntent);
        }
    }
}
