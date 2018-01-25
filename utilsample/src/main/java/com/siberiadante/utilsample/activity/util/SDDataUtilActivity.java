package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDDataUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

public class SDDataUtilActivity extends BaseActivity {


    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sddata_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        final StringBuilder builder = new StringBuilder();
        int[] ints = new int[]{1, 2, 3, 4, 5};
        builder.append("整型数组[1,2,3,4,5]求和=").append(SDDataUtil.intsGetSum(ints));
        tvContent.setText(builder.toString());
    }


}
