package com.siberiadante.custom.ui.adapter.base;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/29
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface MultiTypeSupport<T> {
    //根据当前位置或者条目返回数据
    public int getLayoutId(T item, int position);

}
