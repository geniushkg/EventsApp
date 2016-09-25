package com.hardikgoswami.eventsapp.eventslist;

import android.util.Log;

import com.hardikgoswami.eventsapp.data.event.SortType;
import com.hardikgoswami.eventsapp.data.event.Website;
import com.hardikgoswami.eventsapp.data.source.EventListRepository;

import java.util.List;

/**
 * Created by geniushkg on 9/25/2016.
 */
public class EventListPresenter implements EventListContract.Presenter {
    EventListContract.View mView;
    EventListRepository mEventsRepo;

    public EventListPresenter(EventListContract.View mView) {
        this.mView = mView;
        mEventsRepo = new EventListRepository(this);
        mView.setPresenter(this);
    }

    @Override
    public void loadEvents(SortType sortType) {
        if(sortType == SortType.FAVOURITE){
            // offline load

        }else{
            // load from network
            mEventsRepo.loadNetworkEvents(sortType);
        }
    }

    @Override
    public void showEvents(List<Website> websiteList) {
        Log.d("EVENTSAPP","website data in presenter size : "+websiteList.size());
        mView.showEvents(websiteList);
    }

    @Override
    public void start() {

    }
}
