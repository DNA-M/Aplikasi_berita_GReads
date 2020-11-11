package com.example.greads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class News_Detail extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private WebView mWebView;
    String Image, Title, Content,PublishedAt,Author;
    private ImageView newsImage;
    private TextView newsTitle, newsContent, newsPublishedAt, newsName, newsUrl;

    String url = "https://www.google.com";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //android theme
        setContentView(R.layout.activity_news_detail);

        setupToolbar();

        mProgressBar = findViewById(R.id.progress_bar);
        mProgressBar.setMax(100);

        bindView();

        Image= getIntent().getStringExtra("image");
        Title = getIntent().getStringExtra("title");
        Content= getIntent().getStringExtra("content");
        PublishedAt = getIntent().getStringExtra("publishedAt");
        Author = getIntent().getStringExtra("author");
        url = getIntent().getStringExtra("url");


        Glide.with(getApplicationContext())
                .load(Image).into(newsImage);
        newsTitle.setText(Title);
        newsContent.setText(Content);
        newsPublishedAt.setText(Time.getTimeAgo(PublishedAt));
        //newsUrl.setText("Lihat Lebih Lengkap");
        newsName.setText(Author);

        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar.setProgress(0);
        mProgressBar.setVisibility(View.GONE);

    }

    //public void Url (View view) {
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
   // }

    public void bindView(){
        newsImage= findViewById(R.id.im_news_image);
        newsTitle= findViewById(R.id.tv_news_title);
        newsContent= findViewById(R.id.tv_news_content);
        newsName = findViewById(R.id.tv_name);
        newsPublishedAt = findViewById(R.id.tv_news_date);
       // newsUrl= findViewById(R.id.tv_url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share) {//share news
            shareUrl(url);
        }
        return super.onOptionsItemSelected(item);
    }

    //setup toolbar
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tv_news_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //share news
    private void shareUrl(String url) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(share, "Share to : "));
    }
}