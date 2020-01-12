package com.task.pguserdemoapp.ui.login

import android.app.Application
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.task.pguserdemoapp.MyApplication
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.utilz.network.ApiCallback


class LoginViewModel(val app: Application) : AndroidViewModel(app) {

    var model = LoginModel()
    var otpReceived = MutableLiveData<LoginModel>()
    var oTPVerified = MutableLiveData<Boolean>()
    var showProgressDialog = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()

    fun getMobileNumber(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                model.phone = (editable.toString())
            }
        }
    }


    fun onButtonClick(buttonText: String) {
        when (buttonText) {
            app.resources.getString(R.string.title_login) -> {
                when {
                    model.phone!!.isEmpty() -> {
                        errorMessage.value = app.resources.getString(R.string.error_empty_phone)
                    }
                    model.phone!!.length < 10 -> {
                        errorMessage.value = app.resources.getString(R.string.error_invalid_phone)
                    }
                    else -> {
                        sendMobileNumberForOTP()
                    }
                }
            }
            else -> {
                verifyOtp()
            }
        }

    }

    private fun verifyOtp() {
        if (MyApplication.getInstance().networkStateMonitor.isUp) {
            showProgressDialog.value = true
            model.verifyOtp(object : ApiCallback() {
                override fun onSuccess(obj: Any?) {
                    oTPVerified.value = true
                    showProgressDialog.value = true
                }

                override fun onHandledError() {
                    showProgressDialog.value = false
                }
            })
        } else {
            showProgressDialog.value = false
            errorMessage.value = app.resources.getString(R.string.no_internet_connection)
        }
    }

    private fun sendMobileNumberForOTP() {
        if (MyApplication.getInstance().networkStateMonitor.isUp) {
            showProgressDialog.value = true
            model.getOtp(object : ApiCallback() {
                override fun onSuccess(obj: Any?) {
                    otpReceived.value = obj as LoginModel
                    model.message = obj.message
                    showProgressDialog.value = false
                }

                override fun onHandledError() {
                    showProgressDialog.value = false
                }
            })
        } else {
            showProgressDialog.value = false
            errorMessage.value = app.resources.getString(R.string.no_internet_connection)
        }
    }
}