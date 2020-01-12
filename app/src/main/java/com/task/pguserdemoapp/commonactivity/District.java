package com.task.pguserdemoapp.commonactivity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import com.task.pguserdemoapp.BR;

public class District {
    @SerializedName("status")
    public Boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("response")
    public ArrayList<DistrictDataMdel> response;

    public class DistrictDataMdel extends BaseObservable {
        @SerializedName("id")
        public int id;
        @SerializedName("code")
        public String code;
        @SerializedName("country")
        public String country;
        @SerializedName("state")
        public String state;
        @SerializedName("district")
        public String district;
        @SerializedName("status")
        public int status;

        @Bindable
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
            notifyPropertyChanged(BR.id);
        }

        @Bindable
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
            notifyPropertyChanged(BR.code);
        }

        @Bindable
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
            notifyPropertyChanged(BR.country);
        }

        @Bindable
        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
            notifyPropertyChanged(BR.state);
        }

        @Bindable
        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
            notifyPropertyChanged(BR.district);
        }

        @Bindable
        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
            notifyPropertyChanged(BR.status);
        }


    }
}
