package com.hardikgoswami.eventsapp.eventslist;

import com.hardikgoswami.eventsapp.data.event.SortType;
import com.hardikgoswami.eventsapp.data.event.Website;
import com.hardikgoswami.eventsapp.data.source.local.EventListRepository;

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
        }
    }

    @Override
    public void showEvents(List<Website> websiteList) {

    }

    @Override
    public void start() {

    }
}
