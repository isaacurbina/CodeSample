package com.isaacurbina.projects.moviesapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.isaacurbina.projects.moviesapp.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by evin on 2/8/16.®
 */
@RunWith(AndroidJUnit4.class)
public class RandomBehaviorTest {

    private static final String TAG = "RandomBehaviorTestTAG_";
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testRandomBehavior() {
        clickOnRandomItem(R.id.mainRecycler);
        onView(withId(R.id.detailsIsFavoriteIcon)).perform(click());

        pressBack();

        clickOnRandomItem(R.id.mainRecycler);
        onView(withId(R.id.detailsShareIcon)).perform(click());
    }

    private void clickOnRandomItem(int viewId) {
        int x = getRandomRecyclerPosition(viewId);

        Log.d(TAG, "clickOnRandomItem: " + x);

        onView(withId(viewId))
                .perform(RecyclerViewActions.scrollToPosition(x), RecyclerViewActions.actionOnItemAtPosition(x, click()));
    }

    private int getRandomRecyclerPosition(int recyclerId) {
        Random ran = new Random();
        RecyclerView recyclerView = (RecyclerView) mActivityRule.getActivity().findViewById(recyclerId);

        int n = (recyclerView == null || recyclerView.getAdapter().getItemCount() <= 0)
                ? 1
                : recyclerView.getAdapter().getItemCount() / 2;

        int next;

        Log.d(TAG, "getRandomRecyclerPosition: " + n);

        next = (n != 0)
                ? ran.nextInt(n)
                : 0;

        return next;
    }

}