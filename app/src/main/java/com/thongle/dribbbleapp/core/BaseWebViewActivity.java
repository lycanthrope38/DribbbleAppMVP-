/*
 * {EasyGank}  Copyright (C) {2015}  {CaMnter}
 *
 * This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; type `show c' for details.
 *
 * The hypothetical commands `show w' and `show c' should show the appropriate
 * parts of the General Public License.  Of course, your program's commands
 * might be different; for a GUI interface, you would use an "about box".
 *
 * You should also get your employer (if you work as a programmer) or school,
 * if any, to sign a "copyright disclaimer" for the program, if necessary.
 * For more information on this, and how to apply and follow the GNU GPL, see
 * <http://www.gnu.org/licenses/>.
 *
 * The GNU General Public License does not permit incorporating your program
 * into proprietary programs.  If your program is a subroutine library, you
 * may consider it more useful to permit linking proprietary applications with
 * the library.  If this is what you want to do, use the GNU Lesser General
 * Public License instead of this License.  But first, please read
 * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
 */

package com.thongle.dribbbleapp.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.thongle.dribbbleapp.R;
import com.thongle.dribbbleapp.config.Constant;
import com.thongle.dribbbleapp.util.DeviceUtils;
import com.thongle.dribbbleapp.util.IntentUtils;
import com.thongle.dribbbleapp.util.ShareUtils;

import butterknife.Bind;


public class BaseWebViewActivity extends BaseToolbarActivity {


    private static final int PROGRESS_RATIO = 1000;

    @Bind(R.id.webview_pb)
    ProgressBar webviewPb;
    @Bind(R.id.webview)
    WebView webview;

    private boolean goBack = false;
    private static final int RESET_GO_BACK_INTERVAL = 2666;
    private static final int MSG_WHAT_RESET_GO_BACK = 206;
    private final Handler mHandler = new Handler(msg -> {
        switch (msg.what) {
            case BaseWebViewActivity.MSG_WHAT_RESET_GO_BACK:
                BaseWebViewActivity.this.goBack = false;
                return true;
        }
        return false;
    });


    public static void toUrl(Context context, String url, String title) {
        Intent intent = new Intent(context, BaseWebViewActivity.class);
        intent.putExtra(Constant.EXTRA_URL, url);
        intent.putExtra(Constant.EXTRA_TITLE, title);
        context.startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_web_view, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.web_refresh:
                this.refreshWebView();
                return true;
            case R.id.web_copy:
                DeviceUtils.copy2Clipboard(this, this.webview.getUrl());
                Snackbar.make(this.webview, this.getString(R.string.copy_success),
                        Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.menu_web_share:
                ShareUtils.share(this, this.getUrl());
                return true;
            case R.id.web_switch_screen_mode:
                this.switchScreenConfiguration(item);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            this.setAppBarLayoutVisibility(true);
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.setAppBarLayoutVisibility(false);
        }
    }


    public void switchScreenConfiguration(MenuItem item) {
        if (this.getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
            if (item != null) item.setTitle(this.getString(R.string.menu_web_horizontal));
        } else {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
            if (item != null) item.setTitle(this.getString(R.string.menu_web_horizontal));
        }
    }


    protected void refreshWebView() {
        this.webview.reload();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }


    @Override
    protected void initViews(Bundle savedInstanceState) {
    }


    @Override
    protected void initListeners() {

    }


    @Override
    protected void initData() {
        this.enableJavascript();
        this.enableCaching();
        this.enableCustomClients();
        this.enableAdjust();
        this.zoomedOut();
        this.webview.loadUrl(this.getUrl());
        this.showBack();
        this.setTitle(this.getUrlTitle());

    }


    private void enableCustomClients() {
        this.webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }


            /**
             * @param view The WebView that is initiating the callback.
             * @param url  The url of the page.
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }
        });
        this.webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                BaseWebViewActivity.this.webviewPb.setProgress(progress);
                setProgress(progress * PROGRESS_RATIO);
                if (progress >= 80) {
                    BaseWebViewActivity.this.webviewPb.setVisibility(View.GONE);
                } else {
                    BaseWebViewActivity.this.webviewPb.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void enableJavascript() {
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    }


    private void enableCaching() {
        this.webview.getSettings().setAppCachePath(getFilesDir() + getPackageName() + "/cache");
        this.webview.getSettings().setAppCacheEnabled(true);
        this.webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
    }


    private void enableAdjust() {
        this.webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.webview.getSettings().setLoadWithOverviewMode(true);
    }


    private void zoomedOut() {
        this.webview.getSettings().setLoadWithOverviewMode(true);
        this.webview.getSettings().setUseWideViewPort(true);
        this.webview.getSettings().setSupportZoom(true);
    }


    private String getUrl() {
        return IntentUtils.getStringExtra(this.getIntent(), Constant.EXTRA_URL);
    }


    private String getUrlTitle() {
        return IntentUtils.getStringExtra(this.getIntent(), Constant.EXTRA_TITLE);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.webview != null) this.webview.destroy();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (this.goBack) {
                this.finish();
            } else {
                this.goBack = true;
                Message msg = this.mHandler.obtainMessage();
                msg.what = MSG_WHAT_RESET_GO_BACK;
                this.mHandler.sendMessageDelayed(msg, RESET_GO_BACK_INTERVAL);
                Toast.makeText(this,getString(R.string.go_back_tip), Toast.LENGTH_SHORT).show();

            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void keyBackProcessScreenLandscape() {
        if (this.getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            this.switchScreenConfiguration(null);
        } else {
            if (this.webview.canGoBack()) {
                this.webview.goBack();
            } else {
                this.finish();
            }
        }
    }


}
