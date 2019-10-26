package com.example.myapplication.API.Route;

import androidx.room.FtsOptions;

import com.example.myapplication.API.Network.CustomAdapter.Simple;
import com.example.myapplication.model.account.UserAccount;
import com.example.myapplication.model.response.ListResponse;
import com.example.myapplication.model.response.Load;
import com.example.myapplication.model.response.ResponseModel;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OrderServices extends ApiService {

    @POST("BrokerCartableOrders")
    Simple<ResponseModel<ListResponse<Load>>> brokerOrder(@Body RequestBody body);
}
