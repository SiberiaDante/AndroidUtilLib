package com.siberiadante.exception;

import com.siberiadante.R;
import com.siberiadante.SiberiaDanteLib;

/**
 * Created by SiberiaDante on 2017/5/10.
 */

public class SiberiaDanteLibException {
    public SiberiaDanteLibException() {
        throw new UnsupportedOperationException(SiberiaDanteLib.getContext().getResources().getString(R.string.not_init_this_lib));
    }

    public SiberiaDanteLibException(String content) {

    }
}
