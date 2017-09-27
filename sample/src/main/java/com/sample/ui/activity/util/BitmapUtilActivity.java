package com.sample.ui.activity.util;

import android.os.Bundle;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDBitmapUtil;
import com.siberiadante.lib.util.SDLogUtil;

public class BitmapUtilActivity extends BaseActivity {

    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_util);
        mTvContent = (TextView) findViewById(R.id.tv_bitmap_util_content);

        final StringBuilder builder = new StringBuilder();
        final String drawable2Base64 = SDBitmapUtil.drawable2Base64(getResources().getDrawable(R.mipmap.ic_launcher));
        builder.append("Bitmap转base64:" + drawable2Base64);
        mTvContent.setText(builder);

        SDLogUtil.d("----------" + drawable2Base64 + "-------------");
    }
}
