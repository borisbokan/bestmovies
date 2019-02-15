package com.borcha.bmovies.fragmenti;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.borcha.bmovies.Model.MyMovie;
import com.borcha.bmovies.R;
import com.borcha.bmovies.aktivnosti.MainActivity;
import com.borcha.bmovies.pomocne.MovieImage;

/**
 * Created by androiddevelopment on 20.5.17..
 */


public class FragmentDetalji extends Fragment implements FragmentLista.onItemGlumacSelectListener {


    private ImageView imgImageDetails;
    private TextView tvNameOfTheMoview, tvDescription;
    private RatingBar ratingBarMovie;
    private FloatingActionButton fabAddToFavorite;
    int position = 0;
    public MyMovie movie;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vi = inflater.inflate(R.layout.details_fragment, container, false);

        return vi;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pos", position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("pos", 0);

        }

        imgImageDetails = getView().findViewById(R.id.imgMovie_details);
        tvNameOfTheMoview = getView().findViewById(R.id.txtName_details);
        tvDescription = getView().findViewById(R.id.txvDescription_details);
        ratingBarMovie = getView().findViewById(R.id.ratingBar_details);
        fabAddToFavorite = getView().findViewById(R.id.fabAddToFavorite_details);

        //Podaci
        movie = MainActivity.topMovies.getItem(this.position);

//         slika=new MovieImage(getActivity());
        //imgSlikaGlumca.setImageDrawable(slika.getSlikaGlumca(glumac.getSlika().toString()));

        fabAddToFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Akcija dodaj novog glumca", Toast.LENGTH_SHORT).show();
            }
        });

        tvNameOfTheMoview.setText(movie.getTitle());
        ratingBarMovie.setRating(movie.getVote_average());
        tvDescription.setText(movie.getOverview());

    }


    public void updateContent(final int _pos) {

        this.position = _pos;

        imgImageDetails = getView().findViewById(R.id.imgMovie_details);
        tvNameOfTheMoview = getView().findViewById(R.id.txtName_details);
        tvDescription = getView().findViewById(R.id.txvDescription_details);
        ratingBarMovie = getView().findViewById(R.id.ratingBar_details);
        fabAddToFavorite = getView().findViewById(R.id.fabAddToFavorite_details);

        //Podaci
        movie = MainActivity.topMovies.getItem(this.position);

        MovieImage slika = new MovieImage(getActivity());
        imgImageDetails.setImageDrawable(slika.getMovieImage(movie.getPoster_path()));
        tvNameOfTheMoview.setText(movie.getTitle());
        ratingBarMovie.setRating(movie.getVote_average());
        tvDescription.setText(movie.getOverview());


    }

    public void setContent(final int _pos) {

        this.position = _pos;

    }


    @Override
    public void onGlumacSelect(int position) {
        this.position = position;


    }
}
