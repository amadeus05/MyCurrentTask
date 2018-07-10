package com.example.extellar.mycurrenttask.Tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.extellar.mycurrenttask.R;
import com.example.extellar.mycurrenttask.Tamplate;
import com.example.extellar.mycurrenttask.UUI.MyAdapter;


import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class SecondTabActivity extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Context context;

    private List<Tamplate> list;
    Realm realm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_layout, container, false);


        recyclerView.findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        fillArr();

        adapter = new MyAdapter(list, context);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void fillArr(){
        RealmQuery<Tamplate> query = realm.where(Tamplate.class);
        RealmResults<Tamplate> result1 = query.findAll();
        for (Tamplate t: result1){
            list.add(t);
        }

    }
}
