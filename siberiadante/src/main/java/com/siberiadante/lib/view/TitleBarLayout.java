package com.siberiadante.lib.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siberiadante.lib.R;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.util.ScreenUtil;
import com.siberiadante.lib.util.StringUtil;
import com.siberiadante.lib.util.TransitionTools;

/**
 * @Created SiberiaDante
 * @Describe： 使用说明<br/><a href="https://github.com/SiberiaDante/TitleLayout">GitHub</a>
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

public class TitleBarLayout extends RelativeLayout {
    private int mLayoutBarHeight = TransitionTools.dip2px(50);

    private int mLeftImage;
    private int mLeftImageWidth = TransitionTools.dip2px(30);
    private int mLeftImagePaddingStart = TransitionTools.dip2px(10);

    private String mLeftText = "";
    private int mLeftTextSize = TransitionTools.dip2px(16);
    private int mLeftTextColor = Color.BLACK;
    private int mLeftTextPaddingStart = TransitionTools.dip2px(10);

    private String mTitle = "";
    private float mTitleSize = TransitionTools.dip2px(18);
    private int mTitleColor = Color.BLACK;

    private String mSubTitle = "";
    private float mSubTitleSize = TransitionTools.dip2px(12);
    private int mSubTitleColor = Color.GRAY;


    private int mRightImage;
    private int mRightImageWidth = TransitionTools.dip2px(30);
    private int mRightImagePaddingEnd = TransitionTools.dip2px(10);

    private String mRightText = "";
    private float mRightTextSize = TransitionTools.dip2px(16);
    private int mRightTextColor = Color.BLACK;
    private int mRightTextPaddingEnd = TransitionTools.dip2px(10);

    private int mLineHeight = 1;

    private boolean mIsBackView = true;

    private boolean mIsImmersiveStateBar = false;

    private int mLineBackground = Color.BLACK;
    private int mLayoutBackground = Color.BLACK;

    private View inflate;
    private ImageView mIvLeft;
    private TextView mTvLeft;
    private TextView mTvTitle;
    private TextView mTvSubTitle;
    private ImageView mIvRight;
    private TextView mTvRight;
    private View mViewLine;
    private RelativeLayout mRlLayout, mRlLeft, mRlRight;
    private LinearLayout mRlCenter;

    private int mStatusBarHeight = 20;

    private int mLeftTotalWidth;
    private int mRightTotalWidth;

    private Context mContext;
    private int mScreenWidth;

    public TitleBarLayout(@NonNull Context context) {
        this(context, null);
    }

    public TitleBarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBarLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        mStatusBarHeight = ScreenUtil.getStatusBarHeight();
        inflate = LayoutInflater.from(context).inflate(R.layout.title_bar_layout, null);
        addView(inflate);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TitleBarLayout);

        mLayoutBarHeight = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_title_layout_height, mLayoutBarHeight);
        mLayoutBackground = attributes.getColor(R.styleable.TitleBarLayout_d_title_layout_background, mLayoutBackground);

        /*
        左侧图片、图片大小、图片左边距
         */
        mLeftImage = attributes.getResourceId(R.styleable.TitleBarLayout_d_left_image, 0);
        mLeftImageWidth = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_left_image_width, mLeftImageWidth);
        mLeftImagePaddingStart = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_left_image_padding_start, mLeftImagePaddingStart);

        /*
        左侧文字、字体大小、字体颜色、字体左边距
         */
        mLeftText = attributes.getString(R.styleable.TitleBarLayout_d_left_text);
        mLeftTextSize = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_left_text_size, mLeftTextSize);
        mLeftTextPaddingStart = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_left_text_padding_start, mLeftTextPaddingStart);
        mLeftTextColor = attributes.getColor(R.styleable.TitleBarLayout_d_left_text_color, mLeftTextColor);

        /*
        标题文字、字体大小、字体颜色
        需要新增标题左右padding属性
         */
        mTitle = attributes.getString(R.styleable.TitleBarLayout_d_title_text);
        mTitleSize = attributes.getDimension(R.styleable.TitleBarLayout_d_title_size, mTitleSize);
        mTitleColor = attributes.getColor(R.styleable.TitleBarLayout_d_title_color, mTitleColor);

        /*
         副标题
         */
        mSubTitle = attributes.getString(R.styleable.TitleBarLayout_d_subtitle_text);
        mSubTitleSize = attributes.getDimension(R.styleable.TitleBarLayout_d_subtitle_size, mSubTitleSize);
        mSubTitleColor = attributes.getColor(R.styleable.TitleBarLayout_d_subtitle_color, mSubTitleColor);

        /*
        右侧图片、图片大小、图片左边距
         */
        mRightImage = attributes.getResourceId(R.styleable.TitleBarLayout_d_right_image, 0);
        mRightImageWidth = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_right_image_width, mRightImageWidth);
        mRightImagePaddingEnd = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_right_image_padding_end, mRightImagePaddingEnd);

        /*
        右侧文字、字体大小、字体颜色、字体左边距
         */
        mRightText = attributes.getString(R.styleable.TitleBarLayout_d_right_text);
        mRightTextSize = attributes.getDimension(R.styleable.TitleBarLayout_d_right_text_size, mRightTextSize);
        mRightTextPaddingEnd = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_right_text_padding_end, mRightTextPaddingEnd);
        mRightTextColor = attributes.getColor(R.styleable.TitleBarLayout_d_right_text_color, mRightTextColor);

        /*
        底部横线背景、高度
         */
        mLineBackground = attributes.getColor(R.styleable.TitleBarLayout_d_line_background, mLineBackground);
        mLineHeight = attributes.getDimensionPixelSize(R.styleable.TitleBarLayout_d_line_height, mLineHeight);
        /*
        左侧图标和文字是否为返回键
         */
        mIsBackView = attributes.getBoolean(R.styleable.TitleBarLayout_d_is_back_view, mIsBackView);
        /*
        是否沉浸式状态栏
         */
        mIsImmersiveStateBar = attributes.getBoolean(R.styleable.TitleBarLayout_d_is_immersive_state_bar, mIsImmersiveStateBar);

        attributes.recycle();
        initView(inflate);
        initData();

    }

    private void initView(View inflate) {
        mRlLayout = ((RelativeLayout) inflate.findViewById(R.id.rl_title_bar_height));
        mRlLeft = ((RelativeLayout) inflate.findViewById(R.id.rl_left));
        mRlRight = ((RelativeLayout) inflate.findViewById(R.id.rl_right));
        mRlCenter = ((LinearLayout) inflate.findViewById(R.id.ll_center));
        mIvLeft = ((ImageView) inflate.findViewById(R.id.iv_left));
        mTvLeft = ((TextView) inflate.findViewById(R.id.tv_left));
        mTvTitle = ((TextView) inflate.findViewById(R.id.tv_title));
        mTvSubTitle = ((TextView) inflate.findViewById(R.id.tv_sub_title));
        mIvRight = ((ImageView) inflate.findViewById(R.id.iv_right));
        mTvRight = ((TextView) inflate.findViewById(R.id.tv_right));
        mViewLine = inflate.findViewById(R.id.view_line);
    }

    private void initData() {
        initLayoutHeight();
        mRlLayout.setBackgroundColor(mLayoutBackground);

        //左边图标
        if (mLeftImage != 0) {
            mIvLeft.setVisibility(VISIBLE);
            mIvLeft.setImageResource(mLeftImage);
            //image size
            ViewGroup.LayoutParams mIvLeftLayoutParams = mIvLeft.getLayoutParams();
            mIvLeftLayoutParams.width = mLeftImageWidth;
            mIvLeft.setLayoutParams(mIvLeftLayoutParams);
            mIvLeft.setPadding(mLeftImagePaddingStart, 0, 0, 0);
            mLeftTotalWidth += mLeftImageWidth;
            LogUtil.d("---------" + mLeftTotalWidth + "------------");
            mLeftTotalWidth += mLeftImagePaddingStart;
            LogUtil.d("---------" + mLeftTotalWidth + "------------");

        } else {
            mIvLeft.setVisibility(GONE);
        }

        if (StringUtil.isEmpty(mLeftText)) {
            LogUtil.d("-----------------null----------------");
            mTvLeft.setPadding(0, 0, 100, 0);
        }

        //左边文字
        if (StringUtil.isEmpty(mLeftText)) {
            mTvLeft.setVisibility(GONE);
        } else {
            mTvLeft.setVisibility(VISIBLE);
            mTvLeft.setText(mLeftText);
            mTvLeft.setTextSize(TransitionTools.px2sp(mLeftTextSize));
            mTvLeft.setTextColor(mLeftTextColor);
            mTvLeft.setPadding(mLeftTextPaddingStart, 0, 0, 0);
            mLeftTotalWidth += mLeftTextPaddingStart;
        }

        //标题
        if (StringUtil.isEmpty(mTitle)) {
            mTvTitle.setVisibility(INVISIBLE);
        } else {
            mTvTitle.setVisibility(VISIBLE);
            mTvTitle.setText(mTitle);
            mTvTitle.setTextSize(TransitionTools.px2sp(mTitleSize));
            mTvTitle.setTextColor(mTitleColor);
        }

        //副标题
        if (StringUtil.isEmpty(mSubTitle)) {
            mTvSubTitle.setVisibility(GONE);
        } else {
            mTvSubTitle.setVisibility(VISIBLE);
            mTvSubTitle.setText(mSubTitle);
            mTvSubTitle.setTextSize(TransitionTools.px2sp(mSubTitleSize));
            mTvSubTitle.setTextColor(mSubTitleColor);
            mTvSubTitle.setGravity(Gravity.TOP | Gravity.CENTER);
            mTvTitle.setGravity(Gravity.BOTTOM | Gravity.CENTER);
        }

        //右边图标
        if (mRightImage != 0) {
            mIvRight.setVisibility(VISIBLE);
            mTvRight.setVisibility(GONE);
            mIvRight.setImageResource(mRightImage);
            ViewGroup.LayoutParams mIvRightLayoutParams = mIvRight.getLayoutParams();
            mIvRightLayoutParams.width = mRightImageWidth;
            mIvRight.setLayoutParams(mIvRightLayoutParams);
            mIvRight.setPadding(0, 0, mRightImagePaddingEnd, 0);
        } else {
            mIvRight.setVisibility(GONE);
        }

        //右边文字
        if (StringUtil.isEmpty(mRightText)) {
            mTvRight.setVisibility(GONE);
        } else {
            mTvRight.setVisibility(VISIBLE);
            mIvRight.setVisibility(GONE);
            mTvRight.setText(mRightText);
            mTvRight.setTextSize(TransitionTools.px2sp(mRightTextSize));
            mTvRight.setTextColor(mRightTextColor);
            mTvRight.setPadding(0, 0, mRightImagePaddingEnd, 0);
        }

        /**
         * 如果是返回键，则点击实现页面返回，否则获取点击事件{@code setLeftClickListener()}
         */
        if (mIsBackView) {
            mTvLeft.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity) mContext).finish();
                }
            });
            mTvLeft.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity) mContext).finish();
                }
            });
        }

        //横线
        mViewLine.setBackgroundColor(mLineBackground);
        //横线高度
        if (mLineHeight != 0) {
            ViewGroup.LayoutParams mViewLineLayoutParams = mViewLine.getLayoutParams();
            mViewLineLayoutParams.height = mLineHeight;
            mViewLine.setLayoutParams(mViewLineLayoutParams);
        }
    }

    private void initLayoutHeight() {
        if (mIsImmersiveStateBar) {
            int layoutHeight = mLayoutBarHeight + mStatusBarHeight;
            RelativeLayout.LayoutParams mRlLayoutLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, layoutHeight);
            mRlLayoutLayoutParams.addRule(CENTER_IN_PARENT);
            mRlLayout.setLayoutParams(mRlLayoutLayoutParams);
            mRlLayout.setPadding(0, mStatusBarHeight, 0, 0);
        } else {
            RelativeLayout.LayoutParams mRlLayoutLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mLayoutBarHeight);
            mRlLayoutLayoutParams.addRule(CENTER_IN_PARENT);
            mRlLayout.setLayoutParams(mRlLayoutLayoutParams);
        }
    }

    /**
     * 设置title
     *
     * @param title
     */
    public void setTitle(CharSequence title) {
        if (!StringUtil.isEmpty(title.toString())) {
            mTvTitle.setText(title);
        }
    }

    /**
     * 设置标题大小
     *
     * @param titleSize
     */
    public void setTitleSize(int titleSize) {
        if (titleSize != 0) {
            mTvTitle.setTextSize(titleSize);
        }
    }

    /**
     * 设置标题颜色
     *
     * @param titleColor
     */
    public void setTitleColor(int titleColor) {
        if (titleColor != 0) {
            mTvTitle.setTextColor(titleColor);
        }
    }

    /**
     * 一键设置标题样式、资源等
     *
     * @param title
     * @param titleSize
     * @param titleColor
     */
    public void setTitleStyle(String title, int titleSize, int titleColor) {
        if (!StringUtil.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (titleSize != 0) {
            mTvTitle.setTextSize(titleSize);
        }
        if (titleColor != 0) {
            mTvTitle.setTextColor(titleColor);
        }
    }

    /**
     * 设置副title
     *
     * @param title
     */
    public void setSubTitle(CharSequence title) {
        if (!StringUtil.isEmpty(title.toString())) {
            mTvSubTitle.setVisibility(VISIBLE);
            mTvSubTitle.setText(title);
            mTvSubTitle.setGravity(Gravity.TOP | Gravity.CENTER);
            mTvTitle.setGravity(Gravity.BOTTOM | Gravity.CENTER);
        }
    }

    /**
     * 设置副标题大小
     *
     * @param titleSize
     */
    public void setSubTitleSize(int titleSize) {
        if (titleSize != 0) {
            mTvSubTitle.setVisibility(VISIBLE);
            mTvSubTitle.setTextSize(titleSize);
            mTvSubTitle.setGravity(Gravity.TOP | Gravity.CENTER);
            mTvTitle.setGravity(Gravity.BOTTOM | Gravity.CENTER);
        }
    }

    /**
     * 设置副标题颜色
     *
     * @param titleColor
     */
    public void setSubTitleColor(int titleColor) {
        if (titleColor != 0) {
            mTvSubTitle.setVisibility(VISIBLE);
            mTvSubTitle.setTextColor(titleColor);
            mTvSubTitle.setGravity(Gravity.TOP | Gravity.CENTER);
            mTvTitle.setGravity(Gravity.BOTTOM | Gravity.CENTER);
        }
    }

    /**
     * 一键设置副标题样式、资源等
     *
     * @param title
     * @param titleSize
     * @param titleColor
     */
    public void setSubTitleStyle(String title, int titleSize, int titleColor) {
        if (!StringUtil.isEmpty(title)) {
            mTvSubTitle.setVisibility(VISIBLE);
            mTvSubTitle.setGravity(Gravity.TOP | Gravity.CENTER);
            mTvTitle.setGravity(Gravity.BOTTOM | Gravity.CENTER);
            mTvSubTitle.setText(title);
        }
        if (titleSize != 0) {
            mTvSubTitle.setTextSize(titleSize);
        }
        if (titleColor != 0) {
            mTvSubTitle.setTextColor(titleColor);
        }
    }

    /**
     * 设置左边文字内容
     *
     * @param leftText
     */
    public void setLeftText(String leftText) {
        if (!StringUtil.isEmpty(leftText)) {
            mTvLeft.setText(leftText);
        }
    }

    /**
     * 设置左边文字大小
     *
     * @param leftTextSize
     */
    public void setLeftTextSize(int leftTextSize) {
        if (leftTextSize != 0) {
            mTvLeft.setTextSize(leftTextSize);
        }
    }

    /**
     * 设置左边文字颜色
     *
     * @param leftTextColor
     */
    public void setLeftTextColor(int leftTextColor) {
        if (leftTextColor != 0) {
            mTvLeft.setTextColor(leftTextColor);
        }
    }

    /**
     * 一键设置左侧文字样式、资源等
     *
     * @param leftText
     * @param leftTextSize
     * @param leftTextColor
     */
    public void setLeftStyle(String leftText, int leftTextSize, int leftTextColor) {
        if (!StringUtil.isEmpty(leftText)) {
            mTvTitle.setText(leftText);
        }
        if (leftTextSize != 0) {
            mTvTitle.setTextSize(leftTextSize);
        }
        if (leftTextColor != 0) {
            mTvTitle.setTextColor(leftTextColor);
        }
    }

    /**
     * 设置右侧文字
     *
     * @param rightText
     */
    public void setRightText(String rightText) {
        if (!StringUtil.isEmpty(rightText)) {
            mTvRight.setText(rightText);
        }
    }

    /**
     * 设置右侧文字大小
     *
     * @param rightTextSize
     */
    public void setRightTextSize(int rightTextSize) {
        if (rightTextSize != 0) {
            mTvRight.setTextSize(rightTextSize);
        }
    }

    /**
     * 设置右侧文字颜色
     *
     * @param rightTextColor
     */
    public void setRightTextColor(int rightTextColor) {
        if (rightTextColor != 0) {
            mTvRight.setTextColor(rightTextColor);
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
     * 副标题点击事件
     *
     * @param listener
     */
    public void setSubTitleClickListener(OnClickListener listener) {
        mTvSubTitle.setOnClickListener(listener);
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

    /**
     * 设置左侧文字和按钮是否为返回按钮
     *
     * @param isLeftBackView
     */
    public void setIsLeftBackView(boolean isLeftBackView) {
        mIsBackView = isLeftBackView;
    }

    /**
     * @param isImmersiveStateBar
     */
    public void setIsImmersiveStateBar(boolean isImmersiveStateBar) {
        mIsImmersiveStateBar = isImmersiveStateBar;
        initLayoutHeight();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mScreenWidth = MeasureSpec.getSize(widthMeasureSpec);
        int mRlLeftMeasuredWidth = mRlLeft.getMeasuredWidth();
        int mRlRightMeasuredWidth = mRlRight.getMeasuredWidth();
        if (mRlLeftMeasuredWidth > mRlRightMeasuredWidth) {
            mRlCenter.setPadding(mRlLeftMeasuredWidth + 20, 0, mRlLeftMeasuredWidth + 20, 0);
//            mTvTitle.setPadding(mRlLeftMeasuredWidth + 20, 0, mRlLeftMeasuredWidth + 20, 0);


        } else {
            mRlCenter.setPadding(mRlRightMeasuredWidth + 20, 0, mRlRightMeasuredWidth + 20, 0);
//            mTvTitle.setPadding(mRlRightMeasuredWidth + 20, 0, mRlRightMeasuredWidth + 20, 0);
        }
    }
}
