package com.siberiadante;

import com.siberiadante.util.Toast;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.init(getApplicationContext());

    }
}
