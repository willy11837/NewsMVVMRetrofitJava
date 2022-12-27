package com.android.mvvmretrofitjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mvvmretrofitjava.adapter.NewsListAdapter;
import com.android.mvvmretrofitjava.model.NewsModel.NewsBean;
import com.android.mvvmretrofitjava.viewmodel.NewsListViewModel;

public class MainActivity extends AppCompatActivity  {

    private NewsBean mNewsBean;
    private NewsListAdapter adapter;
    private NewsListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView noresult = findViewById(R.id.noResultTv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter =  new NewsListAdapter(this, mNewsBean, position ->
                Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show());
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(NewsListViewModel.class);
        viewModel.getNewsListObserver().observe(this, mNewsBean -> {
            if(mNewsBean != null) {
                adapter.setDataList(mNewsBean);
                noresult.setVisibility(View.GONE);
            } else {
                noresult.setVisibility(View.VISIBLE);
            }
        });
        viewModel.makeApiCall();
    }

//    @Override
//    public void onNewsClick(NewsBean newsBean) {
//        Toast.makeText(this, "Clicked News is : "
//                + newsBean.getGetVector().getItems(), Toast.LENGTH_SHORT).show();
//    }
}