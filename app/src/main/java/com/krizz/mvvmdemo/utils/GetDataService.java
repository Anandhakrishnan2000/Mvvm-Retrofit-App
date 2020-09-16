package com.krizz.mvvmdemo.utils;

import com.krizz.mvvmdemo.model.SampleApiModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

        @GET("users?page=2")
    Call<SampleApiModel> getApidata();
}
