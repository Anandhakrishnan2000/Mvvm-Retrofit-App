package com.krizz.mvvmdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.krizz.mvvmdemo.model.SampleApiModel;
import com.krizz.mvvmdemo.repository.DataRepository;

public class DataViewModel extends AndroidViewModel {

    public DataRepository dataRepository;
    public LiveData<SampleApiModel> apiResposeLiveData;


    public DataViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository();
        apiResposeLiveData = dataRepository.getApiData();

    }

    public LiveData<SampleApiModel> getDataResponseLiveData(){
        return apiResposeLiveData;
    }
}
