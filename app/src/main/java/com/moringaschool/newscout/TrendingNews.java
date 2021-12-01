package com.moringaschool.newscout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrendingNews extends AppCompatActivity {
    @BindView(R.id.newsItemRecyclerView) RecyclerView recyclerView;
    @BindView(R.id.imageViewNotesBtn) ImageView ImageViewNotesBtn;
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));   // set layout manager as the current context
        recyclerView.setHasFixedSize(true);                                     //declare fixed size depending on array size(enhance perfomance)
        NewsAdapter newsAdapter = new NewsAdapter(mNews,TrendingNews.this);   //pass mNews and activity
        recyclerView.setAdapter(newsAdapter);



        // changeview  activity on click

        ImageViewNotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrendingNews.this,MyNotes.class);
                startActivity(intent);
            }
        });
    }





}