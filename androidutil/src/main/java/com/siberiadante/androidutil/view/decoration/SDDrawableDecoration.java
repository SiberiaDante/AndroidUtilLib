package com.siberiadante.androidutil.view.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created:： SiberiaDante
 * @Date： 2017/11/11
 * Describe： RecyclerView 分隔线
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class SDDrawableDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;

    public SDDrawableDecoration(Drawable divider) {
        this.mDivider = divider;
    }

    @Override

    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        Rect rect = new Rect();
        rect.left = parent.getPaddingLeft();
        rect.right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            rect.top = childView.getBottom();
            rect.bottom = rect.top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(rect);
            mDivider.draw(c);
        }
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom += mDivider.getIntrinsicHeight();
    }
}
