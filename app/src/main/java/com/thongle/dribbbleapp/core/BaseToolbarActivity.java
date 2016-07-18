
package com.thongle.dribbbleapp.core;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


import com.thongle.dribbbleapp.R;

import butterknife.Bind;


public abstract class BaseToolbarActivity extends BaseAppCompatActivity {

    @Bind(R.id.toolbar) protected Toolbar mToolbar;
    @Bind(R.id.app_bar_layout) protected AppBarLayout mAppBarLayout;

    protected ActionBarHelper mActionBarHelper;



    @Override protected void initToolbar(Bundle savedInstanceState) {
        this.initToolbarHelper();
    }


    protected void initToolbarHelper() {
        if (this.mToolbar == null || this.mAppBarLayout == null) return;

        this.setSupportActionBar(this.mToolbar);

        this.mActionBarHelper = this.createActionBarHelper();
        this.mActionBarHelper.init();

        if (Build.VERSION.SDK_INT >= 21) {
            this.mAppBarLayout.setElevation(6.6f);
        }
    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    protected void showBack() {
        if (this.mActionBarHelper != null) this.mActionBarHelper.setDisplayHomeAsUpEnabled(true);
    }


    protected void setAppBarLayoutAlpha(float alpha) {
        this.mAppBarLayout.setAlpha(alpha);
    }


    protected void setAppBarLayoutVisibility(boolean visibility) {
        if (visibility) {
            this.mAppBarLayout.setVisibility(View.VISIBLE);
        } else {
            this.mAppBarLayout.setVisibility(View.GONE);
        }
    }



    public ActionBarHelper createActionBarHelper() {
        return new ActionBarHelper();
    }


    public class ActionBarHelper {
        private final ActionBar mActionBar;
        public CharSequence mDrawerTitle;
        public CharSequence mTitle;


        public ActionBarHelper() {
            this.mActionBar = getSupportActionBar();
        }


        public void init() {
            if (this.mActionBar == null) return;
            this.mActionBar.setDisplayHomeAsUpEnabled(true);
            this.mActionBar.setDisplayShowHomeEnabled(false);
            this.mTitle = mDrawerTitle = getTitle();
        }


        public void onDrawerClosed() {
            if (this.mActionBar == null) return;
            this.mActionBar.setTitle(this.mTitle);
        }


        public void onDrawerOpened() {
            if (this.mActionBar == null) return;
            this.mActionBar.setTitle(this.mDrawerTitle);
        }


        public void setTitle(CharSequence title) {
            this.mTitle = title;
        }


        public void setDrawerTitle(CharSequence drawerTitle) {
            this.mDrawerTitle = drawerTitle;
        }


        public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
            if (this.mActionBar == null) return;
            this.mActionBar.setDisplayHomeAsUpEnabled(showHomeAsUp);
        }
    }
}
