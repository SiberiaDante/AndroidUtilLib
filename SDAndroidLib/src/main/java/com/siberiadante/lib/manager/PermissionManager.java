package com.siberiadante.lib.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe： @{link https://github.com/zhang3550545/PermissionManager}
 * @Time: 2017/9/4
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class PermissionManager {
    private static final int REQUEST_CODE = 0x0001;
    private HashMap<String, Integer> hashmap;

    private static class Holder {
        @SuppressLint("StaticFieldLeak")
        static final PermissionManager MANAGER = new PermissionManager();
    }

    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    private PermissionManager() {
    }

    /**
     * 单例获取对象
     */
    public static PermissionManager getInstance(Context context) {
        sContext = context.getApplicationContext();
        return Holder.MANAGER;
    }

    /**
     * 执行请求多个权限
     */
    public void execute(@NonNull Activity activity, String... permissions) {
        List<String> lists = new ArrayList<>();
        for (String permission : permissions) {
            if (!isGranted(permission) && !isRevoked(permission)) {
                lists.add(permission);
            }
        }
        if (lists.size() == 0) return;
        String[] p = new String[lists.size()];
        requestPermissions(activity, lists.toArray(p));
    }

    /**
     * 执行请求一个权限
     */
    public void execute(@NonNull Activity activity, String permission) {
        if (!isGranted(permission) && !isRevoked(permission)) {
            requestPermissions(activity, permission);
        }
    }

    /**
     * 执行请求一个权限，可以带对话框的提示,使用建造者模式解耦
     */
    public void executeDialog(@NonNull Activity activity, String permission, Builder builder) {
        if (!isGranted(permission) && !isRevoked(permission)) {
            if (shouldShowRequestPermissionRationale(activity, permission, builder)) {
                return;
            }
            requestPermissions(activity, permission);
        }
    }

    /**
     * 判断是不是授权
     */
    private boolean isGranted(@NonNull String permission) {
        return isM() && ContextCompat.checkSelfPermission(sContext, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 判断是不是在包中申明
     */
    @TargetApi(Build.VERSION_CODES.M)
    private boolean isRevoked(@NonNull String permission) {
        return isM() && sContext.getPackageManager().isPermissionRevokedByPolicy(permission, sContext.getPackageName());
    }

    /**
     * 判断是不是M及以上版本
     */
    private boolean isM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * 请求的方法
     */
    private void requestPermissions(@NonNull Activity activity, String... permissions) {
        if (isM()) {
            ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE);
        }
    }

    /**
     * 是不是需要显示权限请求的关系，可以设置对话框。采用内部类Builder的建造者模式，解耦合方式
     * <p>
     * 这个方法可能不适合同时申请多个权限
     */
    public boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, String permission, Builder builder) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            builder.showDialog(permission);
            return true;
        }
        return false;
    }

    /**
     * 在activity中的onRequestPermissionsResult（）中调用，用于传递参数做一些逻辑判断
     */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE && grantResults != null && grantResults.length > 0) {
            if (hashmap == null) {
                hashmap = new HashMap<>();
            } else {
                hashmap.clear();
            }
            for (int i = 0; i < permissions.length; i++) {
                hashmap.put(permissions[i], grantResults[i]);
            }
        }
    }

    /**
     * 请求权限后，通过返回值判断是不是授权
     */
    public boolean getGrantedInfo(String permission) {
        if (!isM()) {
            return true;
        }
        return (hashmap != null && hashmap.get(permission) != null && hashmap.get(permission) == PackageManager.PERMISSION_GRANTED) || isGranted(permission);
    }

    /**
     * 内部类，通过建造者模式传递数据，显示对话框
     */
    public class Builder {
        private String message;
        private String title;
        private int icon;
        private String ok;
        private String cancel;
        private Activity activity;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public String getMessage() {
            return message;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public int getIcon() {
            return icon;
        }

        public Builder setIcon(int icon) {
            this.icon = icon;
            return this;
        }

        public String getOk() {
            return ok;
        }

        public Builder setOk(String ok) {
            this.ok = ok;
            return this;
        }

        public String getCancel() {
            return cancel;
        }

        public Builder setCancel(String cancel) {
            this.cancel = cancel;
            return this;
        }

        public void showDialog(final String p) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(message)
                    .setIcon(icon)
                    .setTitle(title)
                    .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            requestPermissions(activity, p);
                        }
                    }).setNegativeButton(cancel, null)
                    .create().show();
        }
    }

}
