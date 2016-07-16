package com.thongle.dribbbleapp.view;

import com.thongle.dribbbleapp.core.mvp.BasePresenter;
import com.thongle.dribbbleapp.data.DataManager;
import com.thongle.dribbbleapp.data.remote.model.Shot;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by ThongLe on 6/18/2016.
 */

public class ShotsPresenter extends BasePresenter<ShotsView> {
    @Inject
    DataManager dataManager;

    private Subscription subscription = Subscriptions.empty();

    @Inject
    public ShotsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void loadShots(int page) {
        checkViewAttached();

        subscription = dataManager.loadShots(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> new ArrayList<Shot>())
                .subscribe(shots -> {
                            if (shots == null || shots.size() == 0) {
                                mMvpView.onShotsFailed();
                                return;
                            }
                            mMvpView.onShotsSuccess(shots);
                        },
                        e -> {
                            if (e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
                                mMvpView.showNetworkError();
                            } else {
                                mMvpView.showGeneralError(e.getMessage());
                            }
                        });

    }
}
