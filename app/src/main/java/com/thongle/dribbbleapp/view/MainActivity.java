package com.thongle.dribbbleapp.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.thongle.dribbbleapp.R;
import com.thongle.dribbbleapp.config.Constant;
import com.thongle.dribbbleapp.core.BaseDrawerLayoutActivity;
import com.thongle.dribbbleapp.core.BaseWebViewActivity;
import com.thongle.dribbbleapp.data.remote.ApiService;
import com.thongle.dribbbleapp.data.remote.helper.AuthenticationErrorEvent;
import com.thongle.dribbbleapp.data.remote.model.Shot;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseDrawerLayoutActivity implements ShotsView {


    @Bind(R.id.main_rv)
    RecyclerView mRecyclerShot;

    @Inject
    ShotsPresenter shotPresenter;

    @Inject
    ApiService mApiService;

    @Inject
    EventBus mEventBus;


    private ShotAdapter shotAdapter;
    private int page = 0;
    private List<Shot> shotList = new ArrayList<>();

    private int emptyCount = 0;
    private static final int EMPTY_LIMIT = 5;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mRecyclerShot.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerShot.setHasFixedSize(true);

        //    mEventBus.register(this);
    }

    @Override
    protected void initData() {
        getComponent().inject(this);
        shotPresenter.attachView(this);
        new Handler().post(() -> MainActivity.this.refresh(true));
        page = page + 1;
        shotPresenter.loadShots(page);
        shotAdapter = new ShotAdapter(this, shotList);
        mRecyclerShot.setAdapter(shotAdapter);

    }

    @Override
    public void onSwipeRefresh() {
        new Handler().post(() -> MainActivity.this.refresh(true));
        page = page + 1;
        shotPresenter.loadShots(page);
        //refresh(false);
    }

    @Override
    protected NavigationView.OnNavigationItemSelectedListener getNavigationItemSelectedListener() {
        return item -> menuItemChecked(item.getItemId());
    }

    @Override
    protected int[] getMenuItemIds() {
        return Constant.menuIds;
    }

    @Override
    protected void onMenuItemOnClick(MenuItem now) {
        switch (now.getItemId()) {
            case R.id.navigation_main:
                break;
            case R.id.navigation_github:
                BaseWebViewActivity.toUrl(this, Constant.GITHUB_LINK, "Github_ThongLe");
                break;
        }
    }

    @Override
    protected void initListeners() {
        mRecyclerShot.addOnScrollListener(getRecyclerViewOnScrollListener());
    }

    public RecyclerView.OnScrollListener getRecyclerViewOnScrollListener() {
        return new RecyclerView.OnScrollListener() {
            private boolean toLast = false;


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (dy > 0) {
                    this.toLast = true;
                } else {
                    this.toLast = false;
                }
            }


            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        if (toLast && manager.findLastCompletelyVisibleItemPosition() ==
                                (manager.getItemCount() - 1)) {
                            loadMoreRequest();
                        }
                    }
                }
            }
        };
    }

    private void loadMoreRequest() {
        if (this.emptyCount >= EMPTY_LIMIT) {
            return;
        }

        if (!MainActivity.this.isRefreshStatus()) {
            this.setRefreshStatus(false);
            page = page + 1;
            shotPresenter.loadShots(page);
            this.refresh(true);
        }


    }


    @Subscribe
    public void onEvent(AuthenticationErrorEvent event) {
        showToast("Unauthorized! Redirect to Signin Activity..!.");
    }

    @Override
    public void onShotsSuccess(List<Shot> shots) {
        shotAdapter.setItems(shots);
        this.refresh(false);
    }

    @Override
    public void onShotsFailed() {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEventBus.unregister(this);
    }
}
