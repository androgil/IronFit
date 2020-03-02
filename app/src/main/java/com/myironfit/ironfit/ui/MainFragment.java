package com.myironfit.ironfit.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myironfit.ironfit.R;
import com.myironfit.ironfit.adapters.RecentHistoryAdapter;
import com.myironfit.ironfit.adapters.WkdyRecyclerAdapter;
import com.myironfit.ironfit.data.myCalendarData;
import com.myironfit.ironfit.models.MyWkdyCalendar;
import com.myironfit.ironfit.models.RecentHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainFragment extends Fragment {
    public MainFragment() {
    }
    private static final String TAG = "MainActivity";

    private List<MyWkdyCalendar> calendarList = new ArrayList<>();
    private RecyclerView mWkdyRecyclerView;
    private WkdyRecyclerAdapter mWkdyAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LinearSnapHelper snapHelper;
    private int lastClickedPosition = 0;

    private List<RecentHistory> historyList = new ArrayList<>();
    private RecyclerView mRecentHistoryRecycler;
    private RecentHistoryAdapter mHistoryAdapter;
    private RecyclerView.LayoutManager hLayoutManager;

    View rootView;



    /**
     *  onCreate used like in a regular activity
     *  set up adapters functions ets.
     */
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);



    }

    /**
     *  Inflate the fragment layout and connect to data
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Setting current month day year date text view
        String date_mdy = new SimpleDateFormat("MMM dd, YYYY", Locale.getDefault()).format(new Date());
        TextView date = rootView.findViewById(R.id.dateTextView);
        date.setText(date_mdy);

        //Setting current weekday text view
        String date_wd = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        TextView weekday = rootView.findViewById(R.id.weekdayTextView);
        weekday.setText(date_wd);

        //Floating Action Button
        FloatingActionButton fab = rootView.findViewById(R.id.add_session_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"FAB Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        initWkdRecyclerView();
        prepareCalendarData();

        initRecHistRecyclerView();
        prepareHistory();

        return rootView;
    }

    /**
     *   This is where you hook up to your views ect.
     *   use findViewById here
     */
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }

    /**
     *  ---- Select date function for the week day recyclerview ----
     */
    public void selectDate(final int position) {
        int txtSelectColor = Color.parseColor("#0CAADC");
        int visible = 0, invisible = 4;

        /**
         mWkdyRecyclerView.setItemAnimator(new DefaultItemAnimator());
         TextView childTextView = mWkdyRecyclerView.findViewHolderForItemId(mWkdyAdapter.getItemId(position)).itemView.findViewById(R.id.weekDay);
         Animation startRotateAnimation = AnimationUtils.makeInChildBottomAnimation(getApplicationContext());
         childTextView.startAnimation(startRotateAnimation);
         */

        if (lastClickedPosition != position) {
            calendarList.get(position).setTxtColor(txtSelectColor);
            calendarList.get(position).setLnVisible(visible);
            calendarList.get(lastClickedPosition).setTxtColor(Color.parseColor("#95989A"));
            calendarList.get(lastClickedPosition).setLnVisible(invisible);

            mWkdyAdapter.notifyItemChanged(position);
            mWkdyAdapter.notifyItemChanged(lastClickedPosition);
        }

        lastClickedPosition = position;
    }


    /**
     *  ---- Scroll to center function for the week day recyclerview  ----
     */
    public void scrollToCenter(View v){
        int itemToScroll = mWkdyRecyclerView.getChildLayoutPosition(v);
        int centerOfScreen = mWkdyRecyclerView.getWidth() / 2 - v.getWidth() / 2;

        if(itemToScroll < 3) {
            mLayoutManager.scrollToPosition(itemToScroll -3);
        }

    }


    /**
     *  ---- Horizontal weekday recycler view initialization ----
     */

    private void initWkdRecyclerView(){
        Log.d(TAG, "initWkdRecyclerView: init recyclerview");

        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mWkdyRecyclerView = rootView.findViewById(R.id.weekdayRecycler);
        mWkdyRecyclerView.setLayoutManager(mLayoutManager);
        mWkdyRecyclerView.setHasFixedSize(true);
        mWkdyAdapter = new WkdyRecyclerAdapter(calendarList, this);
        snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mWkdyRecyclerView);
        //mWkdyRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mWkdyRecyclerView.setAdapter(mWkdyAdapter);

        mWkdyAdapter.setOnClickListener(new WkdyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                selectDate(position);
                scrollToCenter(v);
            }
        });

    }

    /**
     *  ---- Recent History Recycler view initialization ----
     */

    private void initRecHistRecyclerView(){
        Log.d(TAG, "initRecHistRecyclerView: init recyclerview");

        hLayoutManager = new LinearLayoutManager(getContext());
        mRecentHistoryRecycler = rootView.findViewById(R.id.recentHistoryRecycler);
        mRecentHistoryRecycler.setLayoutManager(hLayoutManager);
        mRecentHistoryRecycler.setHasFixedSize(true);
        mHistoryAdapter = new RecentHistoryAdapter(historyList, this);
        mRecentHistoryRecycler.setAdapter(mHistoryAdapter);

    }


    /**
     *  ---- Prepares sample data to provide data set to adapter ----
     */
    private void prepareCalendarData() {

        myCalendarData m_calendar = new myCalendarData(-3);

        for ( int i=0; i <30; i++) {
            int txtColor = Color.parseColor("#95989A");
            MyWkdyCalendar calendar = new MyWkdyCalendar(m_calendar.getWeekDay(), String.valueOf(m_calendar.getDay()), String.valueOf(m_calendar.getMonth()), String.valueOf(m_calendar.getYear()),i, txtColor, 4);
            m_calendar.getNextWeekDay(1);

            calendarList.add(calendar);
        }

        mWkdyAdapter.notifyDataSetChanged();
    }

    /**
     *   ---- Insert fake history data ----
     */
    private void prepareHistory(){

        for (int i=0; i < 10; i++){
            RecentHistory history = new RecentHistory("Wed", "22", "Feb", "Chest & Shoulders", "Chest, Deltoids, Triceps", "12 Exercises", "2:13:21" );
            historyList.add(history);
        }

        mHistoryAdapter.notifyDataSetChanged();

    }

}
