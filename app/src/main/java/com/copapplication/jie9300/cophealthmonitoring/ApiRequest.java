package com.copapplication.jie9300.cophealthmonitoring;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ApiRequest {
    private RequestQueue requestQueue;
    private static Context ctx;
    private static ApiRequest instance;



    private ApiRequest(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized ApiRequest getInstance(Context context) {
        if (instance == null) {
            instance = new ApiRequest(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
