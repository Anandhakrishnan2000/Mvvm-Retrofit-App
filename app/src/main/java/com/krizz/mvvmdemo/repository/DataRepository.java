package com.krizz.mvvmdemo.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.krizz.mvvmdemo.model.SampleApiModel;
import com.krizz.mvvmdemo.utils.GetDataService;
import com.krizz.mvvmdemo.utils.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {
    private final String TAG = DataRepository.class.getSimpleName();
    private GetDataService getDataService;

    public DataRepository(){
        getDataService = RetrofitService.getRetrofitInstance().create(GetDataService.class);
    }

    public LiveData<SampleApiModel> getApiData(){
        final MutableLiveData<SampleApiModel> sampleApiData= new MutableLiveData<>();
        getDataService.getApidata()
                .enqueue(new Callback<SampleApiModel>() {
                    @Override
                    public void onResponse(Call<SampleApiModel> call, Response<SampleApiModel> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response != null){
                            sampleApiData.setValue(response.body());


                            Log.d(TAG,"page:  "+response.body().getPage());
                            Log.d(TAG,"total_page:  "+response.body().getTotal_pages());
                        }
                    }

                    @Override
                    public void onFailure(Call<SampleApiModel> call, Throwable t) {
                        sampleApiData.setValue(null);

                    }
                });
        return sampleApiData;

    }
}
