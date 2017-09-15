package com.sample.ui.activity.util;

import android.os.Bundle;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.DateUtil;

public class DateUtilActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_util);
        TextView mTvDateUtil = (TextView) findViewById(R.id.tv_date_util);
        final String timeStamp = DateUtil.getTimeStamp();
        StringBuilder builder = new StringBuilder();
        builder.append("显示当前时间：");
        builder.append("\n");
        builder.append(timeStamp);
        builder.append("\n");

        builder.append(DateUtil.getStrToTime(timeStamp));
        builder.append("\n");
        builder.append(DateUtil.getStrToTimeHm(timeStamp));
        builder.append("\n");
        builder.append(DateUtil.getStrToTimeHms(timeStamp));
        builder.append("\n");
        builder.append(DateUtil.getStrToTimeYMdHm(timeStamp));
        builder.append("\n");
        builder.append(DateUtil.getSDFTimeHmA());
        builder.append("\n");
        builder.append(DateUtil.getSDFTimeHms());
        builder.append("\n");
        builder.append(DateUtil.getSDFTimeYMd());
        builder.append("\n");
        builder.append(DateUtil.getSDFTimeYMdHm());
        builder.append("\n");
        builder.append(DateUtil.getSDFTimeYMdHms());
        builder.append("\n");
        builder.append(DateUtil.getSDFTimeYMDHSM());
        builder.append("\n");
        builder.append(DateUtil.getStrToTime());
        builder.append("\n");
        builder.append(DateUtil.getStrToSDFTime(timeStamp, "yyyy年MM月dd日"));
        builder.append("\n");
        mTvDateUtil.setText(builder);

    }
}
