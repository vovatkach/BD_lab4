package com.roksagmail.bd_lab4;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vovat on 11.05.2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecordsViewHolder> {
    List<ModelRecord> records;
    public RVAdapter(List<ModelRecord> records)
    {
        this.records=records;
    }

    public static class RecordsViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        TextView tvDate;
        TextView tvName;
        TextView tvRecord;
        public RecordsViewHolder(View itemView) {
            super(itemView);
            cv=(CardView) itemView.findViewById(R.id.cv);
            tvDate=(TextView)itemView.findViewById(R.id.tvDate);
            tvName=(TextView)itemView.findViewById(R.id.tvName);
            tvRecord=(TextView)itemView.findViewById(R.id.tvRecord);
        }
    }

    @Override
    public RecordsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inem_record, parent, false);
        RecordsViewHolder pvh = new RecordsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RecordsViewHolder holder, int position) {
        holder.tvDate.setText(records.get(position).getDate());
        holder.tvName.setText(records.get(position).getName());
        holder.tvRecord.setText(Integer.toString(records.get(position).getRecord()));


    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
