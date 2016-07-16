package com.thongle.dribbbleapp.di.components;

import android.app.Activity;
import android.content.Context;


import com.thongle.dribbbleapp.di.ActivityScope;
import com.thongle.dribbbleapp.di.PerActivity;
import com.thongle.dribbbleapp.di.modules.ActivityModule;
import com.thongle.dribbbleapp.view.MainActivity;
import com.thongle.dribbbleapp.view.comment.ShotIdActivity;

import dagger.Component;


@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    @ActivityScope
    Context context();

    Activity activity();

    void inject(MainActivity activity);
    void inject(ShotIdActivity shotIdActivity);

}
