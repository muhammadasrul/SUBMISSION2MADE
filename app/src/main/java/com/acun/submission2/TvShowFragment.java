package com.acun.submission2;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private static final String TAG = "TvShowFragment";
    private RecyclerView rvTvShow;
    private ArrayList<TvShow> list = new ArrayList<>();

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show,container,false);
        rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);

        list.addAll(getListTvShow());
        showRecyclerCardView();

        return view;
    }

    private void showRecyclerCardView() {
        rvTvShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        CardViewTvShowAdapter cardViewTvShowAdapter = new CardViewTvShowAdapter(this.getContext());
        cardViewTvShowAdapter.setListTvShows(list);
        rvTvShow.setAdapter(cardViewTvShowAdapter);
    }

    public ArrayList<TvShow> getListTvShow(){
        String[] dataTitle = getResources().getStringArray(R.array.data_tvshow_title);
        String[] dataRelease = getResources().getStringArray(R.array.data_tvshow_release);
        String[] dataOverview = getResources().getStringArray(R.array.data_tvshow_overview);
        String[] dataUserscore = getResources().getStringArray(R.array.data_tvshow_userscore);
        String[] dataRuntime = getResources().getStringArray(R.array.data_tvshow_runtime);
        String[] dataGenre = getResources().getStringArray(R.array.data_tvshow_genre);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.data_tvshow_poster);

        ArrayList<TvShow> listTvShow = new ArrayList<>();
        for (int i=0; i < dataTitle.length; i++){
            TvShow tvShow = new TvShow();
            tvShow.setPoster(dataPoster.getResourceId(i, -1));
            tvShow.setTitle(dataTitle[i]);
            tvShow.setRelease(dataRelease[i]);
            tvShow.setOverview(dataOverview[i]);
            tvShow.setUserscore(dataUserscore[i]);
            tvShow.setRuntime(dataRuntime[i]);
            tvShow.setGenre(dataGenre[i]);

            listTvShow.add(tvShow);
        }
        return listTvShow;
    }

}
