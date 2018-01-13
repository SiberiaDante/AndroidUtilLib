package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.siberiadante.androidutil.constant.SDMemoryUnit;
import com.siberiadante.androidutil.util.SDTransitionUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

/**
 * @Created： SiberiaDante
 * @Date： 2018/01/01
 * @Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDTransitionUtilActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView textView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdtransition_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_transition_util);
        final StringBuilder builder = new StringBuilder();
        builder.append("获取屏幕密度：" + SDTransitionUtil.getDensity(this) + "\n");
        builder.append("10dip转px：" + SDTransitionUtil.dip2px(10) + "\n");
        builder.append("10dip转px：" + SDTransitionUtil.dip2pxF(10) + "\n");
        builder.append("10px转dip：" + SDTransitionUtil.px2dip(10) + "\n");
        builder.append("10px转dip：" + SDTransitionUtil.px2dipF(10) + "\n");
        builder.append("10sp转px：" + SDTransitionUtil.sp2px(10) + "\n");
        builder.append("10sp转px：" + SDTransitionUtil.sp2pxF(10) + "\n");
        builder.append("10px转sp：" + SDTransitionUtil.px2sp(10) + "\n");
        builder.append("10px转sp：" + SDTransitionUtil.px2spF(10) + "\n");
        builder.append("10px转sp：" + SDTransitionUtil.px2spF(10) + "\n");
        builder.append("\n");
        builder.append("100000000金额格式化：" + SDTransitionUtil.getMoneyFormat("100000000") + "\n");
        builder.append("12345678.125金额格式化：" + SDTransitionUtil.getMoneyFormat("12345678.125") + "\n");
        builder.append("\n");
        builder.append("12345.125四舍五入保留两位小数：" + SDTransitionUtil.getRoundUp("12345.125", 2) + "\n");
        builder.append("\n");
        builder.append("0.12转成百分比：" + SDTransitionUtil.getPercentValue(0.12) + "\n");
        builder.append("0.12转成百分比：" + SDTransitionUtil.getPercent(0.12) + "\n");
        builder.append("\n");
        builder.append("52字符串转成Int：" + SDTransitionUtil.stringToInt("52") + "\n");
        builder.append("52字符串转成Long：" + SDTransitionUtil.stringToLong("52") + "\n");
        builder.append("52字符串转成Double：" + SDTransitionUtil.stringToDouble("52") + "\n");
        builder.append("52字符串转成Float：" + SDTransitionUtil.stringToFloat("52") + "\n");
        builder.append("52字符串转化为带两位小数的字符串：" + SDTransitionUtil.formatToDecimals("52") + "\n");
        builder.append("521314字符串转换成整型数组：" + SDTransitionUtil.stringToIntArray("521314") + "\n");
        builder.append("\n");
        builder.append("siberiaDante首字母大写：" + SDTransitionUtil.upperFirstLetter("siberiaDante") + "\n");
        builder.append("siberiaDante第三个字母大写：" + SDTransitionUtil.upperLetter("siberiaDante", 2) + "\n");
        builder.append("SiberiaDante首字母小写：" + SDTransitionUtil.lowerFirstLetter("SiberiaDante") + "\n");
        builder.append("SiBeriaDante第三个字母小写：" + SDTransitionUtil.lowerLetter("SiberiaDante", 2) + "\n");
        builder.append("SiberiaDante反转字符串：" + SDTransitionUtil.reverse("SiberiaDante") + "\n");
        builder.append("SiberiaDante转化成半角字符串：" + SDTransitionUtil.toDBC("SiberiaDante") + "\n");
        builder.append("SiberiaDante转化为全角字符串：" + SDTransitionUtil.toSBC("SiberiaDante") + "\n");
        builder.append("拼-单个汉字转拼音：" + SDTransitionUtil.oneCNToPY("拼") + "\n");
        builder.append("拼音-字符串汉字转拼音：" + SDTransitionUtil.cnToPY("拼音") + "\n");
        builder.append("拼-获取单个汉字拼音的首字母：" + SDTransitionUtil.getPYFirstLetter("拼") + "\n");
        builder.append("\n");
        builder.append("A-单个字符转int：" + SDTransitionUtil.hexToDec('A') + "\n");
        builder.append("10000-字节数转以unit(KB)为单位的size：" + SDTransitionUtil.byteToSize(10000, SDMemoryUnit.MemoryUnit.KB) + "\n");
        builder.append("\n");
        textView.setText(builder);

    }
}
