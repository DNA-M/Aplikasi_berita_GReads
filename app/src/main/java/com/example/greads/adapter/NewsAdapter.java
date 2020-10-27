package com.example.greads.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.greads.News_Detail;
import com.example.greads.Time;
import com.example.greads.model.News_Model;
import com.example.greads.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final Context context;
    private List<News_Model> newsModelList ;

    public NewsAdapter(Context context, List<News_Model> newsModelList) {
        this.context = context;
        this.newsModelList = newsModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.news_item_layout, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final News_Model newsModel = newsModelList.get(position);
        holder.newsTitle.setText(newsModel.getTitle());
        holder.newsDescription.setText(newsModel.getDescription());
        holder.newsName.setText(newsModel.getName());
        holder.newsPublishedAt.setText(Time.getTimeAgo(newsModel.getPublishedAt()));
        Glide.with(context).load(newsModel.getUrlToImage()).thumbnail(0.5f).into(holder.newsImage);

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, News_Detail.class);
                i.putExtra("image", newsModel.getUrlToImage());
                i.putExtra("title", newsModel.getTitle());
                if (newsModel.getDescription() == null) {
                    i.putExtra("description", "No Description");
                } else {
                    i.putExtra("description", newsModel.getDescription());
                }
                i.putExtra("publishedAt", newsModel.getPublishedAt());
                i.putExtra("name", newsModel.getName());
                i.putExtra("url", newsModel.getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView newsTitle;
        private TextView newsDescription;
        private TextView newsName;
        private TextView newsPublishedAt;
        private ImageView newsImage;
        private CardView cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            newsTitle=itemView.findViewById(R.id.tv_news_title);
            newsDescription=itemView.findViewById(R.id.tv_news_desc);
            newsName=itemView.findViewById(R.id.tv_name);
            newsPublishedAt=itemView.findViewById(R.id.tv_news_date);
            newsImage=itemView.findViewById(R.id.im_news_image);

        }
    }
}