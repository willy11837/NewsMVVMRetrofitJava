package com.android.mvvmretrofitjava.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.mvvmretrofitjava.model.NewsModel.NewsBean;
import com.android.mvvmretrofitjava.network.APIService;
import com.android.mvvmretrofitjava.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListViewModel extends ViewModel {

    private MutableLiveData<NewsBean> newsList;

    public NewsListViewModel(){
        newsList = new MutableLiveData<>();
    }

    public MutableLiveData<NewsBean> getNewsListObserver() {
        return newsList;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<NewsBean> call = apiService.getNewsList();
        call.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                newsList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                Log.e("willy", "onFailure: "+ t.getMessage() );
                newsList.postValue(null);
            }
        });
    }
}
