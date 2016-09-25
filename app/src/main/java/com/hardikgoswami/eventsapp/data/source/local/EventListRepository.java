package com.hardikgoswami.eventsapp.data.source.local;

import com.hardikgoswami.eventsapp.data.event.SortType;
import com.hardikgoswami.eventsapp.eventslist.EventListContract;

/**
 * Created by geniushkg on 9/25/2016.
 */
public class EventListRepository {
        EventListContract.Presenter presenter;

    public EventListRepository(EventListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void loadFavouriteEvents(){
        // code to load faovourite offline events
    }

    public void loadNetworkEvents(SortType sortType){

    }
}
