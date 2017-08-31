package com.siberiadante.lib.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;

import com.siberiadante.lib.SiberiaDanteLib;

/**
 * Created by SiberiaDante on 2017/5/4.
 *
 * @Describe can use
 */

public class NetWorkUtil {
    //没有网络连接
    private static final int NETWORK_NONE = 0;
    //wifi连接
    private static final int NETWORK_WIFI = 1;
    //手机网络数据连接类型
    private static final int NETWORK_2G = 2;
    private static final int NETWORK_3G = 3;
    private static final int NETWORK_4G = 4;
    private static final int NETWORK_MOBILE = 5;

    private static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) SiberiaDanteLib.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private static NetworkInfo getNetworkInfo() {
        return getConnectivityManager().getActiveNetworkInfo();
    }

    /**
     * 判断网络是否连接
     */
    public static boolean isNetWorkConnected() {
        return getNetworkInfo() != null && getNetworkInfo().isAvailable();
    }

    /**
     * 判断是否是无线连接
     */
    public static boolean isWifiConnected() {
        return getNetworkInfo() != null && getNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 判断是否4G连接
     */
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public static boolean is4GConnected() {
        return getNetworkInfo() != null && getNetworkInfo().getType() == TelephonyManager.NETWORK_TYPE_LTE;
    }


    /**
     * 判断网络类型
     *
     * @return int型的手机网络数据连接类型
     */
    public static int getNetworkState() {
        //如果当前没有网络
        if (null == getConnectivityManager()) {
            return NETWORK_NONE;
        }
        //获取当前网络类型，如果为空，返回无网络
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return NETWORK_NONE;
        }
        // 判断是不是连接的是不是wifi
        if (isWifiConnected()) {
            return NETWORK_WIFI;
        }

        // 如果不是wifi，则判断当前连接的是运营商的哪种网络2g、3g、4g等
        NetworkInfo.State state = networkInfo.getState();
        String strSubTypeName = networkInfo.getSubtypeName();
        if (null != state)
            if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                switch (networkInfo.getSubtype()) {
                    //如果是2g类型
                    case TelephonyManager.NETWORK_TYPE_GPRS: // 联通2g
                    case TelephonyManager.NETWORK_TYPE_CDMA: // 电信2g
                    case TelephonyManager.NETWORK_TYPE_EDGE: // 移动2g
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        return NETWORK_2G;
                    //如果是3g类型
                    case TelephonyManager.NETWORK_TYPE_EVDO_A: // 电信3g
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        return NETWORK_3G;
                    //如果是4g类型
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        return NETWORK_4G;
                    default:
                        //中国移动 联通 电信 三种3G制式
                        if (strSubTypeName.equalsIgnoreCase("TD-SCDMA") || strSubTypeName.equalsIgnoreCase("WCDMA") || strSubTypeName.equalsIgnoreCase("CDMA2000")) {
                            return NETWORK_3G;
                        } else {
                            return NETWORK_MOBILE;
                        }
                }
            }
        return NETWORK_NONE;
    }

    public static void openNetworkSettings() {
        if (android.os.Build.VERSION.SDK_INT > 10) {
            SiberiaDanteLib.getContext().startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            SiberiaDanteLib.getContext().startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

}
