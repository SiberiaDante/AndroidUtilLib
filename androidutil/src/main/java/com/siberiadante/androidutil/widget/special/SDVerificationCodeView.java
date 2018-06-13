package com.siberiadante.androidutil.widget.special;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.siberiadante.androidutil.R;
import com.siberiadante.androidutil.widget.textview.SDBlackCirclePsdView;

/**
 * CreateTime: 2018/6/13
 * UpDateTime:
 * Describe:验证码/密码方框格式输入控件
 */
public class SDVerificationCodeView extends RelativeLayout {

    private LinearLayout containerEt;

    private EditText edtTransparent;
    private int mEtNumber;
    private int mEtWidth;
    private Drawable mEtDividerDrawable;
    private int mEtTextColor;
    private float mEtTextSize;
    private Drawable mEtBackgroundDrawableFocus;
    private Drawable mEtBackgroundDrawableNormal;
    private Drawable mEtBackgroundDrawableComplete;
    private boolean mEtPwd;
    private float mEtPwdRadius;
    private SDBlackCirclePsdView[] mPwdTextViews;
    private MyTextWatcher myTextWatcher = new MyTextWatcher();
    private InputCompleteListener inputCompleteListener;

    public SDVerificationCodeView(Context context) {
        this(context, null);
    }

    public SDVerificationCodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SDVerificationCodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.layout_verification_code, this);
        containerEt = this.findViewById(R.id.vcv_container);
        edtTransparent = this.findViewById(R.id.edt_transparent);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SDVerificationCodeView, defStyleAttr, 0);
        mEtNumber = typedArray.getInteger(R.styleable.SDVerificationCodeView_sd_vcv_count, 1);
        mEtWidth = typedArray.getDimensionPixelSize(R.styleable.SDVerificationCodeView_sd_vcv_et_width, 42);
        mEtDividerDrawable = typedArray.getDrawable(R.styleable.SDVerificationCodeView_sd_vcv_divider_drawable);
        mEtTextSize = typedArray.getDimensionPixelSize(R.styleable.SDVerificationCodeView_sd_vcv_et_text_color, (int) sp2px(16, context));
        mEtTextColor = typedArray.getColor(R.styleable.SDVerificationCodeView_sd_vcv_et_text_size, Color.BLACK);
        mEtBackgroundDrawableFocus = typedArray.getDrawable(R.styleable.SDVerificationCodeView_sd_vcv_et_bg_focus);
        mEtBackgroundDrawableNormal = typedArray.getDrawable(R.styleable.SDVerificationCodeView_sd_vcv_et_bg_normal);
        mEtBackgroundDrawableComplete = typedArray.getDrawable(R.styleable.SDVerificationCodeView_sd_vcv_bg_complete);
        mEtPwd = typedArray.getBoolean(R.styleable.SDVerificationCodeView_sd_vcv_et_is_pwd, false);
        mEtPwdRadius = typedArray.getDimensionPixelSize(R.styleable.SDVerificationCodeView_sd_vcv_et_pwd_radius, 0);
        typedArray.recycle();

        if (mEtDividerDrawable == null) {
            mEtDividerDrawable = context.getResources().getDrawable(R.drawable.shape_vcv_divider);
        }

        if (mEtBackgroundDrawableFocus == null) {
            mEtBackgroundDrawableFocus = context.getResources().getDrawable(R.drawable.shape_vcv_bg_focus);
        }

        if (mEtBackgroundDrawableNormal == null) {
            mEtBackgroundDrawableNormal = context.getResources().getDrawable(R.drawable.shape_vcv_bg_normal);
        }
        if (mEtBackgroundDrawableComplete == null) {
            mEtBackgroundDrawableComplete = context.getResources().getDrawable(R.drawable.shape_vcv_bg_normal);
        }

        initUI();
    }

    public float sp2px(float spValue, Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spValue, context.getResources().getDisplayMetrics());
    }

    private void initUI() {
        initTextViews(getContext(), mEtNumber, mEtWidth, mEtDividerDrawable, mEtTextSize, mEtTextColor);
        initEtContainer(mPwdTextViews);
        setListener();
    }

    private void initTextViews(Context context, int etNumber, int etWidth, Drawable etDividerDrawable, float etTextSize, int etTextColor) {
        edtTransparent.setCursorVisible(false);
        edtTransparent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(etNumber)}); //maximum input length
        // setting division line width
        if (etDividerDrawable != null) {
            etDividerDrawable.setBounds(0, 0, etDividerDrawable.getMinimumWidth(), etDividerDrawable.getMinimumHeight());
            containerEt.setDividerDrawable(etDividerDrawable);
        }
        mPwdTextViews = new SDBlackCirclePsdView[etNumber];

        for (int i = 0; i < mPwdTextViews.length; i++) {
            SDBlackCirclePsdView textView = new SDBlackCirclePsdView(context);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, etTextSize);
            textView.setTextColor(etTextColor);
            textView.setWidth(etWidth);
            textView.setHeight(etWidth);
            if (i == 0) {
                textView.setBackgroundDrawable(mEtBackgroundDrawableFocus);
            } else {
                textView.setBackgroundDrawable(mEtBackgroundDrawableNormal);
            }
            textView.setGravity(Gravity.CENTER);

            textView.setFocusable(false);

            mPwdTextViews[i] = textView;
        }
    }

    private void initEtContainer(TextView[] mTextViews) {
        for (TextView mTextView : mTextViews) {
            containerEt.addView(mTextView);
        }
    }

    private void setListener() {
        edtTransparent.addTextChangedListener(myTextWatcher);
        // software delete key listener
        edtTransparent.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    onKeyDelete();
                    return true;
                }
                return false;
            }
        });
    }

    private void onKeyDelete() {
        for (int i = mPwdTextViews.length - 1; i >= 0; i--) {
            SDBlackCirclePsdView tv = mPwdTextViews[i];
            if (!tv.getText().toString().trim().equals("")) {
                if (mEtPwd) {
                    tv.clearPwd();
                }
                tv.setText("");
                tv.setBackgroundResource(R.drawable.shape_vcv_bg_normal);
                if (inputCompleteListener != null) {
                    inputCompleteListener.deleteContent();
                }
                tv.setBackgroundDrawable(mEtBackgroundDrawableFocus);
                if (i < mEtNumber - 1) {
                    mPwdTextViews[i + 1].setBackgroundDrawable(mEtBackgroundDrawableNormal);
                }
                break;
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 设置当 高为 warpContent 模式时的默认值 为 50dp
        int mHeightMeasureSpec = heightMeasureSpec;

        int heightMode = MeasureSpec.getMode(mHeightMeasureSpec);
        if (heightMode == MeasureSpec.AT_MOST) {
            mHeightMeasureSpec = MeasureSpec.makeMeasureSpec((int) dp2px(50, getContext()), MeasureSpec.EXACTLY);
        }

        super.onMeasure(widthMeasureSpec, mHeightMeasureSpec);
    }

    public float dp2px(float dpValue, Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpValue, context.getResources().getDisplayMetrics());
    }

    // 给TextView 设置文字
    private void setText(String inputContent) {
        for (int i = 0; i < mPwdTextViews.length; i++) {
            SDBlackCirclePsdView tv = mPwdTextViews[i];
            if (tv.getText().toString().trim().equals("")) {
                if (mEtPwd) {
                    tv.drawPwd(mEtPwdRadius);
                    tv.setTextSize(0);
                }
                tv.setText(inputContent);
                // 添加输入完成的监听
                if (inputCompleteListener != null) {
                    inputCompleteListener.inputComplete();
                }
                tv.setBackgroundDrawable(mEtBackgroundDrawableComplete);
//                tv.setBackgroundDrawable(mEtBackgroundDrawableNormal);
                if (i < mEtNumber - 1) {
                    mPwdTextViews[i + 1].setBackgroundDrawable(mEtBackgroundDrawableFocus);
                }
                break;
            }
        }
    }

    /**
     * 获取输入文本
     *
     * @return string
     */
    public String getInputContent() {
        StringBuffer buffer = new StringBuffer();
        for (TextView tv : mPwdTextViews) {
            buffer.append(tv.getText().toString().trim());
        }
        return buffer.toString();
    }

    /**
     * 删除输入内容
     */
    public void clearInputContent() {
        for (int i = 0; i < mPwdTextViews.length; i++) {
            if (i == 0) {
                mPwdTextViews[i].setBackgroundDrawable(mEtBackgroundDrawableFocus);
            } else {
                mPwdTextViews[i].setBackgroundDrawable(mEtBackgroundDrawableNormal);
            }
            if (mEtPwd) {
                mPwdTextViews[i].clearPwd();
            }
            mPwdTextViews[i].setText("");
        }
    }

    /**
     * 获取输入的位数
     *
     * @return int
     */
    public int getEtNumber() {
        return mEtNumber;
    }

    /**
     * 设置输入框个数
     *
     * @param etNumber
     */
    public void setEtNumber(int etNumber) {
        this.mEtNumber = etNumber;
        edtTransparent.removeTextChangedListener(myTextWatcher);
        containerEt.removeAllViews();
        initUI();
    }

    /**
     * 设置是否是密码模式 默认不是
     *
     * @param isPwdMode
     */
    public void setPwdMode(boolean isPwdMode) {
        this.mEtPwd = isPwdMode;
    }

    /**
     * 获取输入的EditText 用于外界设置键盘弹出
     *
     * @return
     */
    public EditText getEditText() {
        return edtTransparent;
    }

    public void setInputCompleteListener(InputCompleteListener inputCompleteListener) {
        this.inputCompleteListener = inputCompleteListener;
    }

    public interface InputCompleteListener {
        void inputComplete();

        void deleteContent();
    }

    private class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String inputStr = editable.toString();
            if (!TextUtils.isEmpty(inputStr)) {
                setText(inputStr);
                edtTransparent.setText("");
            }
        }
    }


}
