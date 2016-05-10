package com.test.cn.edx;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.VolleyError;

import entity.net.UserAllCourseInfo;
import listener.OnGetUserAllCourcesListener;
import myVolley.Api;
import myVolley.ApiImpl;

/**
 * Created by yuan on 2016/5/4.
 */
public class TextActivity extends AppCompatActivity implements OnGetUserAllCourcesListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Api api = new ApiImpl();
        api.GetUserAllCourseInfo(this);
    }

    @Override
    public void Onsuccess(UserAllCourseInfo userAllCourseInfo) {
        Log.i("用户",userAllCourseInfo.getUser().toString());
    }

    @Override
    public void OnError(VolleyError volleyError) {
        Log.i("失败",volleyError.getMessage());
    }
}
