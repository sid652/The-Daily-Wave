package com.example.thedailywave;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sportsFragment#} factory method to
 * create an instance of this fragment.
 */
public class sportsFragment extends Fragment {

    String apkiKey = "15f9c8c50a764aebbcffb80bcccdd2d7";
    ArrayList<ModelClass> modelClassArrayList = new ArrayList<>();
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewOfSports;
    private final String category = "sports";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sports, container, false);
        recyclerViewOfSports = v.findViewById(R.id.sports_RecyclerView);
        recyclerViewOfSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewOfSports.setAdapter(adapter);

        findNews();

        // Inflate the layout for this fragment
        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country, category, 100, apkiKey).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}