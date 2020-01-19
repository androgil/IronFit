package com.myironfit.ironfit.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.myironfit.ironfit.MyCalendar;
import com.myironfit.ironfit.R;

import java.util.ArrayList;
import java.util.List;

public class WeekdayRecyclerViewAdapter extends RecyclerView.Adapter<WeekdayRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "WkdRecyclerViewAdapter";

    private List<MyCalendar> mCalendar;
    ///private ArrayList<String> mWeekDay;
    //private ArrayList<String> mWkdDate;
    private Context mContext;

    public WeekdayRecyclerViewAdapter(List<MyCalendar> mCalendar, Context mContext) {
        this.mCalendar = mCalendar;
        //this.mWeekDay = mWeekDay;
        //this.mWkdDate = mWkdDate;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weekday_recyler_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        MyCalendar calendar = mCalendar.get(position);

        holder.wkdDate.setText(calendar.getDate());
        holder.weekDay.setText(calendar.getDay());

    }

    @Override
    public int getItemCount() {
        return mCalendar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView redDot;
        ImageView dateSelectedLine;
        TextView weekDay;
        TextView wkdDate;
        ConstraintLayout wkdRecyclerViewItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            redDot = itemView.findViewById(R.id.redDot);
            dateSelectedLine = itemView.findViewById(R.id.dateSelectedLine);
            weekDay = itemView.findViewById(R.id.weekDay);
            wkdDate = itemView.findViewById(R.id.wkdDate);
            wkdRecyclerViewItem = itemView.findViewById(R.id.wkdRecyclerViewItem);

        }
    }
}
