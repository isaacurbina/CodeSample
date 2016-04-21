package com.isaacurbina.projects.moviesapp.tasks;

import android.os.AsyncTask;

import com.isaacurbina.projects.moviesapp.entities.VideoPage;
import com.isaacurbina.projects.moviesapp.entities.VideoResult;
import com.isaacurbina.projects.moviesapp.fragments.DetailsFragment;
import com.isaacurbina.projects.moviesapp.network.MoviesRetrofit;

import java.util.List;

/**
 * Created by Isaac Urbina
 */
public class RetrieveVideosTask extends AsyncTask<Integer, Void, List<VideoResult>> {

    DetailsFragment mDetailsFragment;

    public RetrieveVideosTask(DetailsFragment detailsFragment) {
        mDetailsFragment = detailsFragment;
    }

    @Override
    protected List<VideoResult> doInBackground(Integer... params) {
        String movieId = (params.length > 0) ? String.valueOf(params[0]) : "293660";

        MoviesRetrofit moviesRetrofit = new MoviesRetrofit();

        VideoPage videoPage = moviesRetrofit.getVideos(movieId);

        return (videoPage!= null) ? videoPage.getVideoResults() : null;
    }

    @Override
    protected void onPostExecute(List<VideoResult> videoResults) {
        super.onPostExecute(videoResults);

        if (!isCancelled() && mDetailsFragment != null){
            mDetailsFragment.refreshVideos(videoResults);
        }

        clearReferences();
    }

    private void clearReferences() {
        mDetailsFragment = null;
    }
}
