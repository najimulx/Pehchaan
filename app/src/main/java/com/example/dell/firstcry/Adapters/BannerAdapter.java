package com.example.dell.firstcry.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dell.firstcry.Objects.BannerResponse;
import com.example.dell.firstcry.R;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.MyViewHolder> {

    List<BannerResponse> BannerResponseList;
    public BannerAdapter(List<BannerResponse> BannerResponses) {
        this.BannerResponseList = BannerResponses;
        Log.i("DATA_TEST",BannerResponses.get(0).title);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.event_banner_row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_content.setText(BannerResponseList.get(i).description);
        myViewHolder.tv_title.setText(BannerResponseList.get(i).title);
        myViewHolder.bt_venue.setText(BannerResponseList.get(i).venue);
        myViewHolder.bt_date.setText(BannerResponseList.get(i).eventDate);
        myViewHolder.bt_time.setText(BannerResponseList.get(i).eventTime);
    }

    @Override
    public int getItemCount() { return BannerResponseList.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_content;
        Button bt_date,bt_venue,bt_time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bt_time = itemView.findViewById(R.id.bt_time_banner);
            bt_date = itemView.findViewById(R.id.bt_date_banner);
            bt_venue = itemView.findViewById(R.id.bt_venue_banner);
            tv_title = itemView.findViewById(R.id.tv_title_banner);
            tv_content = itemView.findViewById(R.id.tv_content_banner);
        }
    }

}
