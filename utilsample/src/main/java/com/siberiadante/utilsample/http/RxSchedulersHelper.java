package com.siberiadante.utilsample.http;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulersHelper {
    public static final String TAG = RxSchedulersHelper.class.getSimpleName();

    public static <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(new Predicate<T>() {
                            @Override
                            public boolean test(T t) throws Exception {
                                return true;
                            }
                        });
//                        .filter(t -> {
//                            int code = ((WrapBean) t).getCode();
//                            String info = ((WrapBean) t).getInfo();
//                            if (code == ResultCode.LOGINED_USEER_DELETE) {
//                                AppUtils.toast(info);
//                                sendEventLoginOut();
//                                return false;
//                            }
//                            return true;
//                        });
            }

        };
    }
}
