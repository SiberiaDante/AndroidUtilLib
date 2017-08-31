package com.siberiadante.lib.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siberiadante.lib.R;
import com.siberiadante.lib.util.ScreenUtil;
import com.siberiadante.lib.util.TransitionTools;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/6/30
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class TitleBar extends ViewGroup implements View.OnClickListener {
    private static final int DEFAULT_MAIN_TEXT_SIZE = 18;
    private static final int DEFAULT_TEXT_SIZE = 16;
    private static final int DEFAULT_SUB_TEXT_SIZE = 12;
    private static final int DEFAULT_ACTION_TEXT_SIZE = 15;
    private static final int DEFAULT_TITLE_BAR_HEIGHT = 48;
    private boolean mImmersive;
    private TextView mLeftText;
    private LinearLayout mRightLayout;
    private LinearLayout mCenterLayout;
    private TextView mCenterText;
    private TextView mSubTitleText;
    private View mCustomCenterView;
    private View mDividerView;

    private int mScreenWidth;
    private int mStatusBarHeight;
    private int mActionPadding;
    private int mOutPadding;
    private int mLRPadding;
    private int mActionTextColor;
    private int mHeight;
    private LinearLayout mLeftLayout;
    private ImageView mLeftImage;
    private ImageView mRightImage;

    public TitleBar(Context context) {
        super(context);
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        if (mImmersive) {
            mStatusBarHeight = ScreenUtil.getStatusBarHeight();
        }
        mActionPadding = TransitionTools.dip2px(5);
        mOutPadding = TransitionTools.dip2px(8);
        mHeight = TransitionTools.dip2px(DEFAULT_TITLE_BAR_HEIGHT);
        mLRPadding = TransitionTools.dip2px(4);
        initView(context);
    }

    private void initView(Context context) {
        final int mIvHeight = (mHeight / 2);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        LayoutParams imageParams = new LayoutParams(mIvHeight, mIvHeight);
        //左中右、分割线
        mLeftLayout = new LinearLayout(context);
        mCenterLayout = new LinearLayout(context);
        mRightLayout = new LinearLayout(context);
        mDividerView = new LinearLayout(context);
        mDividerView.setBackgroundResource(R.color.black);
        //右边
        mRightImage = new ImageView(context);
        mRightLayout.addView(mRightImage, imageParams);
        mRightLayout.setPadding(mOutPadding, 0, mOutPadding, 0);
        mRightLayout.setGravity(Gravity.CENTER);
        mRightLayout.setOrientation(LinearLayout.VERTICAL);

        //左边
        mLeftImage = new ImageView(context);
        mLeftText = new TextView(context);

        mLeftText.setSingleLine(true);
        mLeftText.setEllipsize(TextUtils.TruncateAt.END);
        mLeftText.setGravity(Gravity.CENTER);
        mLeftText.setTextSize(DEFAULT_TEXT_SIZE);
        mLeftText.setPadding(mLRPadding, 0, 0, 0);

        mLeftImage.setImageResource(R.mipmap.back_gray);
        mLeftImage.setVisibility(GONE);
        mLeftLayout.addView(mLeftImage, imageParams);
        mLeftLayout.addView(mLeftText);
        mLeftLayout.setGravity(Gravity.CENTER);
        mLeftLayout.setOrientation(LinearLayout.HORIZONTAL);

        //中间
        mCenterText = new TextView(context);//标题
        mSubTitleText = new TextView(context);//标题描述

        mCenterText.setTextSize(DEFAULT_MAIN_TEXT_SIZE);
        mCenterText.setGravity(Gravity.CENTER);
        mCenterText.setSingleLine(true);
        mCenterText.setEllipsize(TextUtils.TruncateAt.END);

        mSubTitleText.setTextSize(DEFAULT_SUB_TEXT_SIZE);
        mSubTitleText.setGravity(Gravity.CENTER);
        mSubTitleText.setSingleLine(true);
        mSubTitleText.setEllipsize(TextUtils.TruncateAt.END);
        mSubTitleText.setVisibility(GONE);

        mCenterLayout.addView(mCenterText);
        mCenterLayout.addView(mSubTitleText);
        mCenterLayout.setGravity(Gravity.CENTER);
        mCenterLayout.setOrientation(LinearLayout.VERTICAL);

        addView(mLeftLayout, layoutParams);
        addView(mCenterLayout);
        addView(mRightLayout, layoutParams);
        addView(mDividerView, new LayoutParams(LayoutParams.MATCH_PARENT, 1));
    }

    /**
     * 底部分割线颜色
     *
     * @param color
     */
    public void setDivideBackground(int color) {
        mDividerView.setBackgroundColor(color);
    }

    /**
     * 隐藏标题栏底部分割线
     */
    public void setDivideGone() {
        mDividerView.setVisibility(GONE);
    }

    /**
     * 底部分割线背景图片
     *
     * @param drawable
     */
    public void setDivideBackground(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mDividerView.setBackground(drawable);
        } else {
            throw new UnsupportedOperationException("API require 16 ");
        }
    }

    /**
     * 项目中需要沉浸式状态栏时设置此方法为true
     *
     * @param immersive
     */
    public void setImmersive(boolean immersive) {
        mImmersive = immersive;
        if (mImmersive) {
            mStatusBarHeight = ScreenUtil.getStatusBarHeight();
        } else {
            mStatusBarHeight = 0;
        }
    }

    /**
     * 设置左边图片
     *
     * @param image
     */
    public void setLeftImage(int image) {
        mLeftImage.setImageResource(image);
    }

    /**
     * 设置左边图片
     *
     * @param bitmap
     */
    public void setLeftImage(Bitmap bitmap) {
        if (null == bitmap) {
            return;
        }
        mLeftImage.setImageBitmap(bitmap);
    }

    /**
     * 设置左边文字
     *
     * @param text
     */
    public void setLeftText(CharSequence text) {
        mLeftImage.setVisibility(VISIBLE);
        mLeftText.setText(text);
    }

    /**
     * 设置右边图片
     *
     * @param image
     */
    public void setRightImage(int image) {
        mRightImage.setImageResource(image);
    }

    /**
     * 设置右边图片
     *
     * @param bitmap
     */
    public void setRightBitmap(Bitmap bitmap) {
        mRightImage.setImageBitmap(bitmap);
    }

    /**
     * 设置主标题
     *
     * @param title
     */
    public void setTitle(CharSequence title) {
        mCenterText.setText(title);
    }

    /**
     * 设置主标题字体大小
     *
     * @param size
     */
    public void setTitleSize(float size) {
        mCenterText.setTextSize(size);
    }

    /**
     * 设置主标题字体颜色
     *
     * @param color
     */
    public void setTitleColor(int color) {
        mCenterText.setTextColor(color);
    }

    /**
     * 设置副标题
     *
     * @param title
     */
    public void setSubTitle(CharSequence title) {
        if ("".equals(title)) {
            mSubTitleText.setVisibility(GONE);
        } else {
            mSubTitleText.setVisibility(VISIBLE);
        }
        mSubTitleText.setText(title);
    }

    /**
     * 设置副标题字体大小
     *
     * @param size
     */
    public void setSubTitleSize(float size) {
        mSubTitleText.setTextSize(size);
    }

    /**
     * 设置副标题字体颜色
     *
     * @param color
     */
    public void setSubTitleColor(int color) {
        mSubTitleText.setTextColor(color);
    }


    public void setTitleLayoutOrientation(int orientation) {
        mCenterLayout.setGravity(orientation);
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * 标题的点击监听
     *
     * @param listener
     */
    public void setTitleListener(View.OnClickListener listener) {
        mCenterLayout.setOnClickListener(listener);
    }

    /**
     * 左边控件的点击监听
     *
     * @param listener
     */
    public void setLeftListener(View.OnClickListener listener) {
        mLeftLayout.setOnClickListener(listener);
    }

    /**
     * 右边控件的点击监听
     *
     * @param listener
     */
    public void setRightListener(View.OnClickListener listener) {
        mRightLayout.setOnClickListener(listener);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height;
        if (heightMode != MeasureSpec.EXACTLY) {
            height = mHeight + mStatusBarHeight;
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mHeight, MeasureSpec.EXACTLY);
        } else {
            height = MeasureSpec.getSize(heightMeasureSpec) + mStatusBarHeight;
        }
        mScreenWidth = MeasureSpec.getSize(widthMeasureSpec);
        measureChild(mLeftLayout, widthMeasureSpec, heightMeasureSpec);
        measureChild(mRightLayout, widthMeasureSpec, heightMeasureSpec);
        if (mLeftLayout.getMeasuredWidth() > mRightLayout.getMeasuredWidth()) {
            mCenterLayout.measure(
                    MeasureSpec.makeMeasureSpec(mScreenWidth - 2 * mLeftLayout.getMeasuredWidth(), MeasureSpec.EXACTLY)
                    , heightMeasureSpec);
        } else {
            mCenterLayout.measure(
                    MeasureSpec.makeMeasureSpec(mScreenWidth - 2 * mRightLayout.getMeasuredWidth(), MeasureSpec.EXACTLY)
                    , heightMeasureSpec);
        }
        measureChild(mDividerView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), height);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        mLeftLayout.layout(0, mStatusBarHeight, mLeftLayout.getMeasuredWidth(), mLeftLayout.getMeasuredHeight() + mStatusBarHeight);
        mRightLayout.layout(mScreenWidth - mRightLayout.getMeasuredWidth(), mStatusBarHeight,
                mScreenWidth, mRightLayout.getMeasuredHeight() + mStatusBarHeight);
        if (mLeftLayout.getMeasuredWidth() > mRightLayout.getMeasuredWidth()) {
            mCenterLayout.layout(mLeftLayout.getMeasuredWidth(), mStatusBarHeight,
                    mScreenWidth - mLeftLayout.getMeasuredWidth(), getMeasuredHeight());
        } else {
            mCenterLayout.layout(mRightLayout.getMeasuredWidth(), mStatusBarHeight,
                    mScreenWidth - mRightLayout.getMeasuredWidth(), getMeasuredHeight());
        }
        mDividerView.layout(0, getMeasuredHeight() - mDividerView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    }
}
