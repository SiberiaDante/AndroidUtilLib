package com.siberiadante.custom.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siberiadante.custom.R;
import com.siberiadante.lib.util.LogUtil;


/**
 * Created by hxm on 2017/4/26.
 * 描述：标题栏
 */
public class TitleLayout extends FrameLayout {

    public ImageView ivRightIcon;
    private int titleColor;
    private TextView title, right;
    private TitleClickListener listener, listenerRight, rightIconListener;
    private View view;
    private ImageView back;

    public TitleLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.h_title_layout, null);
        addView(view);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleLayoutStyle);
        String titleText = ta.getString(R.styleable.TitleLayoutStyle_title_name);
        String rightText = ta.getString(R.styleable.TitleLayoutStyle_right_text);
        int rightTextColor = ta.getColor(R.styleable.TitleLayoutStyle_right_text_color, ContextCompat.getColor(context, R.color.title_color));
        boolean bottomLineVisible = ta.getBoolean(R.styleable.TitleLayoutStyle_bottom_line_visible, false);
        int ivBack = ta.getResourceId(R.styleable.TitleLayoutStyle_iv_back_src, 0);
        int ivRight = ta.getResourceId(R.styleable.TitleLayoutStyle_iv_right_src, 0);
        int backgroundColor = ta.getColor(R.styleable.TitleLayoutStyle_title_background, Color.WHITE);
        titleColor = ta.getColor(R.styleable.TitleLayoutStyle_title_color, Color.WHITE);
        ta.recycle();
        RelativeLayout layoutTitle = (RelativeLayout) view.findViewById(R.id.layout_title);
        layoutTitle.setBackgroundColor(backgroundColor);
        //返回按钮
        back = (ImageView) view.findViewById(R.id.iv_back);
        if (ivBack != 0) {
            back.setVisibility(VISIBLE);
            back.setImageResource(ivBack);
            back.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity) context).finish();
                }
            });
        } else {
            back.setVisibility(INVISIBLE);
        }
        //中间标题和标题右侧文字
        title = (TextView) view.findViewById(R.id.tv_title);
        right = (TextView) view.findViewById(R.id.tv_right_text);
        right.setTextColor(rightTextColor);
        View bottomLine = view.findViewById(R.id.title_bottom_line);

        if (isEmpty(titleText)) {
            title.setVisibility(GONE);
        } else {
            title.setVisibility(VISIBLE);
            title.setText(titleText);
            title.setTextColor(titleColor);
        }

        if (isEmpty(rightText)) {
            right.setVisibility(GONE);
        } else {
            right.setVisibility(VISIBLE);
            right.setText(rightText);
        }

        if (bottomLineVisible) {
            bottomLine.setVisibility(VISIBLE);
        } else {
            bottomLine.setVisibility(GONE);
        }

        title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.click();
                }
            }
        });

        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenerRight != null) {
                    listenerRight.click();
                }
            }
        });

        ivRightIcon = (ImageView) view.findViewById(R.id.iv_right_icon);
        if (ivRight != 0) {
            ivRightIcon.setVisibility(VISIBLE);
            ivRightIcon.setImageResource(ivRight);
        } else {
            ivRightIcon.setVisibility(GONE);
        }
        ivRightIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightIconListener != null) {
                    rightIconListener.click();
                }
            }
        });
    }

    public ImageView getRightImageView() {
        if (ivRightIcon != null) {
            return ivRightIcon;
        } else {
            return (ImageView) view.findViewById(R.id.iv_right_icon);
        }
    }

    public void setBackVisible(boolean visible) {
        if (visible) {
            back.setVisibility(VISIBLE);
        } else {
            back.setVisibility(INVISIBLE);
        }
    }

    public String getRightText() {
        return right.getText().toString().trim();
    }

    public void setRightText(String text) {
        if (!isEmpty(text)) {
            right.setVisibility(VISIBLE);
            right.setText(text);
        } else {
            right.setVisibility(GONE);
        }
    }

    public void setRightTextVisible(boolean visible) {
        if (visible) {
            right.setVisibility(VISIBLE);
        } else {
            right.setVisibility(GONE);
        }
    }

    public void setRightTextColor(@ColorInt int color) {
        right.setTextColor(color);
    }

    public void setTitleText(String text) {
        if (!isEmpty(text)) {
            title.setVisibility(VISIBLE);
            title.setText(text);
            title.setTextColor(titleColor);
        } else {
            title.setVisibility(GONE);
        }
    }

    public void setRightIconClickListener(TitleClickListener rightIconListener) {
        this.rightIconListener = rightIconListener;
    }

    public void setTitleClickListener(TitleClickListener listener) {
        this.listener = listener;
    }

    public void setRightTextClickListener(TitleClickListener listener) {
        this.listenerRight = listener;
    }

    private boolean isEmpty(CharSequence s) {
        return s == null || s.length() == 0;
    }

    public interface TitleClickListener {
        void click();
    }
}
