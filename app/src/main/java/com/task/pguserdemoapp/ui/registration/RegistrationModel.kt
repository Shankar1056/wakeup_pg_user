package com.task.pguserdemoapp.ui.registration

import com.google.gson.annotations.SerializedName
import com.task.pguserdemoapp.utilz.network.ApiCallback
import com.task.pguserdemoapp.utilz.network.ApiServices
import com.task.pguserdemoapp.utilz.network.BackoffCallback
import com.task.pguserdemoapp.utilz.network.RetroClient

import retrofit2.Response
import java.util.*

class RegistrationModel {
    @SerializedName("status")
    var status: Boolean? = null
    @SerializedName("message")
    var message: String = ""
    @SerializedName("response")
    var response: ArrayList<RegisrationDataModel>? = null

    fun basicRegister(model: RegisrationDataModel, apiCallback: ApiCallback) {

        val myCallback = object : BackoffCallback<RegistrationModel>(apiCallback) {
            override fun onSuccess(response: Response<RegistrationModel>?) {
                if (response != null) {
                    val region = response.body()
                    if (region != null) {
                        apiCallback.onSuccess(region)
                        return
                    }
                }
            }
        }
        RetroClient.getRetrofit()?.create(ApiServices::class.java)?.basicRegistration(
            model
        )
            ?.enqueue(myCallback)

    }

    private fun regModel(): RegisrationDataModel {
        return RegisrationDataModel()
    }

}

class RegisrationDataModel {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("pg_id")
    var pg_id: Int = 0
    @SerializedName("name")
    var name: String = ""
    @SerializedName("mobile")
    var mobile: String = ""
    @SerializedName("alternate_number")
    var alternate_number: String = ""
    @SerializedName("joining_date")
    var joining_date: String = ""
    @SerializedName("gender")
    var gender: String = ""
    @SerializedName("email_id")
    var email_id: String = ""
    @SerializedName("date_of_birth")
    var date_of_birth: String = ""
    @SerializedName("occupation")
    var occupation: String = ""
    @SerializedName("institute_office_name")
    var institute_office_name: String = ""
    @SerializedName("institute_office_location")
    var institute_office_location: String = ""
    @SerializedName("id_card")
    var id_card: String = ""
    @SerializedName("emergency_contact_name")
    var emergency_contact_name: String = ""
    @SerializedName("emergency_contact_number")
    var emergency_contact_number: String = ""
    @SerializedName("permanent_address")
    var permanent_address: String = ""
    @SerializedName("created_date")
    var created_date: String = ""
    @SerializedName("status")
    var status: Boolean? = null

}


