package com.myironfit.ironfit.ui;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.myironfit.ironfit.models.MyWkdyCalendar;
import com.myironfit.ironfit.R;
import com.myironfit.ironfit.adapters.WkdyRecyclerAdapter;
import com.myironfit.ironfit.data.myCalendarData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";

    private List<MyWkdyCalendar> calendarList = new ArrayList<>();
    private RecyclerView mWkdyRecyclerView;
    private WkdyRecyclerAdapter mWkdyAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LinearSnapHelper snapHelper;
    private int lastClickedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        //Setting current month day year date text view
        String date_mdy = new SimpleDateFormat("MMM dd, YYYY", Locale.getDefault()).format(new Date());
        TextView date = findViewById(R.id.dateTextView);
        date.setText(date_mdy);

        //Setting current weekday text view
        String date_wd = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        TextView weekday = findViewById(R.id.weekdayTextView);
        weekday.setText(date_wd);

        FloatingActionButton fab = findViewById(R.id.add_session_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"FAB Pressed", Toast.LENGTH_SHORT).show();
            }
        });


        /**
         * Sidebar or Drawer
         */
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        initWkdRecyclerView();
        prepareCalendarData();
    }

    /**
     *  ---- Select date function for the week day recyclerview ----
     */
    public void selectDate(final int position) {
        int txtSelectColor = Color.parseColor("#519dd0");
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
     *  ---- Horizontal weekday recycler view initialization ----
     */

    private void initWkdRecyclerView(){
        Log.d(TAG, "initWkdRecyclerView: init recyclerview");

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mWkdyRecyclerView = findViewById(R.id.weekdayRecycler);
        mWkdyRecyclerView.setLayoutManager(mLayoutManager);
        mWkdyRecyclerView.setHasFixedSize(true);
        mWkdyAdapter = new WkdyRecyclerAdapter(calendarList, this);
        snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mWkdyRecyclerView);
        //mWkdyRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mWkdyRecyclerView.setAdapter(mWkdyAdapter);

        mWkdyAdapter.setOnClickListener(new WkdyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectDate(position);
            }
        });

        /**
        // Item Click Listener
        mWkdyRecyclerView.addOnItemTouchListener(new WkdRecyclerTouchListener(getApplicationContext(), mWkdyRecyclerView, new WkdRecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MyWkdyCalendar calendar = calendarList.get(position);
                int pos = position;
                TextView childTextView = view.findViewById(R.id.weekDay);
                ImageView childImageView = view.findViewById(R.id.dateSelectedLine);
                Animation startRotateAnimation = AnimationUtils.makeInChildBottomAnimation(getApplicationContext());


                if (lastClickedPosition != pos)
                    childTextView.startAnimation(startRotateAnimation);
                    childTextView.setTextColor(Color.CYAN);
                    childImageView.setVisibility(View.VISIBLE);
                    mWkdyAdapter.notifyItemChanged(lastClickedPosition);
                    lastClickedPosition = pos;


                Toast.makeText(getApplicationContext(), calendar.getDay() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
         */

    }


    /**
     *  ---- Prepares sample data to provide data set to adapter ----
     */
    private void prepareCalendarData() {

        // run a for loop for all the next 30 days of the current month starting today
        // initialize mycalendarData and get Instance
        // getnext to get next set of date etc.. which can be used to populate MyCalendarList in for loop

        myCalendarData m_calendar = new myCalendarData(-2);

        for ( int i=0; i <30; i++) {
            int txtColor = Color.parseColor("#95989A");
            MyWkdyCalendar calendar = new MyWkdyCalendar(m_calendar.getWeekDay(), String.valueOf(m_calendar.getDay()), String.valueOf(m_calendar.getMonth()), String.valueOf(m_calendar.getYear()),i, txtColor, 4);
            m_calendar.getNextWeekDay(1);

            calendarList.add(calendar);

        }

        // notify adapter about data set changes
        // so that it will render the list with new data

        mWkdyAdapter.notifyDataSetChanged();
    }

    /***
     *    ---- Floating Action Button ----
     */



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
