
package com.thongle.dribbbleapp.core;

import android.os.Bundle;


import com.thongle.dribbbleapp.R;
import com.thongle.dribbbleapp.widget.MultiSwipeRefreshLayout;

import butterknife.Bind;


public abstract class BaseSwipeRefreshLayoutActivity extends BaseToolbarActivity {

    @Bind(R.id.multi_swipe_refresh_layout) protected MultiSwipeRefreshLayout
            mMultiSwipeRefreshLayout;

    private boolean refreshStatus = false;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.initMultiSwipeRefreshLayout();
    }


    private void initMultiSwipeRefreshLayout() {
        if (this.mMultiSwipeRefreshLayout != null) {
            this.mMultiSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.green_400,R.color.colorAccent);
        }

        if (this.mMultiSwipeRefreshLayout != null) {
            this.mMultiSwipeRefreshLayout.setOnRefreshListener(() -> onSwipeRefresh());
        }
    }


    public abstract void onSwipeRefresh();

    public void setRefreshStatus(boolean status) {
        this.refreshStatus = status;
    }


    public boolean isRefreshStatus() {
        return refreshStatus;
    }


    public void refresh(final boolean refresh) {
        if (this.mMultiSwipeRefreshLayout == null) return;
        if (!refresh && this.refreshStatus) {
            this.mMultiSwipeRefreshLayout.postDelayed(() -> {
                BaseSwipeRefreshLayoutActivity.this.mMultiSwipeRefreshLayout.setRefreshing(false);
                BaseSwipeRefreshLayoutActivity.this.refreshStatus = false;
            }, 1666);
        } else if (!this.refreshStatus) {
            this.mMultiSwipeRefreshLayout.post(
                    () -> BaseSwipeRefreshLayoutActivity.this.mMultiSwipeRefreshLayout.setRefreshing(
                            true));
            this.refreshStatus = true;
        }
    }
}
