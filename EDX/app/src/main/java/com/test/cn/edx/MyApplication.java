package com.test.cn.edx;

import android.app.Application;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yuan on 2016/4/18.
 */
public class MyApplication extends Application {
    private static RequestQueue requestQueue;
    private static SharedPreferences sharedPreferencesQueue ;
    @Override
    public void onCreate() {

        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        sharedPreferencesQueue = getApplicationContext().getSharedPreferences("global",MODE_PRIVATE);
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
    public static SharedPreferences getsharedPreferencesQueue() {
        return sharedPreferencesQueue;
    }
}
