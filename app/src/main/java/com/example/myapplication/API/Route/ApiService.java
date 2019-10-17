package com.example.myapplication.API.Route;



import com.example.myapplication.API.Network.CustomAdapter.Simple;
import com.example.myapplication.model.RegisterModel;
import com.example.myapplication.model.response.UserResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by amirardaalan on 10/27/17.
 */

public interface ApiService {

    @POST("users")
    Simple<UserResponse> Register(@Body RegisterModel registerModel);

   @POST("auths")
    Simple<UserResponse> refreshToken(@Body RegisterModel oldtoken);


}
