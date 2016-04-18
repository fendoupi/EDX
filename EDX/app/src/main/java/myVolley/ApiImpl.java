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

/**
 * Created by yuan on 2016/4/13.
 */
public  class ApiImpl implements Api,Serializable {
    private Context context;
    public static final String SITE_URL = "http://edx.dev.cloudkz.cn:81";
    public static final String OAUTHIDENTIFICATION = "/oauth2/access_token";
    Request<OauthIdentification> OauthRequset = null;
    /*
    * 获取token
    *
    * */
    @Override
    public  void  oauthIdentification() {
        OauthIdentification o = new OauthIdentification();
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
                        Log.i("成功",oauthIdentification.getAccess_token().toString());
                    }
                }
        , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                        Log.i("失敗",volleyError.getMessage());
            }
        }
                ,map,OauthIdentification.class);
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
        MyApplication.getRequestQueue().add(OauthRequset);
    }

}
