package com.task.pguserdemoapp.utilz.network

import com.task.pguserdemoapp.ui.login.LoginModel
import com.task.pguserdemoapp.ui.registration.RegisrationDataModel
import com.task.pguserdemoapp.ui.registration.RegistrationModel
import retrofit2.Call
import retrofit2.http.*


interface ApiServices {
    @Headers("x-api-key:1a!2b@3c#4d$5e%6f^")
    @POST("tanent_login")
    @FormUrlEncoded
    abstract fun getOtp(
        @Field("mobile_number") mobile_number: String,
        @Field("pg_id") pg_id: String
    ): Call<LoginModel>


    @Headers("x-api-key:1a!2b@3c#4d$5e%6f^")
    @POST("verify_otp")
    @FormUrlEncoded
    abstract fun verifyOtp(
        @Field("mobile_number") mobile_number: String,
        @Field("pg_id") pg_id: String,
        @Field("otp") otp: String
    ): Call<LoginModel>

    @Headers("x-api-key:1a!2b@3c#4d$5e%6f^")
    @POST("tenant_signup")
    abstract fun basicRegistration(
        @Body basicRegistration: RegisrationDataModel
    ): Call<RegistrationModel>
}