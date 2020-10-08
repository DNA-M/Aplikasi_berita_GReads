package com.example.greads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class News_Adapter extends RecyclerView.Adapter<News_Adapter.ViewHolder> {

    private Context context;
    private List<News_Model> newsModelList = new ArrayList<>();

    public News_Adapter(Context context, List<News_Model> newsModelList){
        this.context = context;
        this.newsModelList = newsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.news_item_layout, parent, false);
        return new ViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull News_Adapter.ViewHolder holder, int position) {
        final News_Model newsModel = newsModelList.get(position);
        holder.newsTitle.setText(newsModel.getTitle());
        holder.newsDescription.setText(newsModel.getDescription());
        holder.newsName.setText(newsModel.getName());
        holder.newsPublishedAt.setText(newsModel.getPublishedAt());
        holder.newsImage.setImageResource(newsModel.getImage());

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle=itemView.findViewById(R.id.tv_news_title);
            newsDescription=itemView.findViewById(R.id.tv_news_desc);
            newsName=itemView.findViewById(R.id.tv_name);
            newsPublishedAt=itemView.findViewById(R.id.tv_news_date);
            newsImage=itemView.findViewById(R.id.im_news_image);

        }
    }
}
