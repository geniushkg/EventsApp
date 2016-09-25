package com.hardikgoswami.eventsapp.eventslist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hardikgoswami.eventsapp.R;
import com.hardikgoswami.eventsapp.data.event.Eventlist;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment implements EventListContract.View {


    public EventListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.eventlist_frag, container, false);

        return rootView;
    }

    @Override
    public void setLoadingIndication(boolean active) {

    }

    @Override
    public void showEvents(Eventlist eventList) {

    }

    @Override
    public void setPresenter(EventListContract.Presenter presenter) {

    }
}
