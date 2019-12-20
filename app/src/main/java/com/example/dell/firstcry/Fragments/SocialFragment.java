package com.example.dell.firstcry.Fragments;


import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dell.firstcry.Adapters.BannerAdapter;
import com.example.dell.firstcry.Adapters.PostAdapter;
import com.example.dell.firstcry.Objects.BannerResponse;
import com.example.dell.firstcry.Objects.PostResponse;
import com.example.dell.firstcry.R;
import com.example.dell.firstcry.RestApi.RetrofitClient;
import com.example.dell.firstcry.Static;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * A simple {@link Fragment} subclass.
 */
public class SocialFragment extends Fragment {
    RecyclerView recyclerView_post,recyclerView_banner;
    public SocialFragment() {
        // Required empty public constructor
    }

    FloatingActionButton fab_post,fab_create_event,fab_my_event;
    Dialog postDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_social, container, false);
        fab_post = v.findViewById(R.id.fab_post);
        fab_create_event = v.findViewById(R.id.fab_create_event);
        fab_my_event = v.findViewById(R.id.fab_my_event);
        recyclerView_banner = v.findViewById(R.id.rv_banner);
        recyclerView_post = v.findViewById(R.id.rv_post_list);
        fab_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDialog = new Dialog(getContext());
                postDialog.setContentView(R.layout.create_post_dialog);
                Button postDone = postDialog.findViewById(R.id.bt_create_post);
                final EditText et_post_content = postDialog.findViewById(R.id.et_create_post_body);
                postDialog.show();
                postDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!et_post_content.getText().toString().equals("")){
                            createPost(et_post_content.getText().toString());
                            postDialog.dismiss();
                        }
                    }
                });
            }
        });
        fab_create_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDialog = new Dialog(getContext());
                postDialog.setContentView(R.layout.create_event_dialog);
                Button postDone = postDialog.findViewById(R.id.bt_create_post);
                final EditText et_post_content = postDialog.findViewById(R.id.et_create_post_body);
                postDialog.show();
                postDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        });
        fab_my_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        initBanner(Static.BANNER_OBJECT_LIST);
        initPost(Static.POST_OBJECT_LIST);
        return v;
    }

    void createPost(String postText){
        Call<ResponseBody> call = RetrofitClient.getInstance().getApi()
                .rest_create_post(postText,"Bearer "+ Static.TOKEN);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    void initBanner(List<BannerResponse> bannerResponseArrayList){
        if (bannerResponseArrayList != null) {
            BannerAdapter bannerAdapter = new BannerAdapter(bannerResponseArrayList);
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            llm.setOrientation(RecyclerView.HORIZONTAL);
            recyclerView_banner.setLayoutManager(llm);
            recyclerView_banner.setAdapter(bannerAdapter);
        }
    }
    void initPost(List<PostResponse> postResponseArrayList){
        if (postResponseArrayList!=null) {
            PostAdapter postAdapter = new PostAdapter(postResponseArrayList);
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            llm.setOrientation(RecyclerView.VERTICAL);
            recyclerView_post.setLayoutManager(llm);
            recyclerView_post.setAdapter(postAdapter);
        }
    }
}
