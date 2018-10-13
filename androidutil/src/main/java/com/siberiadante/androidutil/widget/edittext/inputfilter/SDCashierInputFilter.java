package com.siberiadante.androidutil.widget.edittext.inputfilter;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

import com.siberiadante.androidutil.constant.SDRegexUnit;
import com.siberiadante.androidutil.util.SDLogUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create date: 2018/10/12
 */
public class SDCashierInputFilter implements InputFilter {
    public static final String TAG = SDCashierInputFilter.class.getSimpleName();
    private Pattern mPattern;
    //输入的最大金额
    private int maxValue = Integer.MAX_VALUE;
    //小数点后的位数
    private static final int POINTER_LENGTH = 2;
    private static final String POINTER = ".";
    private static final String ZERO = "0";

    public SDCashierInputFilter() {
        mPattern = Pattern.compile(SDRegexUnit.REGEX_NUM_POINT);
    }

    public SDCashierInputFilter(int maxValue) {
        mPattern = Pattern.compile(SDRegexUnit.REGEX_NUM_POINT);
        this.maxValue = maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @param source 新输入的字符串
     * @param start  新输入的字符串起始下标，一般为0
     * @param end    新输入的字符串终点下标，一般为source长度-1
     * @param dest   输入之前文本框内容
     * @param dstart 原内容起始坐标，一般为0
     * @param dend   原内容终点坐标，一般为dest长度-1
     * @return 输入内容
     */
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String sourceText = source.toString();
        String destText = dest.toString();
        //验证删除等按键
        if (TextUtils.isEmpty(sourceText)) {
            return "";
        }
        Matcher matcher = mPattern.matcher(source);

        //未输入任何内容切第一个输入的内容为0，不做任何处理
        if (ZERO.equals(sourceText) && TextUtils.isEmpty(destText)) {
            SDLogUtil.d(TAG, "----------第一位为0----------");
        } else if (ZERO.equals(destText)) {
            //原来的内容为0，后面的第一位输入只能是点，
            if (!POINTER.equals(sourceText)) {
                return "";
            }
        } else
            //已经输入小数点的情况下，只能输入数字
            if (destText.contains(POINTER)) {
                if (!matcher.matches()) {
                    return "";
                } else {
                    if (POINTER.equals(sourceText)) { //只能输入一个小数点
                        return "";
                    }
                }
                //验证小数点精度，保证小数点后只能输入两位
                int index = destText.indexOf(POINTER);
                int length = dend - index;
                if (length > POINTER_LENGTH) {
                    return dest.subSequence(dstart, dend);
                }
            } else {

                //没有输入小数点的情况下，只能输入小数点和数字，但首位不能输入小数点和0
                if (!matcher.matches()) {
                    return "";
                } else {
                    if ((POINTER.equals(sourceText) || ZERO.equals(sourceText)) && TextUtils.isEmpty(destText)) {
                        return "";
                    }
                }
            }
        //验证输入金额的大小
        double sumText = Double.parseDouble(destText + sourceText);
        if (sumText > maxValue) {
            return dest.subSequence(dstart, dend);
        }
        return dest.subSequence(dstart, dend) + sourceText;
    }
}