package com.thongle.dribbbleapp.di.components;

import android.app.Application;
import android.content.Context;


import com.thongle.dribbbleapp.DribbbleApp;
import com.thongle.dribbbleapp.data.DataManager;
import com.thongle.dribbbleapp.data.remote.ApiModule;
import com.thongle.dribbbleapp.data.remote.ApiService;
import com.thongle.dribbbleapp.di.ApplicationScope;
import com.thongle.dribbbleapp.di.modules.ApplicationModule;
import com.thongle.dribbbleapp.util.EventPosterHelper;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    Application application();

    @ApplicationScope
    Context context();

    DataManager dataManager();

    ApiService apiService();

    EventBus eventBus();


    void inject(DataManager manager);
    void inject(EventPosterHelper eventPosterHelper);
    void inject(DribbbleApp dribbbleApp);

}
