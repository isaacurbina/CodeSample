package com.isaacurbina.projects.moviesapps;

import org.junit.Test;

import com.isaacurbina.projects.moviesapp.entities.Page;
import com.isaacurbina.projects.moviesapp.entities.Result;
import com.isaacurbina.projects.moviesapp.entities.ReviewPage;
import com.isaacurbina.projects.moviesapp.entities.ReviewResult;
import com.isaacurbina.projects.moviesapp.entities.VideoPage;
import com.isaacurbina.projects.moviesapp.entities.VideoResult;
import com.isaacurbina.projects.moviesapp.network.MoviesRetrofit;

import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class RetrofitUnitTest {
    @Test
    public void retrofit_isCorrect() throws Exception {
        MoviesRetrofit moviesRetrofit = new MoviesRetrofit();

        Page page = moviesRetrofit.getMovies("popularity");
        ReviewPage reviewPage = moviesRetrofit.getReviews("293660");
        VideoPage videoPage = moviesRetrofit.getVideos("87101");

        assertTrue(page.getResults().size() > 0);
        for (Result result : page.getResults()){
            System.out.println(result.getTitle());
        }

        System.out.println("");

        assertTrue(reviewPage.getReviewResults().size() > 0);
        for (ReviewResult reviewResult : reviewPage.getReviewResults()){
            System.out.println(reviewResult.getContent());
        }

        System.out.println("");

        assertTrue(videoPage.getVideoResults().size() > 0);
        for (VideoResult videoResult : videoPage.getVideoResults()){
            System.out.println(videoResult.getKey());
        }
    }
}