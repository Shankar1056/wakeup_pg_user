package com.task.pguserdemoapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.task.pguserdemoapp.utilz.NetworkStateMonitor;



public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {
    private static MyApplication ourInstance = null;
    public NetworkStateMonitor networkStateMonitor;
    private Activity activity;
    public boolean isChatRunning = false;

    public MyApplication() {
        ourInstance = this;
    }

    public static MyApplication getInstance() {
        if (ourInstance == null)
            ourInstance = new MyApplication();
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        networkStateMonitor = new NetworkStateMonitor(getApplicationContext());

    }


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        this.activity = null;
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public Activity getActivity() {
        return activity;
    }
}
