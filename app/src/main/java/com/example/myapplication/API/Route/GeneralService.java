package com.example.myapplication.API.Route;

import com.example.myapplication.API.Network.CustomAdapter.Simple;
import com.example.myapplication.model.response.AppSetting;
import com.example.myapplication.model.response.EnumsName;
import com.example.myapplication.model.response.ResponseModel;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface GeneralService {

    @POST("GetEnumNames")
    Simple<ResponseModel<ArrayList<EnumsName>>> getEnums(@Body RequestBody body);

    @POST("GetAppDefaultSetting")
    Simple<ResponseModel<AppSetting>> getSetAppSetting(@Query("AppCode") Integer appCode , @Query("DeviceTypeCode") Integer deviceCode);

}
