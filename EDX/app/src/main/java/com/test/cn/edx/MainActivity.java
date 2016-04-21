package com.test.cn.edx;

import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import entity.net.OauthIdentification;
import entity.net.User;
import listener.OnGetUserInfoListener;
import myVolley.Api;
import myVolley.ApiImpl;
import listener.OnGetObjectListener;


public class MainActivity extends AppCompatActivity implements OnGetObjectListener,OnGetUserInfoListener{
    OauthIdentification o;
    User user;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private DrawerLayout.DrawerListener mDrawerToggle;
    private ArrayAdapter arrayAdapter;
    private String[] lvs = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};
    private ListView lvLeftMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Api api = new ApiImpl();
        api.oauthIdentification(this);
        api.GetUserinfo(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_main);
        lvLeftMenu = (ListView)findViewById(R.id.lv_left_menu);
        // 初始化
        DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
    }

    @Override
    public void onSuccess(OauthIdentification object) {
        Log.i("原对象",object.getAccess_token().toString());
        if(object != null){
            o = object;
            /*
            * 缓存token
            * */
            MyApplication.getsharedPreferencesQueue();
            SharedPreferences.Editor editor = MyApplication.getsharedPreferencesQueue().edit();
            editor.putString("tokenType",o.getToken_type().toString());
            editor.putString("tokenValue",o.getAccess_token().toString());
            editor.commit();
        }
    }

    @Override
    public void onSuccess(User obj) {
        if (obj!=null){
           user = obj;
            Log.i("查询成功",user.getName().toString());
        }
    }

    @Override
    public void onError(String error) {
            Log.i("对象失败",error);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getRequestQueue().cancelAll("UserRequest");
        MyApplication.getRequestQueue().cancelAll("OauthRequset");
    }
}
