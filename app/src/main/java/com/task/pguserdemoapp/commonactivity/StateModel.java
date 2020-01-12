package com.task.pguserdemoapp.commonactivity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StateModel {

    @SerializedName("status")
    public Boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("response")
    public ArrayList<StateDataMdel> response;

    public class StateDataMdel {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @SerializedName("id")
        public int id;
        @SerializedName("state")
        public String state;
        @SerializedName("code")
        public String code;
        @SerializedName("country")
        public String country;
        @SerializedName("status")
        public int status;
    }
}
