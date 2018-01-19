package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDStringUtil;
import com.siberiadante.androidutil.SDToastUtil;
import com.siberiadante.androidutil.util.SDRegexUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;
import com.siberiadante.utilsample.constant.SDAppInfo;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Created： SiberiaDante
 * @Date： 2018/01/01
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDSPUtilActivity extends BaseActivity {

    @BindView(R.id.edt_input)
    EditText edtInput;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.btn_read)
    Button btnRead;
    @BindView(R.id.tv_result)
    TextView tvResult;
    public static final int TYPE1 = 0x01;
    public static final int TYPE2 = 0x02;
    public static final int TYPE3 = 0x03;
    private int type;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdsputil;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_sp_util);
    }

    @OnClick({R.id.btn_save, R.id.btn_read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                final String inputContent = edtInput.getText().toString();
                if (SDStringUtil.isEmpty(inputContent)) {
                    SDToastUtil.toast("请输入内容");
                    return;
                }
                if (SDRegexUtil.isNum(inputContent)) {
                    SDAppInfo.getInstance().setNumber(Integer.valueOf(inputContent));
                    type = TYPE1;
                } else if (inputContent.equals("true") || inputContent.equals("false")) {
                    SDAppInfo.getInstance().setBoolean(Boolean.valueOf(inputContent));
                    type = TYPE2;
                } else {
                    SDAppInfo.getInstance().setText(inputContent);
                }
                type = TYPE3;
                SDToastUtil.toast("保存成功");
                break;
            case R.id.btn_read:
                final StringBuilder builder = new StringBuilder();
                if (type == TYPE1) {
                    builder.append("你保存的数据是数字：");
                    builder.append(SDAppInfo.getInstance().getNumber());
                }
                if (type == TYPE2) {
                    builder.append("你保存的数据是布尔值：");
                    builder.append(SDAppInfo.getInstance().getBoolean());
                }
                if (type == TYPE3) {
                    builder.append("你保存的数据是字符：");
                    builder.append(SDAppInfo.getInstance().getText());
                }
                tvResult.setText(builder);
                builder.delete(0, builder.length());
                break;
        }
    }
}
