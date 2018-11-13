package com.siberiadante.utilsample.basemvp;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * create date: 2018/11/13
 */
public abstract class BasePresenter<M extends BaseModel, V extends BaseView> implements Presenter<M, V> {

    private WeakReference<V> weakView;
    public M model;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        this.weakView = new WeakReference<>(view);
    }

    @Override
    public V getView() {
        return weakView == null ? null : weakView.get();
    }

    @Override
    public void destroy() {
        if (weakView != null) {
            weakView.clear();
            weakView = null;
        }
        mCompositeDisposable.clear();
        onViewDestroy();
    }

    protected abstract void onViewDestroy();

    public void addCompositeDisposable(Disposable disposable) {
        if (null != disposable) {
            mCompositeDisposable.add(disposable);
        }
    }

    public void removeCompositeDisposable(Disposable disposable) {
        if (disposable != null) {
            mCompositeDisposable.remove(disposable);
        }
    }

    public void removeAllCompositeDisposable() {
        mCompositeDisposable.dispose();
    }
}
