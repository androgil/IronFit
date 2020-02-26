package com.myironfit.ironfit.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myironfit.ironfit.R;
import com.myironfit.ironfit.models.RecentHistory;
import com.myironfit.ironfit.ui.MainFragment;

import java.util.List;

public class RecentHistoryAdapter extends RecyclerView.Adapter<RecentHistoryAdapter.ViewHolder> {

    private static final String TAG = "RecentHistoryAdapter";

    private List<RecentHistory> mHistory;
    private MainFragment mContext;
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

        ImageView iv_history_recycler_exercises;
        ImageView iv_history_recycler_clock;
        TextView tv_history_recycler_day;
        TextView tv_history_recycler_date;
        TextView tv_history_recycler_month;
        TextView tv_history_recycler_name;
        TextView tv_history_recycler_muscles;
        TextView tv_history_recycler_exercises;
        TextView tv_history_recycler_duration;



        public ViewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);
            iv_history_recycler_exercises = itemView.findViewById(R.id.iv_history_recycler_exercises);
            iv_history_recycler_clock = itemView.findViewById(R.id.iv_history_recycler_clock);
            tv_history_recycler_day = itemView.findViewById(R.id.tv_history_recycler_day);
            tv_history_recycler_date = itemView.findViewById(R.id.tv_history_recycler_date);
            tv_history_recycler_month =itemView.findViewById(R.id.tv_history_recycler_month);
            tv_history_recycler_name = itemView.findViewById(R.id.tv_history_recycler_name);
            tv_history_recycler_muscles = itemView.findViewById(R.id.tv_history_recycler_muscles);
            tv_history_recycler_exercises = itemView.findViewById(R.id.tv_history_recycler_numexercises);
            tv_history_recycler_duration = itemView.findViewById(R.id.tv_history_recycler_duration);

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
    public RecentHistoryAdapter(List<RecentHistory> mHistory, MainFragment mContext) {
        this.mHistory = mHistory;
        this.mContext = mContext;
    }

    /**
     *   ---- ONCREATEVIEWHOLDER ----
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_recycler_item, parent, false);
        return new ViewHolder(view, mListener);

    }

    /**
     *   ---- ONBINDVIEWHOLDER ----
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        RecentHistory history = mHistory.get(position);
        holder.tv_history_recycler_day.setText(history.getDay());
        holder.tv_history_recycler_date.setText(history.getDate());
        holder.tv_history_recycler_month.setText(history.getMonth());
        holder.tv_history_recycler_name.setText(history.getName());
        holder.tv_history_recycler_muscles.setText(history.getMuscles());
        holder.tv_history_recycler_exercises.setText(history.getExercises());
        holder.tv_history_recycler_duration.setText(history.getDuration());
    }

    @Override
    public int getItemCount() {
        return mHistory.size();
    }


}