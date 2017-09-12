package com.siberiadante.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siberiadante.lib.R;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.util.StringUtil;
import com.siberiadante.lib.util.TransitionTools;

/**
 * @Created SiberiaDante
 * @Describe： 可在布局中设置各种资源
 * 完善中：
 * 1、测量左右View的宽度，依次来衡量标题位置
 * 2、可设置View大小
 * 3、增加动态控制View等
 * 4、支持设置沉浸式状态栏
 * @Time: 2017/9/12
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class TitleBarLayout extends FrameLayout {
    private int mTitleBarHeight = 50;

    private int mLeftImage;
    private float mLeftImageSize = 30;
    private float mLeftImagePaddingStart = TransitionTools.dip2px(10);

    private String mLeftText = "";
    private float mLeftTextSize = TransitionTools.dip2px(16);
    private int mLeftTextColor = Color.BLACK;
    private int mLeftTextPaddingStart = TransitionTools.dip2px(10);

    private String mTitle = "";
    private float mTitleSize = TransitionTools.dip2px(18);
    private int mTitleColor = Color.BLACK;

    private int mRightImage;
    private float mRightImageSize = 30;
    private float mRightImagePaddingEnd = TransitionTools.dip2px(10);

    private String mRightText = "";
    private float mRightTextSize = TransitionTools.dip2px(16);
    private int mRightTextColor = Color.BLACK;
    private float mRightTextPaddingEndt = TransitionTools.dip2px(10);

    private float mLineHeight = 0.5f;
    private int mLineBackgound = Color.BLACK;
    private View inflate;
    private ImageView mIvLeft;
    private TextView mTvLeft;
    private TextView mTvTitle;
    private ImageView mIvRight;
    private TextView mTvRight;
    private View mViewLine;
    private RelativeLayout mRlTitle, mRlLeft, mRlRight;

    private int mStatusBarHeight;

    private int mLeftTotalWidth;
    private int mRightTotalWidth;


    public TitleBarLayout(@NonNull Context context) {
        this(context, null);
    }

    public TitleBarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBarLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate = LayoutInflater.from(context).inflate(R.layout.title_bar_layout, null);
        addView(inflate);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TitleBarLayout);

        /*
        左侧图片、图片大小、图片左边距
         */
        mLeftImage = attributes.getResourceId(R.styleable.TitleBarLayout_d_left_image, 0);
        mLeftImageSize = attributes.getDimension(R.styleable.TitleBarLayout_d_left_image_size, mLeftImageSize);
        mLeftImagePaddingStart = attributes.getDimension(R.styleable.TitleBarLayout_d_left_image_padding_start, mLeftImagePaddingStart);

        /*
        左侧文字、字体大小、字体颜色、字体左边距
         */
        mLeftText = attributes.getString(R.styleable.TitleBarLayout_d_left_text);
        mLeftTextSize = attributes.getDimension(R.styleable.TitleBarLayout_d_left_text_size, mLeftTextSize);
        mLeftTextPaddingStart = attributes.getLayoutDimension(R.styleable.TitleBarLayout_d_left_text_padding_start, mLeftTextPaddingStart);
        mLeftTextColor = attributes.getColor(R.styleable.TitleBarLayout_d_left_text_color, mLeftTextColor);

        /*
        标题文字、字体大小、字体颜色
         */
        mTitle = attributes.getString(R.styleable.TitleBarLayout_d_title_text);
        mTitleSize = attributes.getDimension(R.styleable.TitleBarLayout_d_title_size, mTitleSize);
        mTitleColor = attributes.getColor(R.styleable.TitleBarLayout_d_title_color, mTitleColor);

        /*
        右侧图片、图片大小、图片左边距
         */
        mRightImage = attributes.getResourceId(R.styleable.TitleBarLayout_d_right_image, 0);
        mRightImageSize = attributes.getDimension(R.styleable.TitleBarLayout_d_right_image_size, mRightImageSize);
        mRightImagePaddingEnd = attributes.getDimension(R.styleable.TitleBarLayout_d_right_image_padding_end, mRightImagePaddingEnd);

        /*
        右侧文字、字体大小、字体颜色、字体左边距
         */
        mRightText = attributes.getString(R.styleable.TitleBarLayout_d_right_text);
        mRightTextSize = attributes.getDimension(R.styleable.TitleBarLayout_d_right_text_size, mRightTextSize);
        mRightTextPaddingEndt = attributes.getDimension(R.styleable.TitleBarLayout_d_right_text_padding_end, mRightTextPaddingEndt);
        mRightTextColor = attributes.getColor(R.styleable.TitleBarLayout_d_right_text_color, mRightTextColor);

        /*
        底部横线背景、高度
         */
        mLineBackgound = attributes.getColor(R.styleable.TitleBarLayout_d_line_background, mLineBackgound);
        mLineHeight = attributes.getDimension(R.styleable.TitleBarLayout_d_line_height, mLineHeight);

        attributes.recycle();

        mRlTitle = ((RelativeLayout) inflate.findViewById(R.id.rl_title_bar_height));
        mRlLeft = ((RelativeLayout) inflate.findViewById(R.id.rl_left));
        mRlRight = ((RelativeLayout) inflate.findViewById(R.id.rl_right));
        mIvLeft = ((ImageView) inflate.findViewById(R.id.iv_left));
        mTvLeft = ((TextView) inflate.findViewById(R.id.tv_left));
        mTvTitle = ((TextView) inflate.findViewById(R.id.tv_title));
        mIvRight = ((ImageView) inflate.findViewById(R.id.iv_right));
        mTvRight = ((TextView) inflate.findViewById(R.id.tv_right));
        mViewLine = inflate.findViewById(R.id.view_line);

        //横线
        mViewLine.setBackgroundColor(mLineBackgound);
        //横线高度
        /*
        左边图标
         */
        if (mLeftImage != 0) {
            mIvLeft.setVisibility(VISIBLE);
            mIvLeft.setImageResource(mLeftImage);
            //image size

        } else {
            mIvLeft.setVisibility(GONE);
        }
        /*
         左边文字
         */
        if (StringUtil.isEmpty(mLeftText)) {
            mTvLeft.setVisibility(GONE);
        } else {
            mTvLeft.setVisibility(VISIBLE);
            mTvLeft.setText(mLeftText);
            mTvLeft.setTextSize(TransitionTools.px2sp(mLeftTextSize));
            mTvLeft.setTextColor(mLeftTextColor);
            mTvLeft.setPadding(TransitionTools.px2dip(mLeftTextPaddingStart), 0, 0, 0);
        }
        LogUtil.d("mTitleSize===" + mTitleSize);
        /*
        标题
         */
        if (StringUtil.isEmpty(mTitle)) {
            mTvTitle.setVisibility(INVISIBLE);
        } else {
            mTvTitle.setVisibility(VISIBLE);
            mTvTitle.setText(mTitle);
            mTvTitle.setTextSize(TransitionTools.px2sp(mTitleSize));
            mTvTitle.setTextColor(mTitleColor);
        }

        /*
        右边图标
         */
        if (mRightImage != 0) {
            mIvRight.setVisibility(VISIBLE);
            mIvRight.setImageResource(mRightImage);
            //image size

        } else {
            mIvRight.setVisibility(GONE);
        }
        /*
         右边文字
         */
        if (StringUtil.isEmpty(mRightText)) {
            mTvRight.setVisibility(GONE);
        } else {
            mTvRight.setVisibility(VISIBLE);
            mTvRight.setText(mRightText);
            mTvRight.setTextSize(TransitionTools.px2sp(mRightTextSize));
            mTvRight.setTextColor(mRightTextColor);
            mTvRight.setPadding(TransitionTools.px2dip(mRightImagePaddingEnd), 0, 0, 0);
        }

    }

    /**
     * 标题点击事件
     *
     * @param listener
     */
    public void setTitleClickListener(OnClickListener listener) {
        mTvTitle.setOnClickListener(listener);
    }

    /**
     * 左边按钮点击事件
     *
     * @param listener
     */
    public void setLeftClickListener(OnClickListener listener) {
        mIvLeft.setOnClickListener(listener);
        mTvLeft.setOnClickListener(listener);
    }

    /**
     * 右边文字按钮点击事件
     *
     * @param listener
     */
    public void setRightTextClickListener(OnClickListener listener) {
        mTvRight.setOnClickListener(listener);
    }

    /**
     * 右边图片按钮点击事件
     *
     * @param listener
     */
    public void setRightImageClickListener(OnClickListener listener) {
        mIvRight.setOnClickListener(listener);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
