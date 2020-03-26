package com.acun.submission2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TvShowDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "extra_tvshow";
    TextView tvTitle, tvRelease, tvOverview, tvGenre, tvRuntime, tvUserScore;
    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);

        tvTitle = findViewById(R.id.txt_tvshow_title_detail);
        tvRelease = findViewById(R.id.txt_tvshow_release_detail);
        tvOverview = findViewById(R.id.txt_tvshow_overview);
        tvGenre = findViewById(R.id.txt_tvshow_genre);
        tvRuntime = findViewById(R.id.txt_tvshow_runtime_detail);
        tvUserScore = findViewById(R.id.txt_tvshow_userscore_detail);
        imgPoster = findViewById(R.id.img_tvshow_detail);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);
        setTvShowDetail(tvShow);
    }

    private void setTvShowDetail(TvShow tvShow) {
        int poster = tvShow.getPoster();
        String title = tvShow.getTitle();
        String release = tvShow.getRelease();
        String overview = tvShow.getOverview();
        String genre = tvShow.getGenre();
        String runtime = tvShow.getRuntime();
        String userscore = tvShow.getUserscore();
        String tvshowdetail = getResources().getString(R.string.tvshowdetail);

        setTitle(tvshowdetail);
        tvTitle.setText(title);
        tvRelease.setText(release);
        tvOverview.setText(overview);
        tvGenre.setText(genre);
        tvRuntime.setText(runtime);
        tvUserScore.setText(userscore);
        imgPoster.setImageResource(poster);
    }

}
