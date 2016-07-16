package com.thongle.dribbbleapp.net.interceptor;

import com.thongle.dribbbleapp.DribbbleApp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class CacheInterceptor implements Interceptor {

    private int maxStale = 60 * 60 * 24 * 28;

    public CacheInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //access cache when offline
        if (!DribbbleApp.isNetConnect) {
//            request = request.newBuilder()
//                    .cacheControl(CacheControl.FORCE_CACHE)
//                    .build();
            CacheControl cacheControl = new CacheControl.Builder().maxStale(7, TimeUnit.DAYS)
                    .build();
            request = request.newBuilder().cacheControl(cacheControl).build();
            return chain.proceed(request);
        }

        Response response = chain.proceed(request);
        if (DribbbleApp.isNetConnect) {
            String cacheControl = request.cacheControl().toString();
            return response.newBuilder()
                    .header("Cache-Control", cacheControl)
                   .removeHeader("Pragma")
                    .build();
        } else {
            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
