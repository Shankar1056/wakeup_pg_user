package com.task.pguserdemoapp.utilz.network

import android.content.Intent
import com.task.pguserdemoapp.MyApplication
import com.task.pguserdemoapp.ui.network.NetworkErrorActivity

object NetworkResponseActionHandler {

    fun showServerError(message: String?) {

    }

    fun onUnAuthenticDo() {

    }

    fun networkErrorPage() {
        try {
            val intent = Intent(MyApplication.getInstance().applicationContext, NetworkErrorActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            MyApplication.getInstance().startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
