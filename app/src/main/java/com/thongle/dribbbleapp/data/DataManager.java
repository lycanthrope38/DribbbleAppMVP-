package com.thongle.dribbbleapp.data;

import android.app.Application;

import com.thongle.dribbbleapp.DribbbleApp;
import com.thongle.dribbbleapp.data.remote.ApiService;
import com.thongle.dribbbleapp.data.remote.model.Shot;
import com.thongle.dribbbleapp.data.remote.model.comment.Comment;
import com.thongle.dribbbleapp.util.RxUtils;



import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by ThongLe on 4/26/2016.
 */
@Singleton
public class DataManager {


    @Inject
    ApiService apiService;

    @Inject
    public DataManager(Application app) {
        ((DribbbleApp) app).getAppComponent().inject(this);
    }

//    public Observable<Shot> loadDataLocal(){
//        return Observable.create(subscriber -> {
//            try {
//                subscriber.onNext(exeDatabase.loadFromDatabase());
//                subscriber.onCompleted();
//            }catch (Exception e){
//                subscriber.onError(e);
//            }
//        });
//    }

    public Observable<List<Shot>> loadShots(int page) {
        return apiService.shots("everyone", page)
                .compose(RxUtils.applyIOToMainThreadSchedulers());

    }

    public Observable<Shot> loadShot(int id) {
        return apiService.shot(id).compose(RxUtils.applyIOToMainThreadSchedulers());
    }

    public Observable<List<Comment>> loadComment(int id, int page) {
        return apiService.comment(id, page).compose(RxUtils.applyIOToMainThreadSchedulers());
    }

    public Observable<List<Comment>> loadComments(int id) {
        return apiService.comments(id).compose(RxUtils.applyIOToMainThreadSchedulers());
    }



}
