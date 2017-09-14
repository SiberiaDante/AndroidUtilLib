package com.siberiadante.lib.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.siberiadante.lib.SiberiaDanteLib;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by SiberiaDante on 2017/5/4.
 *
 * @Update: 2017-09-12
 * @Describe can use
 */

public class NetWorkUtil {
//    //没有网络连接
//    private static final int NETWORK_NONE = 0;
//    //wifi连接
//    private static final int NETWORK_WIFI = 1;
//    //手机网络数据连接类型
//    private static final int NETWORK_2G = 2;
//    private static final int NETWORK_3G = 3;
//    private static final int NETWORK_4G = 4;
//    private static final int NETWORK_MOBILE = 5;//UN_KNOWN

    private enum NetworkType {
        //没有网络连接
        NETWORK_NONE,
        //wifi连接
        NETWORK_WIFI,
        //手机网络数据连接类型
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G,
        NETWORK_MOBILE
    }

    private static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) SiberiaDanteLib.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private static TelephonyManager getTelephoneManager() {
        return (TelephonyManager) SiberiaDanteLib.getContext().getSystemService(Context.TELEPHONY_SERVICE);
    }

    @SuppressLint("WifiManagerLeak")
    private static WifiManager getWifiManager() {
        return (WifiManager) SiberiaDanteLib.getContext().getSystemService(Context.WIFI_SERVICE);
    }

    /**
     * 获取活动网络信息
     *
     * @return
     */
    private static NetworkInfo getNetworkInfo() {
        return getConnectivityManager().getActiveNetworkInfo();
    }

    /**
     * 判断网络是否连接
     */
    public static boolean isNetWorkConnected() {
        return getNetworkInfo() != null && getNetworkInfo().isConnected();
    }

    /**
     * 判断是否是无线连接
     */
    public static boolean isWifiConnected() {
        return getNetworkInfo() != null && getNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 判断wifi数据是否可用
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isWifiAvailable() {
        return getWifiEnabled() && isAvailableByPing();
    }

    /**
     * 判断是否4G连接
     */
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public static boolean is4GConnected() {
        return getNetworkInfo() != null && getNetworkInfo().getType() == TelephonyManager.NETWORK_TYPE_LTE;
    }

    /**
     * 判断移动数据是否打开
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean getDataEnabled() {
        try {
            Method getMobileDataEnabledMethod = getTelephoneManager().getClass().getDeclaredMethod("getDataEnabled");
            if (null != getMobileDataEnabledMethod) {
                return (boolean) getMobileDataEnabledMethod.invoke(getTelephoneManager());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 打开或关闭移动数据
     * <p>需系统应用 需添加权限{@code <uses-permission android:name="android.permission.MODIFY_PHONE_STATE"/>}</p>
     *
     * @param enabled {@code true}: 打开<br>{@code false}: 关闭
     */
    public static void setDataEnabled(boolean enabled) {
        try {
            Method setMobileDataEnabledMethod = getTelephoneManager().getClass().getDeclaredMethod("setDataEnabled", boolean.class);
            if (null != setMobileDataEnabledMethod) {
                setMobileDataEnabledMethod.invoke(getTelephoneManager(), enabled);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断wifi是否打开
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean getWifiEnabled() {
        return getWifiManager().isWifiEnabled();
    }

    /**
     * 打开或关闭wifi
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>}</p>
     *
     * @param enabled {@code true}: 打开<br>{@code false}: 关闭
     */
    public static void setWifiEnabled(final boolean enabled) {
        if (enabled) {
            if (!getWifiManager().isWifiEnabled()) {
                getWifiManager().setWifiEnabled(true);
            }
        } else {
            if (getWifiManager().isWifiEnabled()) {
                getWifiManager().setWifiEnabled(false);
            }
        }
    }

    /**
     * 判断网络类型
     *
     * @return {@code int}手机网络数据连接类型<br/>
     * <ul>
     * <li>{@link NetWorkUtil.NetworkType#NETWORK_2G}</li>
     * <li>{@link NetWorkUtil.NetworkType#NETWORK_3G}</li>
     * <li>{@link NetWorkUtil.NetworkType#NETWORK_4G}</li>
     * <li>{@link NetWorkUtil.NetworkType#NETWORK_MOBILE}</li>
     * </ul>
     */
    public static NetworkType getNetWorkType() {
        //如果当前没有网络
        if (null == getConnectivityManager()) {
            return NetworkType.NETWORK_NONE;
        }
        //获取当前网络类型，如果为空，返回无网络
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return NetworkType.NETWORK_NONE;
        }
        // 判断是不是连接的是不是wifi
        if (isWifiConnected()) {
            return NetworkType.NETWORK_WIFI;
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
                        return NetworkType.NETWORK_2G;
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
                        return NetworkType.NETWORK_3G;
                    //如果是4g类型
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        return NetworkType.NETWORK_4G;
                    default:
                        //中国移动 联通 电信 三种3G制式
                        if (strSubTypeName.equalsIgnoreCase("TD-SCDMA")
                                || strSubTypeName.equalsIgnoreCase("WCDMA")
                                || strSubTypeName.equalsIgnoreCase("CDMA2000")) {
                            return NetworkType.NETWORK_3G;
                        } else {
                            return NetworkType.NETWORK_MOBILE;
                        }
                }
            }
        return NetworkType.NETWORK_NONE;
    }

    /**
     * 打开网络控制面板
     */
    public static void openNetworkSettings() {
        if (android.os.Build.VERSION.SDK_INT > 10) {
            SiberiaDanteLib.getContext().startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            SiberiaDanteLib.getContext().startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }


    /**
     * 获取网络运营商名称
     * <p>中国移动、如中国联通、中国电信</p>
     *
     * @return 运营商名称
     */
    public static String getNetworkOperatorName() {
        return getTelephoneManager() != null ? getTelephoneManager().getNetworkOperatorName() : null;
    }

    /**
     * 判断网络是否可用
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     * <p>需要异步ping，如果ping不通就说明网络不可用</p>
     * <p>ping的ip为阿里巴巴公共ip：223.5.5.5</p>
     *
     * @return {@code true}: 可用<br>{@code false}: 不可用
     */
    public static boolean isAvailableByPing() {
        return isAvailableByPing(null);
    }

    /**
     * 判断网络是否可用
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     * <p>需要异步ping，如果ping不通就说明网络不可用</p>
     *
     * @param ip ip地址（自己服务器ip），如果为空，ip为阿里巴巴公共ip
     * @return {@code true}: 可用<br>{@code false}: 不可用
     */
    public static boolean isAvailableByPing(String ip) {
        if (ip == null || ip.length() <= 0) {
            ip = "223.5.5.5";// 阿里巴巴公共ip
        }
        ShellUtil.CommandResult result = ShellUtil.execCmd(String.format("ping -c 1 %s", ip), false);
        boolean ret = result.result == 0;
        if (result.errorMsg != null) {
            Log.d("NetworkUtils", "isAvailableByPing() called" + result.errorMsg);
        }
        if (result.successMsg != null) {
            Log.d("NetworkUtils", "isAvailableByPing() called" + result.successMsg);
        }
        return ret;
    }

    /**
     * 获取IP地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @param useIPv4 是否用IPv4
     * @return IP地址
     */
    public static String getIPAddress(final boolean useIPv4) {
        try {
            for (Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces(); nis.hasMoreElements(); ) {
                NetworkInterface ni = nis.nextElement();
                // 防止小米手机返回10.0.2.15
                if (!ni.isUp()) continue;
                for (Enumeration<InetAddress> addresses = ni.getInetAddresses(); addresses.hasMoreElements(); ) {
                    InetAddress inetAddress = addresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        boolean isIPv4 = hostAddress.indexOf(':') < 0;
                        if (useIPv4) {
                            if (isIPv4) return hostAddress;
                        } else {
                            if (!isIPv4) {
                                int index = hostAddress.indexOf('%');
                                return index < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, index).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取域名ip地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @param domain 域名
     * @return ip地址
     */
    public static String getDomainAddress(final String domain) {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(domain);
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
