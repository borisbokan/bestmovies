package com.borcha.bmovies.aktivnosti;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.borcha.bmovies.Model.AdapterTopMovies;
import com.borcha.bmovies.Model.Movies;
import com.borcha.bmovies.Model.MyMovie;
import com.borcha.bmovies.R;
import com.borcha.bmovies.fragmenti.FragmentDetalji;
import com.borcha.bmovies.fragmenti.FragmentLista;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean landscape = false;
    private boolean listaIdetalji = false;
    private static MyMovie movie;
    private Movies movies;
    public static AdapterTopMovies topMovies;

    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        if (savedInstanceState == null) {

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            FragmentLista fragmentLista = new FragmentLista();
            ft.add(R.id.lista_frame_fragment, fragmentLista, "lista_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }


        if (findViewById(R.id.detalji_frame_fragment) != null) {
            landscape = true;
            getFragmentManager().popBackStack();

            FragmentDetalji fragmentdetalji = (FragmentDetalji) getFragmentManager().findFragmentById(R.id.detalji_frame_fragment);
            if (fragmentdetalji == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                fragmentdetalji = new FragmentDetalji();
                ft.replace(R.id.detalji_frame_fragment, fragmentdetalji, "detalji_fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                listaIdetalji = true;

            }
            FillMovieDataJSON();
            topMovies = new AdapterTopMovies(this, R.id.lvMovieList, this.movies.getResults());

        }

    }

    public static void adMovie(MyMovie _movie) {
        movie = _movie;
    }

    public void FillMovieDataJSON() {

        this.movies.setResults(new ArrayList<MyMovie>());//Citanje iz JSON preko postman-a... Nisam stigao :(

    }
}
