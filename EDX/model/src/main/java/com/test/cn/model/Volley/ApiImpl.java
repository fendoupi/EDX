/*
package com.test.cn.model.Volley;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.Map;

*/
/**
 * Created by yuan on 2016/4/13.
 *//*

public class ApiImpl implements Api,Serializable {
    private Context context;
    public static final String SITE_URL = "http://edx.dev.cloudkz.cn:81";
    public static final String OAUTHIDENTIFICATION = "/oauth2/access_token";
    RequestQueue requestQueue = Volley.newRequestQueue();
    Request<JSONObject> OauthRequset = null;
    public ApiImpl(Context context) {
        this.context = context;
    }

    @Override
    public void  oauthIdentification() {

        Map<String,String> map = null;
        map.put("client_id","0d213f4f2ea348ce0eec");
        map.put("client_secret","08b190f2dce26412179ea584e6c24e28047ab3e0");
        map.put("username","1837960253@qq.com");
        map.put("password","iforgetit");
        map.put("grant_type","password");

        OauthRequset = new NormalPostRequest(1, SITE_URL + OAUTHIDENTIFICATION,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.i("成功",jsonObject.toString());

                    }
                },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                        Log.i("失败",volleyError.getMessage());
            }
        },map);
        requestQueue.add(OauthRequset);
    }

}
*/
