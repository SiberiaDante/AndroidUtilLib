package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDStringUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created:： SiberiaDante
 * @Date： 2018/01/01
 * Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDStringUtilActivity extends BaseActivity {

    @BindView(R.id.edt_input)
    EditText edtInput;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_is_null)
    Button btnIsNull;
    @BindView(R.id.btn_is_space)
    Button btnIsSpace;
    @BindView(R.id.btn_empty_str)
    Button btnEmptyStr;
    @BindView(R.id.btn_is_have)
    Button btnIsHave;
    @BindView(R.id.btn_equals)
    Button btnEquals;
    @BindView(R.id.btn_equals_ignore)
    Button btnEqualsIgnore;
    @BindView(R.id.btn_upper)
    Button btnUpper;
    @BindView(R.id.btn_lower)
    Button btnLower;
    @BindView(R.id.btn_reverse)
    Button btnReverse;
    @BindView(R.id.btn_to_dbc)
    Button btnToDbc;
    @BindView(R.id.btn_to_sbc)
    Button btnToSbc;
    @BindView(R.id.btn_to_en)
    Button btnToEn;
    private String defaultStr = "SiberiaDante";

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdstring_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.btn_is_null, R.id.btn_is_space, R.id.btn_empty_str, R.id.btn_is_have, R.id.btn_equals, R.id.btn_equals_ignore, R.id.btn_upper, R.id.btn_lower, R.id.btn_reverse, R.id.btn_to_dbc, R.id.btn_to_sbc, R.id.btn_to_en})
    public void onViewClicked(View view) {
        String inputContent = edtInput.getText().toString();
        if (SDStringUtil.isEmpty(inputContent)) {
            inputContent = defaultStr;
        }
        String result = "";
        switch (view.getId()) {
            case R.id.btn_is_null:
                result = String.valueOf(SDStringUtil.isEmpty(inputContent));
                break;
            case R.id.btn_is_space:
                result = String.valueOf(SDStringUtil.isTrimEmpty(inputContent));
                break;
            case R.id.btn_empty_str:
                result = String.valueOf(SDStringUtil.isSpace(inputContent));
                break;
            case R.id.btn_is_have:
                result = String.valueOf(SDStringUtil.isHaveString(inputContent, defaultStr));
                break;
            case R.id.btn_equals:
                result = String.valueOf(SDStringUtil.equals(inputContent, defaultStr));
                break;
            case R.id.btn_equals_ignore:
                result = String.valueOf(SDStringUtil.equalsIgnoreCase(inputContent, defaultStr));
                break;
            case R.id.btn_upper:
                result = SDStringUtil.upperFirstLetter(inputContent);
                break;
            case R.id.btn_lower:
                result = SDStringUtil.lowerFirstLetter(inputContent);
                break;
            case R.id.btn_reverse:
                result = SDStringUtil.reverse(inputContent);
                break;
            case R.id.btn_to_dbc:
                result = SDStringUtil.toDBC(inputContent);
                break;
            case R.id.btn_to_sbc:
                result = SDStringUtil.toSBC(inputContent);
                break;
            case R.id.btn_to_en:
                result = SDStringUtil.removeSpecialStr(inputContent);
                break;
        }
        tvResult.setText("默认字符或者第二个字符为SiberiaDante，验证结果：" + result);
    }
}
