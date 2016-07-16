package com.thongle.dribbbleapp.core.mvp;


public interface ErrorableView extends MvpView {

    void showNetworkError();

    void showGeneralError(String message);
}
