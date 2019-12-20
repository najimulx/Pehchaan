package com.example.dell.firstcry.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dell.firstcry.Activities.WebViewActivity;
import com.example.dell.firstcry.Objects.InfoResponse;
import com.example.dell.firstcry.R;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {

    List<InfoResponse> InfoResponseList;
    public InfoAdapter(List<InfoResponse> InfoResponses) {
        this.InfoResponseList = InfoResponses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.info_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_content.setText(InfoResponseList.get(i).link);
        myViewHolder.tv_title.setText(InfoResponseList.get(i).name);
        myViewHolder.tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                intent.putExtra("link",InfoResponseList.get(i).link);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return InfoResponseList.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title_info);
            tv_content = itemView.findViewById(R.id.tv_content_info);
        }
    }

}
