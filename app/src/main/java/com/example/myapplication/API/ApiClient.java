package com.example.myapplication.API;

import com.example.myapplication.API.CustomAdapter.SimpleCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amirardaalan on 10/27/17.
 */

public class ApiClient {

    static  private Retrofit retrofit;
    public static Retrofit getClient(String baseUrl){
        if (retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(SimpleCallAdapterFactory.create())
                    .build();
        }
        return  retrofit;
    }


}
