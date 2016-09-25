package com.hardikgoswami.eventsapp.data.source.remote;

import com.hardikgoswami.eventsapp.data.event.Eventlist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by geniushkg on 9/25/2016.
 */
public interface ApiEndPoints {
    @GET("toppr_events?type=json")
    Call<Eventlist> getEvenlist( @Query("query") String sort);
}

