package com.thongle.dribbbleapp.view.comment;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.thongle.dribbbleapp.R;
import com.thongle.dribbbleapp.config.Constant;
import com.thongle.dribbbleapp.core.BaseToolbarActivity;
import com.thongle.dribbbleapp.data.remote.model.Shot;
import com.thongle.dribbbleapp.data.remote.model.comment.Comment;
import com.thongle.dribbbleapp.util.GlideUtils;
import com.thongle.dribbbleapp.util.RevealBackgroundView;
import com.thongle.dribbbleapp.util.TypefacesUtil;

import org.parceler.Parcels;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class ShotIdActivity extends BaseToolbarActivity implements ShotView {

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsing;
    @Bind(R.id.backdrop)
    ImageView mBackDrop;
    @Bind(R.id.recycler_shot)
    RecyclerView mRecyclerComment;

    @Inject
    ShotPresenter mShotPresenter;

    private CommentAdapter mAdapter;


    private Shot mShot;
    private int mId;
    private List<Comment> mCommentList = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_shot_id;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        getComponent().inject(this);
        mShotPresenter.attachView(this);
        mCollapsing.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));
        mCollapsing.setExpandedTitleTypeface(TypefacesUtil.getRobotoMedium(this));

        mAdapter = new CommentAdapter(this, mCommentList);
        mRecyclerComment.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerComment.setHasFixedSize(true);
        mRecyclerComment.setAdapter(mAdapter);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mShot = Parcels.unwrap(getIntent().getParcelableExtra(Constant.SHOT_ID));
        if (mShot != null) {
            mId = mShot.getId();
            mCollapsing.setTitle(mShot.getTitle());
            GlideUtils.display(mBackDrop, mShot.getImages().getHidpi());
            mShotPresenter.loadComments(mId);
        }
    }



    @Override
    public void onShotSuccess(Shot shot) {

    }

    @Override
    public void onShotFailed() {

    }


    @Override
    public void onCommentsSuccess(List<Comment> comments) {
        mAdapter.setItems(comments);
        mCommentList.addAll(comments);
    }

    @Override
    public void onCommentsFailed() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showGeneralError(String message) {

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
