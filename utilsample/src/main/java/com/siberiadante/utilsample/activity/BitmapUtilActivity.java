//package com.siberiadante.utilsample.util;
//
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.support.v4.content.ContextCompat;
//import android.widget.ImageView;
//
//import com.sample.R;
//import com.sample.ui.activity.BaseActivity;
//import com.siberiadante.util.utils.SDBitmapUtil;
//import com.siberiadante.util.utils.SDLogUtil;
//
//public class BitmapUtilActivity extends BaseActivity {
//
//    private ImageView mIvBG;
//    private int scaleRatio = 5;
//    private int blurRadius = 10;
//
//    @Override
//    public int setLayoutId() {
//        return R.layout.activity_bitmap_util;
//    }
//
//    @Override
//    public void initView(Bundle savedInstanceState) {
//        mIvBG = (ImageView) findViewById(R.id.iv_bg);
//        String drawable2Base64 = SDBitmapUtil.drawable2Base64(getResources().getDrawable(R.mipmap.ic_launcher));
//        SDLogUtil.d("----------" + drawable2Base64 + "-------------");
//        testStackBlur();
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//    private void testStackBlur() {
//        final Bitmap mBitmap = SDBitmapUtil.drawable2Bitmap(ContextCompat.getDrawable(this, R.drawable.icon_mine));
//        Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap,
//                mBitmap.getWidth() / scaleRatio,
//                mBitmap.getHeight() / scaleRatio,
//                false);
//        final Bitmap stackBlur = SDBitmapUtil.stackBlur(scaledBitmap, 5, true);
//        mIvBG.setImageBitmap(stackBlur);
//    }
//}
