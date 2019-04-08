package com.example.retrofitwithrxjavasample.network.model;

import com.google.gson.annotations.SerializedName;

public class User extends BaseResponse {

    @SerializedName("api_key")
    String api_key;

    public String getApi_key(){
        return api_key;
    }

}
