package com.siberiadante.utilsample.activity.util;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDDateUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

/**
 * Created:： SiberiaDante
 *
 * @Date： 2018/01/01
 * Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDDateUtilActivity extends BaseActivity {

    public static final int SHOW_TIME = 0x01;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_time)
    TextView tvTime;
    /**
     * 内存泄露
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SHOW_TIME:
                    tvTime.setText(SDDateUtil.getSDFTimeYMdHms());
                    mHandler.sendEmptyMessageDelayed(SHOW_TIME, 1000);
                    break;
            }
        }
    };

    @Override
    public int setLayoutId() {
        return R.layout.activity_sddate_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_date_util);
        final StringBuilder builder = new StringBuilder();
        builder.append("获取当前时间戳(秒)：").append(SDDateUtil.getTimeStamp()).append("\n")
                .append("获取当前时间戳(毫秒)：").append(System.currentTimeMillis()).append("\n")
                .append("获取指定格式下的时间：").append("\n")
                .append("获取年份：").append(SDDateUtil.getYear()).append("年").append("\n")
                .append("获取月份：").append(SDDateUtil.getMonth()).append("月").append("\n")
                .append("获取日：").append(SDDateUtil.getDay()).append("日").append("\n")
                .append("获取小时：").append(SDDateUtil.getHour()).append("时").append("\n")
                .append("获取分钟：").append(SDDateUtil.getMinute()).append("分").append("\n")
                .append("获取秒：").append(SDDateUtil.getSecond()).append("秒").append("\n")
                .append(SDDateUtil.getSDFTimeHm()).append("\n")
                .append(SDDateUtil.getSDFTimeHmA()).append("\n")
                .append(SDDateUtil.getSDFTimeHms()).append("\n")
                .append(SDDateUtil.getSDFTimeYMd()).append("\n")
                .append(SDDateUtil.getSDFTimeYMdHm()).append("\n")
                .append(SDDateUtil.getSDFTimeYMdHms()).append("\n")
                .append(SDDateUtil.getSDFTimeCST()).append("\n")
                .append(SDDateUtil.getStrToTime()).append("\n")
                .append("自己输入格式类型:").append(SDDateUtil.getSDFTime("yyyy-MM-dd HH:mm:ss")).append("\n").append("\n")
                .append("自己输入时间戳(秒)和格式类型:").append(SDDateUtil.getSDFDateFromTimeStamp("1528692426", "yyyy-MM-dd HH:mm:ss")).append("\n").append("\n")
                .append("自己输入时间戳(毫秒)和格式类型:").append(SDDateUtil.getSDFDateFromMillisTimeStamp("1528692426000", "yyyy-MM-dd HH:mm:ss")).append("\n").append("\n")
                .append("根据时间格式和时间转成时间戳:").append(SDDateUtil.getTimeStampFromFormat("2017-12-29 10:58:00", "yyyy-MM-dd HH:mm:ss")).append("\n")
                .append("获取某一个月有多少天：（2018 年 的 3 月有 ").append(SDDateUtil.getMonthOfDay(2018, 3)).append("天\n")
                .append("今年是否是闰年：" + SDDateUtil.isLeapYear(System.currentTimeMillis()) + "\n")
                .append("2012年是否是闰年：" + SDDateUtil.isLeapYear(2012) + "\n")
                .append("今天是星期几：" + SDDateUtil.getWeek(System.currentTimeMillis()) + "\n")
                .append("2018-06-22是星期几：" + SDDateUtil.getWeek("2018-06-22", "yyyy-MM-dd") + "\n")
                .append("今天是本月的第几周：" + SDDateUtil.getWeekOfMonth(System.currentTimeMillis()) + "\n")
                .append("今天出生的你是属：" + SDDateUtil.getChineseZodiac(System.currentTimeMillis()) + "\n")
                .append("1992年8月20日出生的是属：" + SDDateUtil.getChineseZodiac("1992-08-20", "yyyy-MM-dd") + "\n")
                .append("根据生日(8月20日)获取星座:").append(SDDateUtil.getConstellation(8, 20)).append("\n").append("\n").append("\n")
                .append("更多支持请看源码^_^")
        ;
        tvDate.setText(builder);
        new TimeThread().start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    class TimeThread extends Thread {
        @Override
        public void run() {
            mHandler.sendEmptyMessageDelayed(SHOW_TIME, 1000);
        }
    }
}
