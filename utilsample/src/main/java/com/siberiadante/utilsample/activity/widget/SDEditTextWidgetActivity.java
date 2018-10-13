package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

import com.siberiadante.androidutil.widget.edittext.inputfilter.SDCashierInputFilter;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

public class SDEditTextWidgetActivity extends BaseActivity {

    @BindView(R.id.edt_cash)
    EditText edtCash;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdedit_text_widget;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("EditText相关");
        edtCash.setFilters(new InputFilter[]{new SDCashierInputFilter(100)});
    }
}
