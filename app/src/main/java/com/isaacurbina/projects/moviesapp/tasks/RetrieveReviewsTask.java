package com.isaacurbina.projects.moviesapp.tasks;

import android.os.AsyncTask;

import com.isaacurbina.projects.moviesapp.entities.ReviewPage;
import com.isaacurbina.projects.moviesapp.entities.ReviewResult;
import com.isaacurbina.projects.moviesapp.fragments.DetailsFragment;
import com.isaacurbina.projects.moviesapp.network.MoviesRetrofit;

import java.util.List;

/**
 * Created by Isaac Urbina
 */
public class RetrieveReviewsTask extends AsyncTask<Integer, Void, List<ReviewResult>> {

    DetailsFragment mDetailsFragment;

    public RetrieveReviewsTask(DetailsFragment detailsFragment) {
        mDetailsFragment = detailsFragment;
    }

    @Override
    protected List<ReviewResult> doInBackground(Integer... params) {
        String movieId = (params.length > 0) ? String.valueOf(params[0]) : "293660";

        MoviesRetrofit moviesRetrofit = new MoviesRetrofit();

        ReviewPage reviewPage = moviesRetrofit.getReviews(movieId);

        return (reviewPage != null) ? reviewPage.getReviewResults() : null;
    }

    @Override
    protected void onPostExecute(List<ReviewResult> reviewResults) {
        super.onPostExecute(reviewResults);

        if (!isCancelled() && mDetailsFragment != null){
            mDetailsFragment.refreshReviews(reviewResults);
        }

        clearReferences();
    }

    private void clearReferences() {
        mDetailsFragment = null;
    }
}
