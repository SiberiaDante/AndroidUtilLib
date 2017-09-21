package com.siberiadante.lib.view.base.nicedialog;

import java.io.Serializable;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/10
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface ViewConvertListener extends Serializable {
    long serialVersionUID = System.currentTimeMillis();

    void convertView(ViewHolder holder, BaseNiceDialog dialog);
}