package com.hardikgoswami.eventsapp.eventslist;

import com.hardikgoswami.eventsapp.BasePresenter;
import com.hardikgoswami.eventsapp.BaseView;
import com.hardikgoswami.eventsapp.data.event.Eventlist;
import com.hardikgoswami.eventsapp.data.event.SortType;
import com.hardikgoswami.eventsapp.data.event.Website;

import java.util.List;

/**
 * Created by geniushkg on 9/25/2016.
 */
/*
* contract class for eventlist features it defines presenter and view interface
* */
public class EventListContract {

    interface View extends BaseView<Presenter>{
        void setLoadingIndication(boolean active);
        void showEvents(List<Website> websiteList);
    }

    public interface Presenter extends BasePresenter{
        void loadEvents(SortType sortType);
        void showEvents(List<Website> websiteList);
    }

}
