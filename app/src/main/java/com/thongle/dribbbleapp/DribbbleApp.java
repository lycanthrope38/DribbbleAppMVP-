package com.thongle.dribbbleapp;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.thongle.dribbbleapp.di.components.ApplicationComponent;
import com.thongle.dribbbleapp.di.components.DaggerApplicationComponent;
import com.thongle.dribbbleapp.di.modules.ApplicationModule;
import com.thongle.dribbbleapp.net.ConnectionReceiver;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by ThongLe on 4/26/2016.
 */
public class DribbbleApp extends Application {

    @Inject
    EventBus mEventBus;


    public static boolean isNetConnect;
    private static DribbbleApp DRIBBBLE_APPLICATION;

    private ApplicationComponent mAppComponent;

    public static DribbbleApp getInstance() {
        return DRIBBBLE_APPLICATION;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DRIBBBLE_APPLICATION = this;

        registerNetReceiver();



        Timber.plant(new Timber.DebugTree());

        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mAppComponent.inject(this);
     //  mEventBus.register(this);

    }

    private void registerNetReceiver() {
        registerReceiver(new ConnectionReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public static DribbbleApp getApp(Context context) {
        return (DribbbleApp) context.getApplicationContext();
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }

    @Override public void onTerminate() {
    //    mEventBus.unregister(this);
        super.onTerminate();
    }

}
