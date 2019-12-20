package com.example.dell.firstcry.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dell.firstcry.Adapters.BannerAdapter;
import com.example.dell.firstcry.Adapters.InfoAdapter;
import com.example.dell.firstcry.Objects.BannerResponse;
import com.example.dell.firstcry.Objects.InfoResponse;
import com.example.dell.firstcry.R;
import com.example.dell.firstcry.Static;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
    RecyclerView recyclerView;
    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_info, container, false);
        recyclerView = v.findViewById(R.id.rv_info);


        initInfo(Static.INFO_OBJECT_LIST);
        return v;
    }
    void initInfo(List<InfoResponse> infoResponseList){
        if (infoResponseList != null) {
            InfoAdapter infoAdapter = new InfoAdapter(infoResponseList);
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            llm.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(llm);
            recyclerView.setAdapter(infoAdapter);
        }
    }

}
