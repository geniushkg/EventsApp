package com.hardikgoswami.eventsapp.utils;

/**
 * Created by geniushkg on 9/25/2016.
 */
public interface Listener<T> {

    void onSuccess(T t);

    void onFailure(String errorMessage);
}

