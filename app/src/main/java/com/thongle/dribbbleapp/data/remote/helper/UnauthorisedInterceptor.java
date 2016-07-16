package com.thongle.dribbbleapp.data.remote.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.thongle.dribbbleapp.DribbbleApp;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by ThongLe on 6/13/2016.
 */

public class UnauthorisedInterceptor implements Interceptor {

    @Inject
    EventBus mEventBus;

    public UnauthorisedInterceptor(Context context) {
      //  DribbbleApp.getApp(context).getAppComponent().inject(this);
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response=chain.proceed(chain.request());
        if (response.code()==401){
            //new Handler(Looper.getMainLooper()).post(()->mEventBus.post(new AuthenticationErrorEvent()));
        }
        return null;
    }
}
