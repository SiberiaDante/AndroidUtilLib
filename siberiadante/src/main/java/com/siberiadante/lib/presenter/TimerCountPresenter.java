package com.siberiadante.lib.presenter;


import com.siberiadante.lib.presenter.impl.ITimerCountPresenter;
import com.siberiadante.lib.view.impl.ITimerCountView;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/9/30
 * @UpDateTime:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class TimerCountPresenter implements ITimerCountPresenter {
    private ITimerCountView iTimerCountView;

    public TimerCountPresenter(ITimerCountView iTimerCountView) {
        this.iTimerCountView = iTimerCountView;
    }

    @Override
    public void onTimerCount(long time) {
        iTimerCountView.timerCount(time);

    }

    @Override
    public void onFinish() {
        iTimerCountView.finish();

    }
}
