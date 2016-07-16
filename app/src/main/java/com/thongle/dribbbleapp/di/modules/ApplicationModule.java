package com.thongle.dribbbleapp.di.modules;

import android.app.Application;
import android.content.Context;


import com.thongle.dribbbleapp.di.ApplicationScope;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return this.application;
    }

    @Provides
    @ApplicationScope
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public EventBus eventBus(){
        return EventBus.getDefault();
    }
}
