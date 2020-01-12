package com.task.pguserdemoapp.ui.login

import androidx.databinding.BaseObservable

import com.google.gson.annotations.SerializedName
import com.task.pguserdemoapp.utilz.network.ApiCallback
import com.task.pguserdemoapp.utilz.network.ApiServices
import com.task.pguserdemoapp.utilz.network.BackoffCallback
import com.task.pguserdemoapp.utilz.network.RetroClient

import retrofit2.Response

data class LoginModel(
    @SerializedName("status")
    var status: Boolean? = null,
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("response")
    var response: ArrayList<LoginDataModel>? = null,
    var _count: Int? = null,
    var phone: String = ""
) : BaseObservable() {


    fun getOtp(apiCallback: ApiCallback) {

        val myCallback = object : BackoffCallback<LoginModel>(apiCallback) {
            override fun onSuccess(response: Response<LoginModel>?) {
                if (response != null) {
                    val region = response.body()
                    if (region != null) {
                        apiCallback.onSuccess(region)
                        return
                    }
                }
            }
        }
        RetroClient.getRetrofit()?.create(ApiServices::class.java)?.getOtp(phone.toString(), "1")
            ?.enqueue(myCallback)

    }

    fun verifyOtp(apiCallback: ApiCallback) {
        val myCallback = object : BackoffCallback<LoginModel>(apiCallback) {
            override fun onSuccess(response: Response<LoginModel>?) {
                if (response != null) {
                    val region = response.body()
                    if (region != null) {
                        apiCallback.onSuccess(region)
                        return
                    }
                }
            }
        }
        message?.let {
            RetroClient.getRetrofit()?.create(ApiServices::class.java)?.verifyOtp(
                phone.toString(), "1",
                it
            )
                ?.enqueue(myCallback)
        }
    }
}

class LoginDataModel {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("pg_id")
    var pg_id: Int? = null
    @SerializedName("mobile")
    var mobile: String? = null
    @SerializedName("alternate_number")
    var alternate_number: String? = null
    @SerializedName("joining_date")
    var joining_date: String? = null
    @SerializedName("gender")
    var gender: String? = null
    @SerializedName("email_id")
    var email_id: String? = null
    @SerializedName("date_of_birth")
    var date_of_birth: String? = null
    @SerializedName("occupation")
    var occupation: String? = null
    @SerializedName("institute_office_name")
    var institute_office_name: String? = null
    @SerializedName("institute_office_location")
    var institute_office_location: String? = null
    @SerializedName("emergency_contact_name")
    var emergency_contact_name: String? = null
    @SerializedName("emergency_contact_number")
    var emergency_contact_number: String? = null
    @SerializedName("permanent_address")
    var permanent_address: String? = null
    @SerializedName("created_date")
    var created_date: String? = null
    @SerializedName("status")
    var status: Boolean? = null


}
