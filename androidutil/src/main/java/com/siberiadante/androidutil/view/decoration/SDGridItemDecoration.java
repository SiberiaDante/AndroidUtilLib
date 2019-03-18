package com.siberiadante.androidutil.view.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.IntDef;
import android.support.annotation.Px;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hxm on 2018/3/19.
 * {@link:https://github.com/hxmeie}
 * 使用方法：
 * SDGridItemDecoration decoration = new SDGridItemDecoration.Builder(this)
 *                 .size(SizeUtil.dp2px(5))
 *                 .verColorRes(R.color.aaaa)
 *                 .horColorRes(R.color.aaaa)
 *                 .margin(SizeUtil.dp2px(5))
 *                 .marginColorRes(R.color.colorAccent)
 *                 .build();
 */
public class SDGridItemDecoration extends RecyclerView.ItemDecoration {
    public static final int VERTICAL = GridLayoutManager.VERTICAL;
    public static final int HORIZONTAL = GridLayoutManager.HORIZONTAL;//暂时不支持水平方向，以后有空有兴趣就做
    private Paint mVerPaint, mHorPaint, marginPaint;
    private Builder mBuilder;

    private SDGridItemDecoration(Builder builder) {
        init(builder);
    }

    private void init(Builder builder) {
        this.mBuilder = builder;
        mVerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mVerPaint.setStyle(Paint.Style.FILL);
        mVerPaint.setColor(builder.verColor);
        mHorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHorPaint.setStyle(Paint.Style.FILL);
        mHorPaint.setColor(builder.horColor);
        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setStyle(Paint.Style.FILL);
        marginPaint.setColor(builder.marginColor);
    }

    /**
     * 需要注意的一点是 getItemOffsets 是针对每一个 ItemView，而 onDraw 方法却是针对 RecyclerView 本身，
     * 所以在 onDraw 方法中需要遍历屏幕上可见的 ItemView，分别获取它们的位置信息，然后分别的绘制对应的分割线。
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int itemCount = parent.getAdapter().getItemCount();
        int spanCount = getSpanCount(parent);
        drawHorizontal(c, parent, childCount, itemCount, spanCount);
        drawVertical(c, parent, childCount, spanCount);
        drawMarginLeftAndRight(c, parent, childCount, itemCount, spanCount);
        drawMarginTopAndBottom(c, parent, childCount, itemCount, spanCount);
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //每一个itemView的（left+right）相等且（top+bottom）也相等，这样才能保证itemView大小都一样
        int spanCount = getSpanCount(parent);
        int itemCount = parent.getAdapter().getItemCount();
        int itemPosition = parent.getChildLayoutPosition(view);
        int column = itemPosition % spanCount;
        int bottom = 0;
        int left = column * mBuilder.dividerVerSize / spanCount;
        int right = mBuilder.dividerVerSize - (column + 1) * mBuilder.dividerVerSize / spanCount;
        if (!isLastRow(itemPosition, spanCount, itemCount))
            bottom = mBuilder.dividerHorSize;
        outRect.set(left, 0, right, bottom);
        marginLeftAndRightOffsets(outRect, spanCount, itemPosition);
        marginTopAndBottomOffsets(outRect, spanCount, itemPosition, itemCount);
    }

    private void marginLeftAndRightOffsets(Rect outRect, int spanCount, int itemPosition) {
        if (mBuilder.marginRight <= 0 && mBuilder.marginLeft <= 0)
            return;
        int average = (mBuilder.marginLeft + mBuilder.marginRight) / spanCount;
        outRect.left += (mBuilder.marginLeft - (itemPosition % spanCount) * average);
        outRect.right += ((itemPosition % spanCount) + 1) * average - mBuilder.marginLeft;
    }

    private void marginTopAndBottomOffsets(Rect outRect, int spanCount, int itemPosition, int itemCount) {
        if (mBuilder.marginTop <= 0 && mBuilder.marginBottom <= 0)
            return;
        if (isFirstRow(itemPosition, spanCount))
            outRect.top += mBuilder.marginTop;
        if (isLastRow(itemPosition, spanCount, itemCount))
            outRect.bottom += mBuilder.marginBottom;

    }

    private void drawHorizontal(Canvas c, RecyclerView parent, int childCount, int itemCount, int spanCount) {
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);
            if (isLastRow(position, spanCount, itemCount))
                continue;
            final int left = child.getLeft();
            final int top = child.getBottom();
            final int right = isLastColumn(position, spanCount, childCount) ? child.getRight() :
                    child.getRight() + mBuilder.dividerVerSize;
            final int bottom = child.getBottom() + mBuilder.dividerHorSize;
            c.drawRect(left, top, right, bottom, mHorPaint);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent, int childCount, int spanCount) {
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);
            if (isLastColumn(position, spanCount, childCount))
                continue;
            final int left = child.getRight();
            final int top = child.getTop();
            final int right = child.getRight() + mBuilder.dividerVerSize;
            final int bottom = child.getBottom();
            c.drawRect(left, top, right, bottom, mVerPaint);
        }
    }

    private void drawMarginLeftAndRight(Canvas c, RecyclerView parent, int childCount, int itemCount, int spanCount) {
        if (mBuilder.marginLeft <= 0 && mBuilder.marginRight <= 0)
            return;
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);
            if (isFirstColumn(position, spanCount)) {
                int l = child.getLeft() - mBuilder.marginLeft;
                int t = child.getTop() - mBuilder.marginTop;
                int r = child.getLeft();
                int b = isLastRow(position, spanCount, itemCount) ? child.getBottom() + mBuilder.marginBottom :
                        child.getBottom() + mBuilder.dividerHorSize;
                c.drawRect(l, t, r, b, marginPaint);
            }
            if (isLastColumn(position, spanCount, childCount)) {
                int l = child.getRight();
                int t = child.getTop() - mBuilder.marginTop;
                int r = child.getRight() + mBuilder.marginRight;
                int b = isLastRow(position, spanCount, itemCount) ? child.getBottom() + mBuilder.marginBottom :
                        child.getBottom() + mBuilder.dividerHorSize;
                c.drawRect(l, t, r, b, marginPaint);
            }
        }
    }

    private void drawMarginTopAndBottom(Canvas c, RecyclerView parent, int childCount, int itemCount, int spanCount) {
        if (mBuilder.marginTop <= 0 && mBuilder.marginBottom <= 0)
            return;
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);
            if (isFirstRow(position, spanCount)) {
                int l = child.getLeft();
                int t = child.getTop() - mBuilder.marginTop;
                int r = isLastColumn(position, spanCount, childCount) ? child.getRight() : child.getRight() + mBuilder.dividerVerSize;
                int b = child.getTop();
                c.drawRect(l, t, r, b, marginPaint);
            }

            if (isLastRow(position, spanCount, itemCount)) {
                int l = child.getLeft();
                int t = child.getBottom();
                int r = isLastColumn(position, spanCount, childCount) ? child.getRight() : child.getRight() + mBuilder.dividerVerSize;
                int b = child.getBottom() + mBuilder.marginBottom;
                c.drawRect(l, t, r, b, marginPaint);
            }
        }
    }

    private int getSpanCount(RecyclerView parent) {
        // 列数
        int spanCount = -1;
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            spanCount = ((StaggeredGridLayoutManager) layoutManager)
                    .getSpanCount();
        }
        return spanCount;
    }

    /**
     * 是否是第一行
     */
    private boolean isFirstRow(int position, int spanCount) {
        if (mBuilder.orientation == VERTICAL) {
            //垂直方向上
            return position < spanCount;
        } else {
            //水平方向上
            return position % spanCount == 0;
        }
    }

    /**
     * 是否是最后一行
     */
    private boolean isLastRow(int position, int spanCount, int childCount) {
        if (mBuilder.orientation == VERTICAL) {
            int lastRowCount = childCount % spanCount;
            lastRowCount = lastRowCount == 0 ? spanCount : lastRowCount;
            return position >= childCount - lastRowCount;
        } else {
            return (position + 1) % spanCount == 0;
        }
    }

    /**
     * 是否是第一列
     */
    private boolean isFirstColumn(int position, int spanCount) {
        if (mBuilder.orientation == VERTICAL) {
            return position % spanCount == 0;
        } else {
            return position < spanCount;
        }
    }

    /**
     * 是否是最后一列
     */
    private boolean isLastColumn(int position, int spanCount, int childCount) {
        if (mBuilder.orientation == VERTICAL) {
            return (position + 1) % spanCount == 0;
        } else {
            int lastColumnCount = childCount % spanCount;
            lastColumnCount = lastColumnCount == 0 ? spanCount : lastColumnCount;
            //最后一列itemView的position一定大于等于itemView总数量-最后一列itemView数量
            return position >= childCount - lastColumnCount;
        }
    }

    @IntDef({
            HORIZONTAL,
            VERTICAL
    })
    @Retention(RetentionPolicy.SOURCE)
    private @interface Orientation {
    }

    public static class Builder {
        private int horColor = Color.parseColor("#000000");//横向线颜色
        private int verColor = Color.parseColor("#000000");//纵向线颜色
        private int marginColor = Color.parseColor("#000000");
        private int dividerHorSize = 2;//横向线宽度
        private int dividerVerSize = 2;//纵向线宽度
        private int marginLeft = 0, marginRight = 0;
        private int marginTop = 0, marginBottom = 0;
        private int margin = 0;
        private int orientation = VERTICAL;//滑动方向，默认垂直
        private Context c;

        public Builder(Context c) {
            this.c = c;
        }

        /**
         * 设置divider的颜色
         */
        public Builder colorRes(@ColorRes int color) {
            this.horColor = ContextCompat.getColor(c, color);
            this.verColor = ContextCompat.getColor(c, color);
            return this;
        }

        /**
         * 设置divider的颜色
         */
        public Builder colorInt(@ColorInt int color) {
            this.horColor = color;
            this.verColor = color;
            return this;
        }

        public Builder marginColorRes(@ColorRes int color) {
            this.marginColor = ContextCompat.getColor(c, color);
            return this;
        }

        public Builder marginColorInt(@ColorInt int color) {
            this.marginColor = color;
            return this;
        }

        /**
         * 单独设置横向divider的颜色
         */
        public Builder horColorRes(@ColorRes int horColor) {
            this.horColor = ContextCompat.getColor(c, horColor);
            return this;
        }

        /**
         * 单独设置横向divider的颜色
         */
        public Builder horColorInt(@ColorInt int horColor) {
            this.horColor = horColor;
            return this;
        }

        /**
         * 单独设置纵向divider的颜色
         */
        public Builder verColorRes(@ColorRes int verColor) {
            this.verColor = ContextCompat.getColor(c, verColor);
            return this;
        }

        /**
         * 单独设置纵向divider的颜色
         */
        public Builder verColorInt(@ColorInt int verColor) {
            this.verColor = verColor;
            return this;
        }

        /**
         * 设置divider的宽度
         */
        public Builder size(@Px int size) {
            this.dividerHorSize = size;
            this.dividerVerSize = size;
            return this;
        }

        /**
         * 设置横向divider的宽度
         */
        public Builder horSize(@Px int horSize) {
            this.dividerHorSize = horSize;
            return this;
        }

        /**
         * 设置纵向divider的宽度
         */
        public Builder verSize(@Px int verSize) {
            this.dividerVerSize = verSize;
            return this;
        }

        public Builder margin(@Px int margin) {
            this.marginLeft = margin;
            this.marginRight = margin;
            this.marginTop = margin;
            this.marginBottom = margin;
            return this;
        }

        public Builder marginLeft(@Px int marginLeft) {
            this.marginLeft = marginLeft;
            return this;
        }

        public Builder marginRight(@Px int marginRight) {
            this.marginRight = marginRight;
            return this;
        }

        public Builder marginTop(@Px int marginTop) {
            this.marginTop = marginTop;
            return this;
        }

        public Builder marginBottom(@Px int marginBottom) {
            this.marginBottom = marginBottom;
            return this;
        }

        public Builder marginLeftAndRight(@Px int margin) {
            this.marginLeft = margin;
            this.marginRight = margin;
            return this;
        }

        public Builder marginTopAndBottom(@Px int margin) {
            this.marginTop = margin;
            this.marginBottom = margin;
            return this;
        }

        /**
         * 设置滑动方向
         */
        public Builder orientation(@Orientation int orientation) {
            this.orientation = orientation;
            return this;
        }

        public SDGridItemDecoration build() {
            return new SDGridItemDecoration(this);
        }

    }
}
