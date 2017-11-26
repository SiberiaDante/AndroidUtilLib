package com.siberiadante.lib.view.base.nicedialog;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/10
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public abstract class ViewConvertListener implements Parcelable {

    public abstract void convertView(ViewHolder holder, BaseNiceDialog dialog);

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public ViewConvertListener() {
    }

    protected ViewConvertListener(Parcel in) {
    }

    public static final Creator<ViewConvertListener> CREATOR = new Creator<ViewConvertListener>() {
        @Override
        public ViewConvertListener createFromParcel(Parcel source) {
            return new ViewConvertListener(source) {
                @Override
                public void convertView(ViewHolder holder, BaseNiceDialog dialog) {

                }
            };
        }

        @Override
        public ViewConvertListener[] newArray(int size) {
            return new ViewConvertListener[size];
        }
    };
}
