package com.moringaschool.newscout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    ArrayList<News> mNews;
    Context context;

    public NewsAdapter(ArrayList<News> mNews, TrendingNews activity) {
        this.mNews=mNews;
        this.context = activity;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        News newsList = mNews.get(position);
        holder.textViewNewsTitle.setText(newsList.getTitle());
        holder.textViewNewsDescription.setText(newsList.getDescription());
        holder.ImageViewNews.setImageResource(newsList.getImageURL());


    }
    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNewsTitle;
        public TextView textViewNewsDescription;
        public ImageView ImageViewNews;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNewsTitle = (TextView) itemView.findViewById(R.id.textViewNewsTitle);
            textViewNewsDescription =(TextView)  itemView.findViewById(R.id.textViewNewsDescription);
            ImageViewNews = (ImageView) itemView.findViewById(R.id.NewsImageView);
        }
    }
}

