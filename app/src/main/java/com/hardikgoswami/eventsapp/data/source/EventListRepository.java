package com.hardikgoswami.eventsapp.data.source;

import android.util.Log;

import com.hardikgoswami.eventsapp.data.event.Eventlist;
import com.hardikgoswami.eventsapp.data.event.SortType;
import com.hardikgoswami.eventsapp.data.event.Website;
import com.hardikgoswami.eventsapp.data.source.remote.ApiEndPoints;
import com.hardikgoswami.eventsapp.eventslist.EventListContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by geniushkg on 9/25/2016.
 */
public class EventListRepository {
        EventListContract.Presenter presenter;
    ApiEndPoints service;
    public static final String BASE_URL = "https://hackerearth.0x10.info/api/";
    public EventListRepository(EventListContract.Presenter presenter) {
        this.presenter = presenter;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiEndPoints.class);
    }

    public void loadFavouriteEvents(){
        // code to load faovourite offline events
    }

    public void loadNetworkEvents(final SortType sortType){
        // code for fetching from api
        Call<Eventlist> call = service.getEvenlist("list_events");
        call.enqueue(new Callback<Eventlist>() {
            @Override
            public void onResponse(Call<Eventlist> call, Response<Eventlist> response) {
                if(response.isSuccessful()){
                    List<Website> websites = response.body().getWebsites();
                    List<Website> filteredWebsite = new ArrayList<Website>();
                    filteredWebsite.clear();
                    for (Website temp  : websites){
                        if(temp.getCategory().equalsIgnoreCase(sortType.name())){
                            filteredWebsite.add(temp);
                        }
                    }
                    presenter.showEvents(filteredWebsite);
                    Log.d("EVENTSAPP","retrofit query sucesfull - size : "+filteredWebsite.size());
                }else {
                    Log.d("EVENTSAPP","retrofit query failure : "+response.message());
                }
            }

            @Override
            public void onFailure(Call<Eventlist> call, Throwable t) {
                Log.d("EVENTSAPP","retrofit query failed : "+t.getMessage());
            }
        });
    }
}
