package com.hardikgoswami.eventsapp.eventslist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hardikgoswami.eventsapp.R;
import com.hardikgoswami.eventsapp.data.event.Eventlist;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment implements EventListContract.View {


    public EventListFragment() {
        // Required empty public constructor
    }

    AVLoadingIndicatorView loadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.eventlist_frag, container, false);
        loadingView = (AVLoadingIndicatorView) rootView.findViewById(R.id.eventsLoadingIndicatorView);
        return rootView;
    }

    @Override
    public void setLoadingIndication(boolean active) {
        if (active) {
            loadingView.setVisibility(View.VISIBLE);
        } else {
            loadingView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showEvents(Eventlist eventList) {

    }

    @Override
    public void setPresenter(EventListContract.Presenter presenter) {

    }
}
