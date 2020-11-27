package com.example.greads.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.greads.API.ApiService;
import com.example.greads.API.Server;
import com.example.greads.R;
import com.example.greads.adapter.NewsAdapter;
import com.example.greads.model.News_Model;
import com.example.greads.model.Response_News_Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_business extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    RecyclerView rv;
    NewsAdapter newsAdapter;
    List<News_Model> newsModelList = new ArrayList<>();
    private ProgressDialog progressDialog;
    ApiService api;
    final String category = "business";
    private SwipeRefreshLayout swipeRefreshLayout;

    public fragment_business() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.business, container, false);

        setHasOptionsMenu(true);

        swipeRefreshLayout = rootview.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        rv = rootview.findViewById(R.id.rv_business);
        api = Server.getApiService();
        newsAdapter = new NewsAdapter(getContext(),newsModelList);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
        onLoadingSwipeRefresh("");
        return rootview;
    }

    private void refresh(final String keyword) {
        swipeRefreshLayout.setRefreshing(true);
        progressDialog=new ProgressDialog(getContext(),R.style.ProgressColor);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("loading...");
        progressDialog.show();

        Call<Response_News_Model> call;
        if(keyword.length() > 0){
            call = api.getListSearchNews(keyword,"id","publishedAt" ,"12850cd010b54441aaeff6749dc99cd0");
        }else{
            call = api.getListNews("id",category, "12850cd010b54441aaeff6749dc99cd0");
        }

        call.enqueue(new Callback<Response_News_Model>() {
            @Override
            public void onResponse(Call<Response_News_Model> call, Response<Response_News_Model> response) {
                if (response.isSuccessful()){
                    swipeRefreshLayout.setRefreshing(false);
                    progressDialog.dismiss();
                    newsModelList = response.body().getNewsList();
                    rv.setAdapter(new NewsAdapter(getContext(), newsModelList));
                    newsAdapter.notifyDataSetChanged();
                } else {
                    swipeRefreshLayout.setRefreshing(false);
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Gagal mengambil data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response_News_Model> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onRefresh() {
        refresh("");
    }

    private void onLoadingSwipeRefresh(final String keyword){

        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        refresh(keyword);
                    }
                }
        );

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.my_menu , menu);
        MenuItem searchMenuItem = menu.findItem(R.id.menuSearch);

        android.widget.SearchView searchView = (android.widget.SearchView) searchMenuItem.getActionView();

        searchView.setQueryHint("Cari...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2){
                    onLoadingSwipeRefresh(query);
                }
                else {
                    Toast.makeText(getContext(), "ketik lebih dari 2 huruf!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchMenuItem.getIcon().setVisible(false, false);

        super.onCreateOptionsMenu(menu, inflater);
    }
}
