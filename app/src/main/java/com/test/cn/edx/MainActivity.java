package com.test.cn.edx;

import android.content.SharedPreferences;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.net.OauthIdentification;
import entity.net.User;
import listener.MyDrawerListener;
import listener.MyOnItemClickListener;
import listener.MyslideOnclickListener;
import listener.OnGetUserInfoListener;
import listener.UsuallyOnclickListener;
import myVolley.Api;
import myVolley.ApiImpl;
import listener.OnGetObjectListener;


public class MainActivity extends AppCompatActivity implements InitActivity, OnGetObjectListener, OnGetUserInfoListener {
    OauthIdentification o;
    User user;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private DrawerLayout.DrawerListener mDrawerToggle;
    private SimpleAdapter simpleAdapter;
    private ListView lvLeftMenu;
    private Button MainPeople;
    private Button courselistButton;
    private String[] slideText = {"我的课程", "个人信息", "我的笔记", "设置信息", "论坛讨论", "我的下载"};
    private int[] slideImage = {R.drawable.slideicon1, R.drawable.slideicon2, R.drawable.slideicon3, R.drawable.slideicon4, R.drawable.slideicon5, R.drawable.slideicon6,};
    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Api api = new ApiImpl();
        api.oauthIdentification(this);
        api.GetUserinfo(this);
        findViewById();
        // 初始化
        DrawerLayout.DrawerListener mDrawerToggle = new MyDrawerListener(mDrawerLayout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //点击头像弹出侧滑栏
        MainPeople.setOnClickListener(new MyslideOnclickListener(mDrawerLayout));
        //设置菜单列表
        simpleAdapter = new SimpleAdapter(this, getdata(), R.layout.list_item_slide, new String[]{"image", "text"}, new int[]{R.id.slide_image, R.id.slide_text});
        lvLeftMenu.setAdapter(simpleAdapter);
        lvLeftMenu.setOnItemClickListener(new MyOnItemClickListener(this, lvLeftMenu));
        courselistButton.setOnClickListener(new UsuallyOnclickListener(MainActivity.this));

    }

    @Override
    public void findViewById() {
        MainPeople = (Button) findViewById(R.id.main_people);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_main);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);
        courselistButton = (Button)findViewById(R.id.course_list);
    }

    public ArrayList<HashMap<String, Object>> getdata() {
        for (int i = 0; i < slideImage.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("image", slideImage[i]);
            map.put("text", slideText[i]);
            listItem.add(map);
        }
        return listItem;
    }

    ;

    @Override
    public void onSuccess(OauthIdentification object) {
        Log.i("原对象", object.getAccess_token().toString());
        if (object != null) {
            o = object;
            /*
            * 缓存token
            * */
            MyApplication.getsharedPreferencesQueue();
            SharedPreferences.Editor editor = MyApplication.getsharedPreferencesQueue().edit();
            editor.putString("tokenType", o.getToken_type().toString());
            editor.putString("tokenValue", o.getAccess_token().toString());
            editor.commit();
        }
    }

    @Override
    public void onSuccess(User obj) {
        if (obj != null) {
            user = obj;
            Log.i("查询成功", user.getName().toString());
        }
    }

    @Override
    public void onError(String error) {
        Log.i("对象失败", error);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getRequestQueue().cancelAll("UserRequest");
        MyApplication.getRequestQueue().cancelAll("OauthRequset");
    }


}
