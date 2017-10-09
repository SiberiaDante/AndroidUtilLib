package com.siberiadante.lib.model;

import android.os.CountDownTimer;

import com.siberiadante.lib.presenter.impl.ITimerCountPresenter;


/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/9/30
 * @UpDateTime:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class TimerCountModel extends CountDownTimer {
    private ITimerCountPresenter timerCountPresenter;

    public TimerCountModel(long millisInFuture, long countDownInterval, ITimerCountPresenter timerCountPresenter) {
        super(millisInFuture, countDownInterval);
        this.timerCountPresenter = timerCountPresenter;
    }

    @Override
    public void onTick(long l) {//18322717513
        timerCountPresenter.onTimerCount(l);
    }

    @Override
    public void onFinish() {
        timerCountPresenter.onFinish();

    }
}