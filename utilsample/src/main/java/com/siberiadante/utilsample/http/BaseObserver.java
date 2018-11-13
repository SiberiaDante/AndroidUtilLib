package com.siberiadante.utilsample.http;


import android.annotation.SuppressLint;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public abstract class BaseObserver<T> implements Observer<T> {

    @SuppressLint("CheckResult")
    @Override
    public void onError(@NonNull Throwable e) {
        Observable.just(e)
                .subscribeOn(Schedulers.newThread())


                .map(new Function<Throwable, NetException.ResponseThrowable>() {
                    @Override
                    public NetException.ResponseThrowable apply(Throwable throwable) throws Exception {
                        return NetException.throwable(throwable);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NetException.ResponseThrowable>() {
                    @Override
                    public void accept(NetException.ResponseThrowable responseThrowable) throws Exception {
                        onError(responseThrowable);
                    }
                });
//                .map(NetException::throwable)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::onError);
    }

    @Override
    public void onComplete() {

    }

    public abstract void onError(NetException.ResponseThrowable e);
}
