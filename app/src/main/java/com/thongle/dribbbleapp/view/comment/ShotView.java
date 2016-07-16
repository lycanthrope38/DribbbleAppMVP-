package com.thongle.dribbbleapp.view.comment;

import com.thongle.dribbbleapp.core.mvp.ErrorableView;
import com.thongle.dribbbleapp.core.mvp.MvpView;
import com.thongle.dribbbleapp.data.remote.model.Shot;
import com.thongle.dribbbleapp.data.remote.model.comment.Comment;


import java.util.List;

/**
 * Created by ThongLe on 6/18/2016.
 */

public interface ShotView extends ErrorableView {
    void onShotSuccess(Shot shot);
    void onShotFailed();
    void onCommentsSuccess(List<Comment> comments);
    void onCommentsFailed();
}
