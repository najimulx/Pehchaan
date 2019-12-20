package com.example.dell.firstcry.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dell.firstcry.Objects.PostResponse;
import com.example.dell.firstcry.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    List<PostResponse> PostResponseList;
    public PostAdapter(List<PostResponse> PostResponses) {
        this.PostResponseList = PostResponses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.post_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_date.setText(PostResponseList.get(i).date);
        myViewHolder.tv_content.setText(PostResponseList.get(i).text);
        myViewHolder.tv_title.setText(PostResponseList.get(i).name);
    }

    @Override
    public int getItemCount() { return PostResponseList.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_content,tv_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_creation_time_post_row);
            tv_title = itemView.findViewById(R.id.tv_title_post);
            tv_content = itemView.findViewById(R.id.tv_content_post);
        }
    }

}
