package com.siberiadante.androidutil.util;

import com.siberiadante.androidutil.R;
import com.siberiadante.androidutil.SDAndroidLib;

/**
 * @Created SiberiaDante
 * @Describe： 格式化相关处理工具类
 * @CreateTime: 2018/1/6
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */

public class SDFormatUtil {
    /**
     * 隐藏手机中间4位号码
     *
     * @param mobile_phone 手机号码
     * @return 130****0000
     */
    public static String hideMobilePhone4(String mobile_phone) {
        if (!SDRegexUtil.isMobileExact(mobile_phone)) {
            return SDAndroidLib.getContext().getString(R.string.mobile_number_error);
        }
        return mobile_phone.substring(0, 3) + "****" + mobile_phone.substring(7, 11);
    }

    /**
     * 格式化银行卡
     *
     * @param cardId 银行卡
     * @return 6227 **** **** 9507
     */
    public static String formatCard(String cardId) {
        if (!SDRegexUtil.isBankCard(cardId)) {
            return SDAndroidLib.getContext().getString(R.string.blank_card_error);
        }
        String card = "";
        card = cardId.substring(0, 4) + " **** **** ";
        card += cardId.substring(cardId.length() - 4);
        return card;
    }

    /**
     * 银行卡后四位
     *
     * @param cardId
     * @return **** **** **** 9507
     */
    public static String formatCardEnd4(String cardId) {
        if (!SDRegexUtil.isBankCard(cardId)) {
            return SDAndroidLib.getContext().getString(R.string.blank_card_error);
        }
        String card = "**** **** **** ";
        card += cardId.substring(cardId.length() - 4);
        return card;
    }

}
