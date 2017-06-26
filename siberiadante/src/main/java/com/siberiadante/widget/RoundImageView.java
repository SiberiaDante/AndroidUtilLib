package com.siberiadante.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by SiberiaDante on 2017/6/26.
 * 圆形ImageView，运行之后
 */

public class RoundImageView extends ImageView {
    private int mBorderThickness = 2;
    private int mBorderOutsideColor = 0;
    private int mBorderInsideColor = -1;
    private Bitmap currentBitmap;

    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void initCurrentBitmap() {
        Bitmap temp = null;
        Drawable drawable = this.getDrawable();
        if (drawable instanceof BitmapDrawable) {
            temp = ((BitmapDrawable) drawable).getBitmap();
        }

        if (temp != null) {
            this.currentBitmap = temp;
        }

    }

    protected void onDraw(Canvas canvas) {
        this.initCurrentBitmap();
        if (this.currentBitmap != null && this.getWidth() != 0 && this.getHeight() != 0) {
            this.measure(0, 0);
            int width = this.getWidth();
            int height = this.getHeight();
            boolean radius = false;
            int radius1;
            if (this.mBorderInsideColor != 0 && this.mBorderOutsideColor != 0) {
                radius1 = (width < height ? width : height) / 2 - 2 * this.mBorderThickness;
                this.drawCircleBorder(canvas, radius1 + this.mBorderThickness / 2, width, height, this.mBorderInsideColor);
                this.drawCircleBorder(canvas, radius1 + this.mBorderThickness + this.mBorderThickness / 2, width, height, this.mBorderOutsideColor);
            } else if (this.mBorderInsideColor != 0 && this.mBorderOutsideColor == 0) {
                radius1 = (width < height ? width : height) / 2 - this.mBorderThickness;
                this.drawCircleBorder(canvas, radius1 + this.mBorderThickness / 2, width, height, this.mBorderInsideColor);
            } else if (this.mBorderInsideColor == 0 && this.mBorderOutsideColor != 0) {
                radius1 = (width < height ? width : height) / 2 - this.mBorderThickness;
                this.drawCircleBorder(canvas, radius1 + this.mBorderThickness / 2, width, height, this.mBorderOutsideColor);
            } else {
                radius1 = (width < height ? width : height) / 2;
            }

            Bitmap roundBitmap = this.getCroppedRoundBitmap(this.currentBitmap, radius1);
            canvas.drawBitmap(roundBitmap, (float) (width / 2 - radius1), (float) (height / 2 - radius1), (Paint) null);
        }
    }

    public Bitmap getCroppedRoundBitmap(Bitmap bmp, int radius) {
        int diameter = radius * 2;
        int bmpWidth = bmp.getWidth();
        int bmpHeight = bmp.getHeight();
        boolean squareWidth = false;
        boolean squareHeight = false;
        boolean x = false;
        boolean y = false;
        Bitmap squareBitmap;
        if (bmpHeight > bmpWidth) {
            byte x1 = 0;
            int y1 = (bmpHeight - bmpWidth) / 2;
            squareBitmap = Bitmap.createBitmap(bmp, x1, y1, bmpWidth, bmpWidth);
        } else if (bmpHeight < bmpWidth) {
            int x2 = (bmpWidth - bmpHeight) / 2;
            byte y2 = 0;
            squareBitmap = Bitmap.createBitmap(bmp, x2, y2, bmpHeight, bmpHeight);
        } else {
            squareBitmap = bmp;
        }

        Bitmap scaledSrcBmp;
        if (squareBitmap.getWidth() == diameter && squareBitmap.getHeight() == diameter) {
            scaledSrcBmp = squareBitmap;
        } else {
            scaledSrcBmp = Bitmap.createScaledBitmap(squareBitmap, diameter, diameter, true);
        }

        Bitmap output = Bitmap.createBitmap(scaledSrcBmp.getWidth(), scaledSrcBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, scaledSrcBmp.getWidth(), scaledSrcBmp.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle((float) (scaledSrcBmp.getWidth() / 2), (float) (scaledSrcBmp.getHeight() / 2), (float) (scaledSrcBmp.getWidth() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(scaledSrcBmp, rect, rect, paint);
        bmp = null;
        squareBitmap = null;
        scaledSrcBmp = null;
        return output;
    }

    private void drawCircleBorder(Canvas canvas, int radius, int w, int h, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.mBorderThickness);
        canvas.drawCircle((float) (w / 2), (float) (h / 2), (float) radius, paint);
    }

    public void setBitmapRes(Bitmap bitmap) {
        this.currentBitmap = bitmap;
    }

    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.setBitmapRes(bm);
    }

    public void setImageResource(int resId) {
        super.setImageResource(resId);
        this.setBitmapRes(BitmapFactory.decodeResource(this.getResources(), resId));
    }

    public int getBorderThickness() {
        return this.mBorderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.mBorderThickness = borderThickness;
    }

    public int getBorderOutsideColor() {
        return this.mBorderOutsideColor;
    }

    public void setBorderOutsideColor(int borderOutsideColor) {
        this.mBorderOutsideColor = borderOutsideColor;
    }

    public int getBorderInsideColor() {
        return this.mBorderInsideColor;
    }

    public void setBorderInsideColor(int borderInsideColor) {
        this.mBorderInsideColor = borderInsideColor;
    }
}
