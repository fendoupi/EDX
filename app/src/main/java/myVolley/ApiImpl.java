package myVolley;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.test.cn.edx.MyApplication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import entity.net.OauthIdentification;
import entity.net.User;
import entity.net.UserAllCourseInfo;
import listener.OnGetObjectListener;
import listener.OnGetUserAllCourcesListener;
import listener.OnGetUserInfoListener;

/**
 * Created by yuan on 2016/4/13.
 */
public  class ApiImpl implements Api,Serializable {
    private Context context;
    public static final String SITE_URL = "http://edx.dev.cloudkz.cn:81";
    public static final String OAUTHIDENTIFICATION = "/oauth2/access_token";
    public static final String GETUSERALLCOURSEINFO = "/api/enrollment/v1/enrollment";
    public static final String GETUSERINFO = "/api/user/v1/accounts/wangyu";
    public static final String GETUSERPREFERENCES = "/api/user/v1/preferences/wangyu";
    @Override
    public  void  oauthIdentification(final OnGetObjectListener listener) {
        // 建立请求
        Request<OauthIdentification> OauthRequset = null;
        //OauthRequset.setTag("OauthRequset");
        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","0d213f4f2ea348ce0eec");
        map.put("client_secret","08b190f2dce26412179ea584e6c24e28047ab3e0");
        map.put("username","1837960253@qq.com");
        map.put("password", "iforgetit");
        map.put("grant_type", "password");
        OauthRequset = new GsonPostRequest<OauthIdentification>(1,SITE_URL + OAUTHIDENTIFICATION,
                new Response.Listener<OauthIdentification>() {
                    @Override
                    public void onResponse(OauthIdentification oauthIdentification) {
                        listener.onSuccess(oauthIdentification);
                    }
                }
        , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                        listener.onError(volleyError.getMessage().toString());
            }
        },map,OauthIdentification.class);

        MyApplication.getRequestQueue().add(OauthRequset);
    }
    @Override
    public  void GetUserAllCourseInfo(final OnGetUserAllCourcesListener listener) {
        Request<UserAllCourseInfo> UserAllcourseInfoRequest = null;
        //获取缓存的token信息
        String tokenValue = MyApplication.getsharedPreferencesQueue().getString("tokenValue","");
        String tokenType = MyApplication.getsharedPreferencesQueue().getString("tokenType","");
        Log.i("token",tokenValue.toString());
        Map map = new HashMap();
        map.put("Authorization",tokenType+" "+tokenValue);
        //建立请求
        UserAllcourseInfoRequest = new GsonGetRequest<UserAllCourseInfo>(Request.Method.GET, SITE_URL + GETUSERALLCOURSEINFO, UserAllCourseInfo.class, new Response.Listener<UserAllCourseInfo>() {

            @Override
            public void onResponse(UserAllCourseInfo userAllCourseInfo) {
                listener.Onsuccess(userAllCourseInfo);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.OnError(volleyError);
            }
        },map);
        MyApplication.getRequestQueue().add(UserAllcourseInfoRequest);
    }
    @Override
    public void GetUserinfo(final OnGetUserInfoListener onGetObjectListener)  {
            Request<User> UserRequest = null;
            //UserRequest.setTag("UserRequest");
            String tokenValue = MyApplication.getsharedPreferencesQueue().getString("tokenValue","");
            String tokenType = MyApplication.getsharedPreferencesQueue().getString("tokenType","");
            Map map = new HashMap();
            map.put("Authorization",tokenType+" "+tokenValue);
            UserRequest = new GsonGetRequest<User>(Request.Method.GET, SITE_URL + GETUSERINFO, User.class, new Response.Listener<User>() {
                @Override
                public void onResponse(User user) {
                    onGetObjectListener.onSuccess(user);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    onGetObjectListener.onError(volleyError.getMessage().toString());

                }
            }
            ,map);
        MyApplication.getRequestQueue().add(UserRequest);
    }

}




 /* OauthRequset = new NormalPostRequest(1, SITE_URL + OAUTHIDENTIFICATION,
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
        },map);*/