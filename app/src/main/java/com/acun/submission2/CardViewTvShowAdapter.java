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

public class CardViewTvShowAdapter extends RecyclerView.Adapter<CardViewTvShowAdapter.CardViewViewHolder> {
    private ArrayList<TvShow> listTvShows;
    Context context;

    public ArrayList<TvShow> getListTvShow() {
        return listTvShows;
    }

    public void setListTvShows(ArrayList<TvShow> listTvShow){
        this.listTvShows = listTvShow;
    }

    public CardViewTvShowAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tvshow_cardview, parent,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        TvShow tvShow = getListTvShow().get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPoster())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPoster);

        holder.tvTitle.setText(tvShow.getTitle());
        holder.tvRelease.setText(tvShow.getRelease());
        holder.tvUserscore.setText(tvShow.getUserscore());
        holder.tvRuntime.setText(tvShow.getRuntime());
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPoster;
        TextView tvTitle, tvRelease, tvUserscore, tvRuntime;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_tvshow);
            tvTitle = itemView.findViewById(R.id.txt_tvshow_title);
            tvRelease = itemView.findViewById(R.id.txt_tvshow_release);
            tvUserscore = itemView.findViewById(R.id.txt_tvshow_userscore);
            tvRuntime = itemView.findViewById(R.id.txt_tvshow_runtime);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            TvShow tvShow = getListTvShow().get(position);

            tvShow.setTitle(tvShow.getTitle());
            tvShow.setOverview(tvShow.getOverview());

            Intent moveToTvShowDetailIntent = new Intent(itemView.getContext(), TvShowDetailActivity.class);
            moveToTvShowDetailIntent.putExtra(TvShowDetailActivity.EXTRA_TVSHOW, tvShow);
            context.startActivity(moveToTvShowDetailIntent);
        }
    }
}
