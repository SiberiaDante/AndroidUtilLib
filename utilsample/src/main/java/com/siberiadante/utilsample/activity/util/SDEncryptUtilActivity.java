package com.siberiadante.utilsample.activity.util;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.siberiadante.androidutil.util.encrypt.SDBase64Util;
import com.siberiadante.androidutil.util.encrypt.SDDESUtil;
import com.siberiadante.androidutil.util.encrypt.SDMD2Util;
import com.siberiadante.androidutil.util.encrypt.SDMD5Util;
import com.siberiadante.androidutil.util.encrypt.SDSHA1Util;
import com.siberiadante.androidutil.util.encrypt.SDSHA224Util;
import com.siberiadante.androidutil.util.encrypt.SDSHA256Util;
import com.siberiadante.androidutil.util.encrypt.SDSHA384Util;
import com.siberiadante.androidutil.util.encrypt.SDSHA512Util;
import com.siberiadante.androidutil.widget.edittext.SDLineEditText;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDEncryptUtilActivity extends BaseActivity {

    @BindView(R.id.edt_input)
    SDLineEditText edtInput;
    @BindView(R.id.btn_encrypt)
    Button btnEncrypt;
    @BindView(R.id.md2_encrypt)
    TextView md2Encrypt;
    @BindView(R.id.md5_encrypt)
    TextView md5Encrypt;
    @BindView(R.id.base64_encrypt)
    TextView base64Encrypt;
    @BindView(R.id.base64_decode)
    TextView base64Decode;
    @BindView(R.id.des_encrypt)
    TextView desEncrypt;
    @BindView(R.id.des_decode)
    TextView desDecode;
    @BindView(R.id.des3_encrypt)
    TextView des3Encrypt;
    @BindView(R.id.sha1_encrypt)
    TextView sha1Encrypt;
    @BindView(R.id.sha1_encrypt1)
    TextView sha1Encrypt1;
    @BindView(R.id.sha224_encrypt)
    TextView sha224Encrypt;
    @BindView(R.id.sha256_encrypt)
    TextView sha256Encrypt;
    @BindView(R.id.sha384_encrypt)
    TextView sha384Encrypt;
    @BindView(R.id.sha512_encrypt)
    TextView sha512Encrypt;
    @BindView(R.id.aes_encrypt)
    TextView aesEncrypt;
    @BindView(R.id.sha224_encrypt1)
    TextView sha224Encrypt1;
    @BindView(R.id.sha256_encrypt1)
    TextView sha256Encrypt1;
    @BindView(R.id.sha384_encrypt1)
    TextView sha384Encrypt1;
    @BindView(R.id.sha512_encrypt1)
    TextView sha512Encrypt1;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdencrypt_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
//        edtInput.setText("SiberiaDante");
        edtInput.setText("viivbooksillymuddleheaded15331069231.0.0");

    }

    @OnClick(R.id.btn_encrypt)
    public void onViewClicked() {
        String content = edtInput.getText().toString();
        md2Encrypt.setText("MD2加密结果：\n" + SDMD2Util.hashEncrypt32(content));
        md5Encrypt.setText("MD5加密结果：\n" + SDMD5Util.hashEncode32(content));
        base64Encrypt.setText("Base64加密结果：\n" + SDBase64Util.encode(content));
        base64Decode.setText("Base64解密结果：\n" + SDBase64Util.decode(SDBase64Util.encode(content)));
        desEncrypt.setText("DES加密结果：\n" + SDDESUtil.encrypt(content, "123456789"));
        desDecode.setText("DES解密结果：\n" + SDDESUtil.decrypt(SDDESUtil.encrypt(content, "123456789"), "123456789"));//bug
        des3Encrypt.setText("DES加密结果：\n");

        sha1Encrypt.setText("SHA1加密结果(无秘钥)：\n" + SDSHA1Util.encrypt(content));
        sha1Encrypt1.setText("SHA1加密结果(有秘钥)：\n" + SDSHA1Util.encrypt(content, "123456789"));

        sha224Encrypt.setText("SHA224加密结果(无秘钥)：\n" + SDSHA224Util.encrypt(content));//bug
        sha224Encrypt1.setText("SHA224加密结果(有秘钥)：\n" + SDSHA224Util.encrypt(content, "123456789"));//bug

        sha256Encrypt.setText("SHA256加密结果(无秘钥)：\n" + SDSHA256Util.encrypt(content));
        sha256Encrypt1.setText("SHA256加密结果(有秘钥)：\n" + SDSHA256Util.encrypt(content, "123456789"));

        sha384Encrypt.setText("SHA384加密结果(无秘钥)：\n" + SDSHA384Util.encrypt(content));
        sha384Encrypt1.setText("SHA384加密结果(有秘钥)：\n" + SDSHA384Util.encrypt(content, "123456789"));//bug

        sha512Encrypt.setText("SHA512加密结果(无秘钥)：\n" + SDSHA512Util.encrypt(content));
        sha512Encrypt1.setText("SHA512加密结果(有秘钥)：\n" + SDSHA512Util.encrypt(content, "123456789"));
    }
}
