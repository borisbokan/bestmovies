package com.borcha.bmovies.fragmenti;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.borcha.bmovies.Model.MyMovie;
import com.borcha.bmovies.R;
import com.borcha.bmovies.aktivnosti.MainActivity;


/**
 * Created by androiddevelopment on 20.5.17..
 */

public class FragmentLista extends Fragment implements AdapterView.OnItemClickListener {

    private View vi;
    private ListView movieList;
    onItemMovieSelectListener onItemMovieSelect;
    private int position = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vi = inflater.inflate(R.layout.list_fragment, container, false);
        movieList = vi.findViewById(R.id.lvMovieList);
        return vi;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        movieList.setAdapter(MainActivity.topMovies);
        movieList.setOnItemClickListener(this);
    }


    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);


        try {
            onItemMovieSelect = (onItemMovieSelectListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        onItemMovieSelect.onMovieSelect(pos);
        MyMovie movi = (MyMovie) adapterView.getItemAtPosition(pos);

        Toast.makeText(getActivity(), "Selected: " + movi.getTitle(), Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pos", this.position);


    }

    public interface onItemMovieSelectListener {
        void onMovieSelect(int position);


    }
}
