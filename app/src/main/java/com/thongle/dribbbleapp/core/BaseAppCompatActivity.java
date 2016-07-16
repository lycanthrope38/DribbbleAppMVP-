package com.thongle.dribbbleapp.core;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import com.thongle.dribbbleapp.DribbbleApp;
import com.thongle.dribbbleapp.di.components.ActivityComponent;
import com.thongle.dribbbleapp.di.components.DaggerActivityComponent;
import com.thongle.dribbbleapp.di.modules.ActivityModule;

import butterknife.ButterKnife;


public abstract class BaseAppCompatActivity extends AppCompatActivity {

    private ActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayoutId());

        ButterKnife.bind(this);

        mComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(DribbbleApp.getApp(this).getAppComponent()).build();

        this.initToolbar(savedInstanceState);
        this.initViews(savedInstanceState);
        this.initData();
        this.initListeners();
    }

    public ActivityComponent getComponent() {
        return mComponent;
    }


    protected abstract int getLayoutId();


    protected abstract void initViews(Bundle savedInstanceState);


    protected abstract void initToolbar(Bundle savedInstanceState);


    protected abstract void initListeners();

    protected abstract void initData();


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }


    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }


    @Override
    public void finish() {
        super.finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showToast(String msg) {
        Toast.makeText(BaseAppCompatActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}
