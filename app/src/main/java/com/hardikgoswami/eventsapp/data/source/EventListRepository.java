package com.hardikgoswami.eventsapp.data.source;

import android.util.Log;

import com.hardikgoswami.eventsapp.data.converterutil.MyJsonConverter;
import com.hardikgoswami.eventsapp.data.event.Eventlist;
import com.hardikgoswami.eventsapp.data.event.SortType;
import com.hardikgoswami.eventsapp.data.event.Website;
import com.hardikgoswami.eventsapp.data.source.remote.ApiEndPoints;
import com.hardikgoswami.eventsapp.eventslist.EventListContract;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MyJsonConverter.create())
                .build();
        service = retrofit.create(ApiEndPoints.class);
    }

    public void loadFavouriteEvents(){
        // code to load faovourite offline events
        Log.d("EVENTSAPP","Load favourite events");
    }

    public void loadNetworkEvents(final SortType sortType){
        // code for fetching from api
        Call<Eventlist> call = service.getEvenlist("list_events");
        call.enqueue(new Callback<Eventlist>() {
            @Override
            public void onResponse(Call<Eventlist> call, Response<Eventlist> response) {
                if(response.isSuccessful()){
                    Eventlist eventlist = response.body();
                    List<Website> websites = eventlist.getWebsites();
                    List<Website> filteredWebsite = new ArrayList<Website>();
                    if(websites == null){
                        Log.d("EVENTSAPP","is empty site : "+websites.isEmpty());
                    }else {
                        Log.d("EVENTSAPP","not null and is empty : "+websites.isEmpty()+" size :"+websites.size());
                    }
                    for(Website temp:websites){
                        if(temp.getCategory().equalsIgnoreCase(sortType.name())){
                            filteredWebsite.add(temp);
                        }
                    }

                    presenter.showEvents(filteredWebsite);
                    Log.d("EVENTSAPP","websites data "+eventlist.getWebsites().toString());
                    Log.d("EVENTSAPP","retrofit query sucesfull - size : "+eventlist.getQuote_available()+"of total : "+eventlist.getQuote_max());
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
