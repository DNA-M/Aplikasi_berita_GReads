package com.example.greads;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greads.adapter.NewsAdapter;
import com.example.greads.model.News_Model;

import java.util.ArrayList;
import java.util.List;

public class fragment_sports extends Fragment {

    private RecyclerView rv;
    private NewsAdapter newsAdapter;
    private List<News_Model> news_models;

    public fragment_sports(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview =inflater.inflate(R.layout.sports, container, false);
        rv = (RecyclerView) rootview.findViewById(R.id.rv_sports);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(newsAdapter);

        return rootview;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
