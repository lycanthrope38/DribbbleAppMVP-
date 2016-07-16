package com.thongle.dribbbleapp.view;

import com.thongle.dribbbleapp.core.mvp.ErrorableView;
import com.thongle.dribbbleapp.data.remote.model.Shot;

import java.util.List;

/**
 * Created by ThongLe on 6/18/2016.
 */

public interface ShotsView extends ErrorableView {
    void onShotsSuccess(List<Shot> shots);

    void onShotsFailed();
}
