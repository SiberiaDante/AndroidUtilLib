//package com.siberiadante.utilsample.util;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.sample.R;
//import com.sample.ui.activity.BaseActivity;
//import com.siberiadante.util.utils.SDLogUtil;
//import com.siberiadante.util.utils.encrypt.SDBase64Util;
//import com.siberiadante.util.utils.encrypt.SDDESUtil;
//import com.siberiadante.util.utils.encrypt.SDMD5Util;
//import com.siberiadante.util.utils.encrypt.SDSHA1Util;
//import com.siberiadante.util.utils.encrypt.SDSHA224Util;
//import com.siberiadante.util.utils.encrypt.SDSHA256Util;
//import com.siberiadante.util.utils.encrypt.SDSHA384Util;
//import com.siberiadante.util.utils.encrypt.SDSHA512Util;
//import com.siberiadante.util.utils.encrypt.base.SDBaseEncrypt;
//import com.siberiadante.util.view.titlebar.SDTitleLayout;
//
//import butterknife.BindView;
//import butterknife.OnClick;
//
//public class EncryptionActivity extends BaseActivity {
//
//    private static final String TAG = EncryptionActivity.class.getSimpleName();
//    @BindView(R.id.edt_str)
//    EditText edtStr;
//    @BindView(R.id.tv_result)
//    TextView tvResult;
//    @BindView(R.id.btn_encrypt)
//    Button btnEncrypt;
//    @BindView(R.id.btn_clear)
//    Button btnClear;
//    @BindView(R.id.title_layout)
//    SDTitleLayout titleBar;
//    @BindView(R.id.btn_base64)
//    Button btnBase64;
//    @BindView(R.id.btn_sha)
//    Button btnSha224;
//    @BindView(R.id.btn_rsa)
//    Button btnRsa;
//    @BindView(R.id.btn_aes)
//    Button btnAes;
//    @BindView(R.id.btn_des)
//    Button btnDes;
//    @BindView(R.id.btn_or)
//    Button btnOr;
//
//    private StringBuilder stringBuilder;
//    private String key = "1";
//
//    @Override
//    public int setLayoutId() {
//        return R.layout.activity_encryption;
//    }
//
//    @Override
//    public void initView(Bundle savedInstanceState) {
//        titleBar.setTitle(getString(R.string.SDEncryptUtil));
//        stringBuilder = new StringBuilder();
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//
//    @OnClick({R.id.btn_encrypt, R.id.btn_clear, R.id.btn_base64, R.id.btn_sha, R.id.btn_rsa, R.id.btn_aes, R.id.btn_des, R.id.btn_or})
//    public void onViewClicked(View view) {
//        SDLogUtil.printTimeLogD(TAG, "--------输入的加密内容-------" + edtStr.getText().toString());
//        switch (view.getId()) {
//            case R.id.btn_encrypt:
//                encryptMD5();
//                break;
//            case R.id.btn_base64:
//                encryptBase();
//                break;
//            case R.id.btn_sha:
//                encryptSHA();
//                break;
//            case R.id.btn_rsa:
//                break;
//            case R.id.btn_aes:
//                encryptAES();
//                break;
//            case R.id.btn_des:
//                encryptDES();
//                break;
//            case R.id.btn_or:
//                break;
//            case R.id.btn_clear:
//                clearContent();
//                break;
//        }
//    }
//
//    private void encryptAES() {
//    }
//
//    private void encryptDES() {
//        final String string = edtStr.getText().toString();
//        if (string.isEmpty()) {
//            return;
//        }
//        stringBuilder.append("DES加密转成十六进制：\n");
//        String generateKey = SDBaseEncrypt.generateKey();
//        String encode = SDDESUtil.encrypt(string, generateKey);
//        stringBuilder.append(encode);
//        stringBuilder.append("\n");
//        stringBuilder.append("DES解密上一个加密结果-Base64：\n");
//        stringBuilder.append(SDDESUtil.decrypt(encode, generateKey));
//        stringBuilder.append("\n");
//        stringBuilder.append("DES解密上一个加密结果：\n");
//        stringBuilder.append(SDBase64Util.decode(SDDESUtil.decrypt(encode, generateKey)));
//        tvResult.setText(stringBuilder);
//        stringBuilder.delete(0, stringBuilder.length());
//    }
//
//    private void encryptSHA() {
//        final String string = edtStr.getText().toString();
//        if (string.isEmpty()) {
//            return;
//        }
//        stringBuilder.append("SHA-1 Hash加密：\n");
//        stringBuilder.append(SDSHA1Util.encrypt(string));
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-1 Hmac加密：\n");
//        stringBuilder.append(SDSHA1Util.encrypt(string, key));
//
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-224 Hash加密：\n");
//        stringBuilder.append(SDSHA224Util.encrypt(string));
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-224 Hmac加密：(与加密工具加密结果不同，待测试)\n");
//        stringBuilder.append(SDSHA224Util.encrypt(string, key));
//
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-256 Hash加密：\n");
//        stringBuilder.append(SDSHA256Util.encrypt(string));
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-256 Hmac加密：\n");
//        stringBuilder.append(SDSHA256Util.encrypt(string, key));
//
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-384 Hash加密：\n");
//        stringBuilder.append(SDSHA384Util.encrypt(string));
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-384 Hmac加密：(与加密工具加密结果不同，待测试)\n");
//        stringBuilder.append(SDSHA384Util.encrypt(string, key));
//
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-512 Hash加密：\n");
//        stringBuilder.append(SDSHA512Util.encrypt(string));
//        stringBuilder.append("\n");
//        stringBuilder.append("SHA-512 Hmac加密：\n");
//        stringBuilder.append(SDSHA512Util.encrypt(string, key));
//        tvResult.setText(stringBuilder);
//        stringBuilder.delete(0, stringBuilder.length());
//    }
//
//    private void encryptBase() {
//        final String encode = SDBase64Util.encode(edtStr.getText().toString());
//        stringBuilder.append("Base64加密结果：\n");
//        stringBuilder.append(encode);
//        stringBuilder.append("\n");
//        stringBuilder.append("Base64加密结果进行解密：\n");
//        stringBuilder.append(SDBase64Util.decode(encode));
//        tvResult.setText(stringBuilder);
//        stringBuilder.delete(0, stringBuilder.length());
//
//
//    }
//
//    private void encryptMD5() {
//        final String string = edtStr.getText().toString();
//        if (string.isEmpty()) {
//            return;
//        }
//        Log.d(TAG, "setResult: " + string);
//        stringBuilder.append("加密字符串32位大写结果——Hash：\n");
//        stringBuilder.append(SDMD5Util.hashEncode32(string));
//        stringBuilder.append("\n");
//        stringBuilder.append("加密字符串16位大写结果——Hash：\n");
//        stringBuilder.append(SDMD5Util.hashEncode16(string));
//        stringBuilder.append("\n");
//        stringBuilder.append("加密字符串32位小写结果——Hash：\n");
//        stringBuilder.append(SDMD5Util.hashEncode32(string).toLowerCase());
//        stringBuilder.append("\n");
//        stringBuilder.append("加密字符串带盐32位大写结果——Hash：\n");
//        stringBuilder.append(SDMD5Util.hashEncode32(string, "1"));
//        stringBuilder.append("\n");
//        stringBuilder.append("加密字符串不带盐32位大写结果——Hmac：\n");
//        stringBuilder.append(SDMD5Util.hmacEncode32(string, key));
//        tvResult.setText(stringBuilder);
//        stringBuilder.delete(0, stringBuilder.length());
//    }
//
//    private void clearContent() {
//        edtStr.setText("");
//        tvResult.setText("");
//    }
//}
