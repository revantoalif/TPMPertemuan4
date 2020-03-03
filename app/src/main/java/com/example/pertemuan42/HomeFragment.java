package com.example.pertemuan42;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rvPahlawan;
    private ArrayList<modelPahlawan> listPahlawan = new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvPahlawan = view.findViewById(R.id.rvPahlawan);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(dataPahlawan.getListData());
        rvPahlawan.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPahlawan adapterPahlawan = new adapterPahlawan(getContext());
        adapterPahlawan.setModelPahlawans(listPahlawan);
        rvPahlawan.setAdapter(adapterPahlawan);
        adapterPahlawan.setOnItemClickCallback(new adapterPahlawan.OnItemClickCallback() {
            @Override
            public void onItemClicked(modelPahlawan data) {
                Intent intent = new Intent(getContext(), detail_pahlawan.class);
                intent.putExtra(detail_pahlawan.EXTRA_DATA,data);
                startActivity(intent);
            }
        });
    }
}
