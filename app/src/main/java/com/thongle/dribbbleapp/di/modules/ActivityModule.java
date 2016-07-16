package com.thongle.dribbbleapp.di.modules;

import android.app.Activity;
import android.content.Context;


import com.thongle.dribbbleapp.di.ActivityScope;
import com.thongle.dribbbleapp.di.PerActivity;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {
    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    Context provideContext() {
        return this.context;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return (Activity) this.context;
    }
}
