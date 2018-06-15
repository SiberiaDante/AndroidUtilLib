package com.siberiadante.utilsample.activity.util;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.siberiadante.androidutil.util.SDBitmapUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDBitmapUtilActivity extends BaseActivity {

    @BindView(R.id.ll_view_to_bitmap)
    LinearLayout llViewToBitmap;
    @BindView(R.id.btn_view_to_bitmap)
    Button btnViewToBitmap;
    @BindView(R.id.iv_view_to_bitmap)
    ImageView ivViewToBitmap;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdbitmap_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.ll_view_to_bitmap, R.id.btn_view_to_bitmap})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_view_to_bitmap:
                break;
            case R.id.btn_view_to_bitmap:
                getViewToBitmap();
                break;
        }
    }

    private void getViewToBitmap() {
        Bitmap bitmap = SDBitmapUtil.viewToBitmap(llViewToBitmap);
        ivViewToBitmap.setImageBitmap(bitmap);
    }
}
