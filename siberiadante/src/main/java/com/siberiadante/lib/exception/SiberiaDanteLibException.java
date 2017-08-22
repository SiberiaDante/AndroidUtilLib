package com.siberiadante.lib.exception;

import com.siberiadante.R;
import com.siberiadante.lib.SiberiaDanteLib;

/**
 * Created by SiberiaDante
 * Describe: 异常捕获
 * Time: 2017/5/10.
 * Email: 994537867@qq.com
 * GitHub: https://github.com/SiberiaDante
 * 博客园： http://www.cnblogs.com/shen-hua/
 */

public class SiberiaDanteLibException {
    public SiberiaDanteLibException() {
        throw new UnsupportedOperationException(SiberiaDanteLib.getContext().getResources().getString(R.string.not_init_this_lib));
    }

    public SiberiaDanteLibException(String content) {
        throw new UnsupportedOperationException(content + "---" + SiberiaDanteLib.getContext().getResources().getString(R.string.not_init_this_lib));

    }
}
