package com.thongle.dribbbleapp.view.comment;

import com.thongle.dribbbleapp.core.mvp.BasePresenter;
import com.thongle.dribbbleapp.data.DataManager;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by ThongLe on 6/18/2016.
 */

public class ShotPresenter extends BasePresenter<ShotView> {

    @Inject
    DataManager dataManager;

    private Subscription subscription = Subscriptions.empty();

    @Inject
    public ShotPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void loadShot(int id) {
        checkViewAttached();

        subscription = dataManager.loadShot(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shot -> {
                            if (shot == null) {
                                mMvpView.onShotFailed();
                                return;
                            }
                            mMvpView.onShotSuccess(shot);
                        },
                        e -> {
                            if (e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
                                mMvpView.showNetworkError();
                            } else {
                                mMvpView.showGeneralError(e.getMessage());
                            }
                        });

    }

    public void loadComments(int id) {
        checkViewAttached();

        subscription = dataManager.loadComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(comments -> {
                            if (comments == null || comments.size() == 0) {
                                mMvpView.onCommentsFailed();
                                return;
                            }
                            mMvpView.onCommentsSuccess(comments);
                        },
                        e -> {
                            if (e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
                                mMvpView.showNetworkError();
                            } else {
                                mMvpView.showGeneralError(e.getMessage());
                            }
                        });

    }

    public void loadComment(int id, int page) {
        checkViewAttached();

        subscription = dataManager.loadComment(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(comments -> {
                            if (comments == null || comments.size() == 0) {
                                mMvpView.onCommentsFailed();
                                return;
                            }
                            mMvpView.onCommentsSuccess(comments);
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
