package com.thongle.dribbbleapp.net.interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ThongLe on 6/16/2016.
 */

public class RequestInterceptor implements Interceptor {

    private final String mApiKey = "4e3e676ce2881d166900f7f0ba4f1c0c599f3126ff426c78e61fd3fc233b2a32";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request oldRequest = chain.request();
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());
//                .addQueryParameter("mApiKey", mApiKey);

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .addHeader("Accept", "application/vnd.dribbble.v1.param+json")
                .addHeader("Authorization", "Bearer 4e3e676ce2881d166900f7f0ba4f1c0c599f3126ff426c78e61fd3fc233b2a32")
                .build();
        return chain.proceed(newRequest);
    }
}
