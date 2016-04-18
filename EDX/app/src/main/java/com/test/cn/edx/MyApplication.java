package com.test.cn.edx;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yuan on 2016/4/18.
 */
public class MyApplication extends Application {
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {

        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
