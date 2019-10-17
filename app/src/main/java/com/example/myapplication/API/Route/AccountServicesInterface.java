package com.example.myapplication.API.Route;

import com.example.myapplication.API.Network.CustomAdapter.Simple;

import com.example.myapplication.model.response.ResponseModel;
import com.example.myapplication.model.account.UserAccount;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountServicesInterface {
    @POST("LoginBrokerStep1")
    Simple<ResponseModel<UserAccount>> loginStep1(@Body RequestBody body);

    @POST("LoginBrokerStep2")
    Simple<ResponseModel<UserAccount>> loginStep2(@Body RequestBody login);
}
