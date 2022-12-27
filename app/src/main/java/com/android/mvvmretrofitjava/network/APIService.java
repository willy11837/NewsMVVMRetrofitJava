package com.android.mvvmretrofitjava.network;

import com.android.mvvmretrofitjava.model.NewsModel.NewsBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("interview_get_vector.json")
    Call<NewsBean> getNewsList();
}
