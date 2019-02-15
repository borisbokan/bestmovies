package com.borcha.bmovies.pomocne;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by borcha on 21.05.17..
 */

public class MovieImage {

    private Context context;

    public MovieImage(Context _context) {
        this.context = _context;
    }

    public Drawable getMovieImage(String _patchFileImage) {

        Drawable drawable = null;
        InputStream is = null;
        try {
            is = this.context.getAssets().open(_patchFileImage);
            drawable = Drawable.createFromStream(is, null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return drawable;


    }


}
