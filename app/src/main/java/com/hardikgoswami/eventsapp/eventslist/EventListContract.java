package com.hardikgoswami.eventsapp.eventslist;

import com.hardikgoswami.eventsapp.BasePresenter;
import com.hardikgoswami.eventsapp.BaseView;

/**
 * Created by geniushkg on 9/25/2016.
 */
/*
* contract class for eventlist features it defines presenter and view interface
* */
public class EventListContract {

    interface View extends BaseView<Presenter>{
        void setLoadingIndication(boolean active);
        void showEvents(List<Event> eventList);
    }

    interface Presenter extends BasePresenter{

    }

}
