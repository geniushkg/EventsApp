package com.hardikgoswami.eventsapp.eventslist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hardikgoswami.eventsapp.R;
import com.hardikgoswami.eventsapp.data.event.EventListAdapter;
import com.hardikgoswami.eventsapp.data.event.Eventlist;
import com.hardikgoswami.eventsapp.data.event.Website;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment implements EventListContract.View {

    EventListContract.Presenter mPresenter;
    List<Website> websiteList = new ArrayList<Website>();
    EventListAdapter mAdapter;
    RecyclerView recyclerViewEvents;

    public EventListFragment() {
        // Required empty public constructor
    }

    AVLoadingIndicatorView loadingView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.eventlist_frag, container, false);
        loadingView = (AVLoadingIndicatorView) rootView.findViewById(R.id.eventsLoadingIndicatorView);
        recyclerViewEvents = (RecyclerView) rootView.findViewById(R.id.eventlistRecyclerView);
        mAdapter = new EventListAdapter(websiteList);
        recyclerViewEvents.setAdapter(mAdapter);
        recyclerViewEvents.setLayoutManager(new LinearLayoutManager(getContext()));
        // setup recycle view and adapter
        return rootView;
    }

    @Override
    public void setLoadingIndication(boolean active) {
        if (active) {
            loadingView.setVisibility(View.VISIBLE);
        } else {
            loadingView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showEvents(Eventlist eventList) {
        websiteList.clear();
        websiteList.addAll(eventList.getWebsites());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(EventListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.sort_spinner_toolbar_menu, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sort_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String Sort = (String) item.getTitle();
        Log.d("EVENTSAPP","menu item is : "+Sort);
        return true;
    }
}
