package com.siberiadante.custom.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.siberiadante.custom.R;
import com.siberiadante.lib.util.SDTransitionUtil;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class GuideSlideImagePointView extends LinearLayout {

	private Context context;
	private int count;

	public GuideSlideImagePointView(Context context) {
		super(context);
		this.context = context;
	}

	public GuideSlideImagePointView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public GuideSlideImagePointView(Context context, AttributeSet attrs,
									int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
	}

	public void setCurrentSelectPoint(int currentIndex) {
		this.removeAllViews();
		this.setGravity(Gravity.CENTER_VERTICAL);
		for (int i = 0; i < this.count; i++) {
			ImageView iv = new ImageView(context);
			LayoutParams layoutParams = null;
			if (currentIndex == i) {
				iv.setImageResource(R.mipmap.guide_icon_true);
				layoutParams = new LayoutParams(
						SDTransitionUtil.dp2px(12), SDTransitionUtil.dp2px(12));
			} else {
				iv.setImageResource(R.mipmap.guide_icon_false);
				layoutParams = new LayoutParams(
						SDTransitionUtil.dp2px(9), SDTransitionUtil.dp2px(9));
			}

			layoutParams.leftMargin = SDTransitionUtil.dp2px(5);
			layoutParams.rightMargin = SDTransitionUtil.dp2px(5);
			iv.setLayoutParams(layoutParams);
			this.addView(iv);
		}
	}

	public void setPointCount(int count) {
		this.count = count;
	}

	public int getPointCount() {
		return this.count;
	}
}
