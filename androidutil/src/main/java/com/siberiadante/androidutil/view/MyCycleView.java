package com.siberiadante.androidutil.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.siberiadante.androidutil.R;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/19
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */

@SuppressLint("AppCompatCustomView")
public class MyCycleView extends ImageView {

    private Matrix m = new Matrix();
    private LinearInterpolator lir = new LinearInterpolator();

    public MyCycleView(Context context) {
        super(context);
        init();
    }

    public MyCycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        m.reset();
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.icon_default_circle))
                .getBitmap();
        this.setImageBitmap(bitmap); //显示图像
        m.setRotate(10);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
        BitmapDrawable bd = new BitmapDrawable(newBitmap);
        this.setImageDrawable(bd); //显示新的图像
        RotateAnimation rotate = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //默认为0，为-1时一直循环动画
        rotate.setRepeatCount(-1);
        //添加匀速加速器
        rotate.setInterpolator(lir);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        this.startAnimation(rotate);
    }
}
