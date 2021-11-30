package com.moringaschool.newscout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrendingNews extends AppCompatActivity {
    @BindView(R.id.newsItemRecyclerView) RecyclerView recyclerView;
    ArrayList<News> mNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_news);
        ButterKnife.bind(this);
          mNews=new ArrayList<>();
        mNews.add(new News("Williams wins back to back in the Nairobi open","According to the caption on the bronze marker placed by the Multnomah Chapter of the Daughters of the American Revolution on May 12, 1939, “College Hall (is) the oldest building ",R.drawable.selena));
        mNews.add(new News("Williams wins back to back in the Nairobi open",
                " Tesla is accelerating the worldTesla is accelerating the world's transition to sustainable energy with electric cars, solar and integrated renewable energy solutions for homes and 's transition to sustainable energy with electric cars, solar and integrated renewable energy solutions for homes and  ",R.drawable.tesla));
        mNews.add(new News("Williams wins back to back in the Nairobi open","According to the caption on the bronze marker placed by the Multnomah Chapter of the Daughters of the American Revolution on May 12, 1939, “College Hall (is) the oldest building ",R.drawable.trump));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        NewsAdapter newsAdapter = new NewsAdapter(mNews,TrendingNews.this);
        recyclerView.setAdapter(newsAdapter);


    }





}