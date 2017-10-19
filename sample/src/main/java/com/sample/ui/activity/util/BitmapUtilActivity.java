package com.sample.ui.activity.util;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDBitmapUtil;
import com.siberiadante.lib.util.SDLogUtil;

public class BitmapUtilActivity extends BaseActivity {

    private ImageView mIvBG;
    private int scaleRatio = 5;
    private int blurRadius = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_util);
        mIvBG = (ImageView) findViewById(R.id.iv_bg);

        String drawable2Base64 = SDBitmapUtil.drawable2Base64(getResources().getDrawable(R.mipmap.ic_launcher));
        SDLogUtil.d("----------" + drawable2Base64 + "-------------");
        testStackBlur();
    }

    private void testStackBlur() {
        final Bitmap mBitmap = SDBitmapUtil.drawable2Bitmap(ContextCompat.getDrawable(this, R.drawable.icon_mine));
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap,
                mBitmap.getWidth() / scaleRatio,
                mBitmap.getHeight() / scaleRatio,
                false);
        final Bitmap stackBlur = SDBitmapUtil.stackBlur(scaledBitmap, 5, true);
        mIvBG.setImageBitmap(stackBlur);


    }
}
