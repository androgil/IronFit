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

import com.myironfit.ironfit.models.MyWkdyCalendar;
import com.myironfit.ironfit.R;

import java.util.List;

public class WkdyRecyclerAdapter extends RecyclerView.Adapter<WkdyRecyclerAdapter.ViewHolder> {

    private static final String TAG = "WkdRecyclerViewAdapter";

    private List<MyWkdyCalendar> mCalendar;
    private Context mContext;
    private OnItemClickListener mListener;


    /**
     *   Click Listenters Interfaces
     */
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnClickListener (OnItemClickListener listener) {
        mListener = listener;
    }


    /**
     *    ---- VIEWHOLDER ----
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView redDot;
        ImageView dateSelectedLine;
        TextView weekDay;
        TextView wkdDate;
        ConstraintLayout wkdRecyclerViewItem;


        public ViewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);
            redDot = itemView.findViewById(R.id.redDot);
            dateSelectedLine = itemView.findViewById(R.id.dateSelectedLine);
            weekDay = itemView.findViewById(R.id.weekDay);
            wkdDate = itemView.findViewById(R.id.wkdDate);
            wkdRecyclerViewItem = itemView.findViewById(R.id.wkdRecyclerViewItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    /**
     *  ---- RECYCLERVIEW ADAPTER ----
     */
    public WkdyRecyclerAdapter(List<MyWkdyCalendar> mCalendar, Context mContext) {
        this.mCalendar = mCalendar;
        this.mContext = mContext;
    }

    /**
     *   ---- ONCREATEVIEWHOLDER ----
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weekday_recyler_item, parent, false);
        return new ViewHolder(view, mListener);

    }

    /**
     *   ---- ONBINDVIEWHOLDER ----
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        MyWkdyCalendar calendar = mCalendar.get(position);
        holder.redDot.setVisibility(calendar.getDotVisible());
        holder.wkdDate.setText(calendar.getDate());
        holder.weekDay.setText(calendar.getDay());
        holder.weekDay.setTextColor(calendar.getTxtColor());
        holder.dateSelectedLine.setVisibility(calendar.getLnVisible());
    }

    @Override
    public int getItemCount() {
        return mCalendar.size();
    }


}
