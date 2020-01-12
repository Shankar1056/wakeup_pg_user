package com.task.pguserdemoapp.utilz

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkStateMonitor : BroadcastReceiver {
    private var mContext: Context? = null
    private var mIsUp: Boolean = false
    private var mListener: Listener? = null

    val isUp: Boolean
        get() {
            val connectivityManager = mContext!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetworkInfo: NetworkInfo? = null
            activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

    constructor(context: Context, listener: Listener) {
        mContext = context
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(this, intentFilter)
        mListener = listener
        mIsUp = isUp
    }

    constructor(context: Context) {
        mContext = context
        mIsUp = isUp
    }

    constructor() : super() {}

    fun unregister() {  // call this when finished with it, and no later than onStop(): callback will crash if app has been destroyed
        try {
            mListener = null
            mContext!!.unregisterReceiver(this)
        } catch (ignored: Exception) {
        }

    }

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context, intent: Intent) {
        mContext = context
        val upNow = isUp
        if (upNow == mIsUp)
            return
        mIsUp = upNow
        if (mListener != null) {
            mListener!!.onNetworkStateChange(mIsUp)
        }
    }

    interface Listener {
        fun onNetworkStateChange(up: Boolean)
    }
}
