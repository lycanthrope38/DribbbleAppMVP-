package com.thongle.dribbbleapp.data.remote;

/**
 * Created by ThongLe on 4/26/2016.
 */

import com.thongle.dribbbleapp.DribbbleApp;
import com.thongle.dribbbleapp.config.Constant;
import com.thongle.dribbbleapp.net.interceptor.CacheInterceptor;
import com.thongle.dribbbleapp.net.interceptor.RequestInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public class ApiModule {

    public ApiModule() {
    }

    @Provides
    @Singleton
    public SimpleXmlConverterFactory provideXmlConverter() {
        return SimpleXmlConverterFactory.create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public CallAdapter.Factory provideCallAdapter() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory gson, CallAdapter.Factory adapter) {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(client)
                .addConverterFactory(gson)
                .addCallAdapterFactory(adapter)
                .build();
    }


    @Provides
    @Singleton
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        CacheInterceptor cacheInterceptor = new CacheInterceptor();

        RequestInterceptor requestInterceptor=new RequestInterceptor();

        File httpCacheDirectory = new File(DribbbleApp.getInstance().getCacheDir(), "responses");



        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(requestInterceptor)
                .addNetworkInterceptor(cacheInterceptor)
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS);



        return client.build();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
