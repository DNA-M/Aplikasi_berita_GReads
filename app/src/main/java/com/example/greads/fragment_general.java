package com.example.greads;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.greads.API.ApiService;
import com.example.greads.API.Server;
import com.example.greads.adapter.NewsAdapter;
import com.example.greads.BuildConfig;
import com.example.greads.model.News_Model;
import com.example.greads.model.Response_News_Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_general extends Fragment {

    RecyclerView rv;
    NewsAdapter newsAdapter;
    List<News_Model> newsModelList = new ArrayList<>();
    private ProgressDialog progressDialog;
    ApiService api;



    public fragment_general() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.general, container, false);

        rv = rootview.findViewById(R.id.rv_general);
        api = Server.getApiService();
        newsAdapter = new NewsAdapter(getContext(),newsModelList);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
        refresh();
        return rootview;
    }

    private void refresh() {
        progressDialog=new ProgressDialog(getContext(),R.style.ProgressColor);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("loading...");
        progressDialog.show();
        api.getListAllNews("id", "12850cd010b54441aaeff6749dc99cd0").enqueue(new Callback<Response_News_Model>() {
            @Override
            public void onResponse(Call<Response_News_Model> call, Response<Response_News_Model> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    newsModelList = response.body().getNewsList();
                    rv.setAdapter(new NewsAdapter(getContext(), newsModelList));
                    newsAdapter.notifyDataSetChanged();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Gagal mengambil data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response_News_Model> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
