package com.example.myapplication.API.Route;

import com.example.myapplication.API.Network.CustomAdapter.Simple;
import com.example.myapplication.model.account.UserAccount;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OrderServices extends ApiService {

    @POST("BrokerCartableOrders")
    Simple<UserAccount> brokerOrder(@Body RequestBody body);
}
