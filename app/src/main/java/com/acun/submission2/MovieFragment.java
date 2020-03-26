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
public class MovieFragment extends Fragment {

    private static final String TAG = "MovieFragment";
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_movie,container, false);
        rvMovies = view.findViewById(R.id.rv_movie);
        rvMovies.setHasFixedSize(true);

        list.addAll(getListMovie());
        showRecyclerCardView();

        return view;
    }

    public ArrayList<Movie> getListMovie() {

        String[] dataTitle = getResources().getStringArray(R.array.data_movie_title);
        String[] dataRelease = getResources().getStringArray(R.array.data_movie_release);
        String[] dataRating = getResources().getStringArray(R.array.data_movie_rating);
        String[] dataShowtime = getResources().getStringArray(R.array.data_movie_showtime);
        String[] dataOverview = getResources().getStringArray(R.array.data_movie_overview);
        String[] dataGenre = getResources().getStringArray(R.array.data_movie_genre);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.data_movie_poster);

        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDate(dataRelease[i]);
            movie.setRating(dataRating[i]);
            movie.setShowtime(dataShowtime[i]);
            movie.setOverview(dataOverview[i]);
            movie.setGenre(dataGenre[i]);

            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerCardView() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        CardViewMovieAdapter cardViewMovieAdapter = new CardViewMovieAdapter(this.getContext());
        cardViewMovieAdapter.setListMovie(list);
        rvMovies.setAdapter(cardViewMovieAdapter);
    }

}
