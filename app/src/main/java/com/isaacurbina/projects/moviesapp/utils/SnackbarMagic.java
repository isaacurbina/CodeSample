package com.isaacurbina.projects.moviesapp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Isaac Urbina
 */
public class SnackbarMagic {
    public static void showSnackbar(View anchor, int messageId) {
        if (anchor != null) {
            Snackbar snackbar = Snackbar.make(anchor, messageId, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }
}
