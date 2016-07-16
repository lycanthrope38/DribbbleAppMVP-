package com.thongle.dribbbleapp.data.remote;

import com.thongle.dribbbleapp.data.remote.model.Shot;
import com.thongle.dribbbleapp.data.remote.model.comment.Comment;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ThongLe on 4/28/2016.
 */
public interface ApiService {

//    @Headers({
//            "Accept: application/vnd.dribbble.v1.param+json",
//            "Authorization: Bearer 4e3e676ce2881d166900f7f0ba4f1c0c599f3126ff426c78e61fd3fc233b2a32"
//    })
    @GET("shots")
    Observable<List<Shot>> shots(@Query("list") String params, @Query("page") int page);

    @GET("shots/{id}")
    Observable<Shot> shot(@Path("id") int shotId);

    @GET("shots/{id}/comments")
    Observable<List<Comment>> comment(@Path("id") int shotId, @Query("page") int page);

    @GET("shots/{id}/comments")
    Observable<List<Comment>> comments(@Path("id") int shotId);


}
