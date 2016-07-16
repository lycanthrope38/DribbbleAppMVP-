package com.thongle.dribbbleapp.util;

import android.os.Handler;
import android.os.Looper;


import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class EventPosterHelper {

   @Inject
   EventBus mBus;

    @Inject
    public EventPosterHelper(EventBus bus) {
        mBus = bus;
    }

    /**
     * Helper method to post an event from a different thread to the main one.
     */
    public void postEventSafely(final Object event) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                mBus.post(event);
            }
        });
    }
}
