
package com.thongle.dribbbleapp.core.mvp;


import com.thongle.dribbbleapp.data.DataManager;

import rx.subscriptions.CompositeSubscription;


public class BasePresenter<T extends MvpView> implements Presenter<T> {

    protected T mMvpView;
    public CompositeSubscription mCompositeSubscription;


    @Override public void attachView(T mvpView) {
        this.mMvpView = mvpView;
        this.mCompositeSubscription = new CompositeSubscription();
    }


    @Override public void detachView() {
        this.mMvpView = null;
        this.mCompositeSubscription.unsubscribe();
        this.mCompositeSubscription = null;
    }


    public boolean isViewAttached() {
        return mMvpView != null;
    }


    public T getMvpView() {
        return mMvpView;
    }


    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }


    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
        }
    }
}
