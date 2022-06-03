package com.example.thedailywave;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    Context context;
    ArrayList<ModelClass> modelClassArrayList = new ArrayList<>();

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = modelClassArrayList.get(position).getUrl();

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(view.getContext(), Uri.parse(url));


//                Intent intent = new Intent(context, webView.class);
//                intent.putExtra("url", modelClassArrayList.get(position).getUrl());
//                context.startActivity(intent);
            }
        });

        holder.mHeading.setText(modelClassArrayList.get(position).getTitle());
        holder.mDescription.setText(modelClassArrayList.get(position).getDescription());
        holder.mAuthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mTime.setText("Published At: - " + modelClassArrayList.get(position).getPublishedAt());
        holder.mHeading.setText(modelClassArrayList.get(position).getTitle());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return modelClassArrayList == null ? 0 : modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mHeading, mDescription, mAuthor, mTime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mHeading = itemView.findViewById(R.id.main_heading);
            mDescription = itemView.findViewById(R.id.description);
            mAuthor = itemView.findViewById(R.id.author);
            mTime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.news_image);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
