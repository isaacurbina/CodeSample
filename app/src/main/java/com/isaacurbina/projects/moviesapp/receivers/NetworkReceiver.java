package com.isaacurbina.projects.moviesapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.isaacurbina.projects.moviesapp.fragments.MainFragment;
import com.isaacurbina.projects.moviesapp.utils.NetworkMagic;

/**
 * Created by Isaac Urbina
 */
public class NetworkReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkReceiverTAG_";
    MainFragment mMainFragment;

    public NetworkReceiver(MainFragment mainFragment) {
        mMainFragment = mainFragment;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (mMainFragment != null && NetworkMagic.isNetworkAvailable(context.getApplicationContext())){
            if (mMainFragment.isActuallyEmpty()){
                mMainFragment.getActivityCallback().onEmptyResults();
            }
        }
    }
}
