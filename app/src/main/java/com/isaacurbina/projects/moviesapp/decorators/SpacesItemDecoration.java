package com.isaacurbina.projects.moviesapp.decorators;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Isaac Urbina
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int mSpace;

    public SpacesItemDecoration(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.bottom = mSpace;

        if (parent.getChildAdapterPosition(view) % 2 == 1){
            outRect.right = mSpace;
        }

        if (parent.getChildAdapterPosition(view) < 2){
            outRect.top = mSpace;
        }
    }
}