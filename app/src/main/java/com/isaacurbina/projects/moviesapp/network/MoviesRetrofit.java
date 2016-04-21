package com.isaacurbina.projects.moviesapp.network;

import android.util.Log;

import com.isaacurbina.projects.moviesapp.entities.Page;
import com.isaacurbina.projects.moviesapp.entities.ReviewPage;
import com.isaacurbina.projects.moviesapp.entities.VideoPage;
import com.isaacurbina.projects.moviesapp.utils.Constants;
import com.isaacurbina.projects.moviesapp.utils.Keys;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Isaac Urbina
 */
public class MoviesRetrofit {

    private static final String TAG = "MoviesRetrofit";
    private static final String DATE_GTE = "2015-10-01";

    private MovieDBService buildMoviesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieDBService.class);
    }

    public Page getMovies(String order) {
        Call<Page> listCall = buildMoviesService().listMovies(order, Keys.MDB_API_KEY, DATE_GTE);

        Page results = null;

        try {
            results = listCall.execute().body();
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.toString());
        }

        return results;
    }

    public VideoPage getVideos(String movieId){
        Call<VideoPage> listCall = buildMoviesService().listVideos(movieId, Keys.MDB_API_KEY, DATE_GTE);

        VideoPage results = null;

        try {
            results = listCall.execute().body();
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.toString());
        }

        return results;
    }

    public ReviewPage getReviews(String movieId){
        Call<ReviewPage> listCall = buildMoviesService().listReviews(movieId, Keys.MDB_API_KEY, DATE_GTE);

        ReviewPage results = null;

        try {
            results = listCall.execute().body();
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.toString());
        }

        return results;
    }

}
