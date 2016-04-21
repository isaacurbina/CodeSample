package com.isaacurbina.projects.moviesapp.tasks;

import android.os.AsyncTask;

import com.isaacurbina.projects.moviesapp.MainActivity;
import com.isaacurbina.projects.moviesapp.entities.Page;
import com.isaacurbina.projects.moviesapp.entities.Result;
import com.isaacurbina.projects.moviesapp.network.MoviesRetrofit;

import java.util.List;

/**
 * Created by Isaac Urbina
 */
public class RetrieveMoviesTask extends AsyncTask<String, Void, List<Result>> {

    private MainActivity mActivity;

    public RetrieveMoviesTask(MainActivity activity) {
        mActivity = activity;
    }

    @Override
    protected List<Result> doInBackground(String... params) {
        String order = (params.length < 1) ? "popularity.desc" : params[0] + ".desc";

        MoviesRetrofit moviesRetrofit = new MoviesRetrofit();

        Page results = moviesRetrofit.getMovies(order);

        return (results != null) ? results.getResults() : null;
    }

    @Override
    protected void onPostExecute(List<Result> results) {
        super.onPostExecute(results);

        if (!isCancelled() && mActivity != null) {
            mActivity.setResults(results);
        }

        clearReferences();
    }

    private void clearReferences() {
        mActivity = null;
    }
}
