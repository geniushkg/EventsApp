package com.hardikgoswami.eventsapp.eventslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.hardikgoswami.eventsapp.R;
import com.hardikgoswami.eventsapp.utils.ActivityUtils;

public class EventlistActivity extends AppCompatActivity {

    EventListContract.Presenter mEventsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventlist_act);
        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        // setup fragment
        EventListFragment eventListFragment = (EventListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(eventListFragment == null){
            eventListFragment = EventListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), eventListFragment, R.id.contentFrame);
        }
         // create presenter
       mEventsPresenter = new EventListPresenter(eventListFragment);
    }

}
