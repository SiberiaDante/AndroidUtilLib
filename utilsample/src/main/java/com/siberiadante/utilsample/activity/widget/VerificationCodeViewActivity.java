package com.siberiadante.utilsample.activity.widget;

import android.os.Bundle;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.androidutil.widget.special.SDVerificationCodeView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerificationCodeViewActivity extends BaseActivity {

    public static final String TAG = VerificationCodeViewActivity.class.getSimpleName();
    @BindView(R.id.ver_code_view_base)
    SDVerificationCodeView verCodeViewBase;
    @BindView(R.id.tv_tips)
    TextView tvTips;
    @BindView(R.id.ver_code_view_base_1)
    SDVerificationCodeView verCodeViewBase1;
    @BindView(R.id.vcv_code_psd)
    SDVerificationCodeView vcvCodePsd;

    @Override
    public int setLayoutId() {
        return R.layout.activity_verification_code_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        verCodeViewBase.setInputCompleteListener(new SDVerificationCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                SDLogUtil.e(TAG, "---------1输入内容----------:" + verCodeViewBase.getInputContent());
            }

            @Override
            public void deleteContent() {

            }
        });
        verCodeViewBase1.setInputCompleteListener(new SDVerificationCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                SDLogUtil.e(TAG, "---------2输入内容----------:" + verCodeViewBase1.getInputContent());

            }

            @Override
            public void deleteContent() {

            }
        });

        vcvCodePsd.setInputCompleteListener(new SDVerificationCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                SDLogUtil.e(TAG, "---------3输入内容----------:" + vcvCodePsd.getInputContent());
            }

            @Override
            public void deleteContent() {

            }
        });
    }

}
