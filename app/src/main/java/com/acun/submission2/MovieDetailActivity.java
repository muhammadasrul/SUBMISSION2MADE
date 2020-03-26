package com.acun.submission2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvRelease, tvRating, tvShowtime, tvOverview, tvBudget, tvGenre;
    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle = findViewById(R.id.txt_movie_title_detail);
        tvRelease = findViewById(R.id.txt_movie_release_detail);
        tvRating = findViewById(R.id.txt_movie_rating_detail);
        tvShowtime = findViewById(R.id.txt_movie_showtime_detail);
        tvOverview = findViewById(R.id.txt_movie_overview);
        tvGenre = findViewById(R.id.txt_movie_genre);
        imgPoster = findViewById(R.id.img_movie_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        setMovieDetail(movie);
    }

    private void setMovieDetail(Movie movie) {
        int poster = movie.getPoster();
        String title = movie.getTitle();
        String release = movie.getDate();
        String rating = movie.getRating();
        String showtime = movie.getShowtime();
        String overview = movie.getOverview();
        String genre = movie.getGenre();
        String moviedetail = getResources().getString(R.string.moviedetail);

        setTitle(moviedetail);
        tvTitle.setText(title);
        tvRelease.setText(release);
        tvRating.setText(rating);
        tvShowtime.setText(showtime);
        tvOverview.setText(overview);
        tvGenre.setText(genre);
        imgPoster.setImageResource(poster);
    }
}
