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
 * Use the {@link homeFragment} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {

    String apkiKey = "15f9c8c50a764aebbcffb80bcccdd2d7";
    ArrayList<ModelClass> modelClassArrayList = new ArrayList<>();
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewOfHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewOfHome = v.findViewById(R.id.home_RecyclerView);
        recyclerViewOfHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewOfHome.setAdapter(adapter);

        findNews();

        // Inflate the layout for this fragment
        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country, 100, apkiKey).enqueue(new Callback<MainNews>() {
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