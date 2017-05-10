package com.siberiadante;

import android.content.Context;

/**
 * Created by SiberiaDante on 2017/5/10.
 * user this lib,you should init it first
 */

public class SiberiaDanteLib {
    private static Context context;

    public SiberiaDanteLib() {
        throw new UnsupportedOperationException("not init SiberiaDanteLib");
    }

    public static void initLib(Context context) {
        SiberiaDanteLib.context = context.getApplicationContext();
    }

    public static Context getContext() {
        if (context != null) {
            return context;
        } else {
            throw new NullPointerException("use this lib,you need init first!");
        }
    }
}
