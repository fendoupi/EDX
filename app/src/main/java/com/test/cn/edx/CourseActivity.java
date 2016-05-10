package com.test.cn.edx;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.myFragmentAdapter;
import fragement.courselist.HighFragment;
import fragement.courselist.MiddleFragment;
import fragement.courselist.RookieFragement;
import listener.TabOnClickListener;

/**
 * Created by yuan on 2016/4/10.
 */
public class CourseActivity extends FragmentActivity {
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private myFragmentAdapter mFragmentAdapter;

    private ViewPager mPageVp;
    /**
     * Tab显示内容TextView
     */
    private LinearLayout lRookie, lMiddle, lHigh;
    private TextView rookie, middle, high;
    /**
     * Tab的那个引导线
     */
    private ImageView mTabLineIv;
    /**
     * Fragment
     */
    private RookieFragement rookieFragement;
    private MiddleFragment middleFragment;
    private HighFragment highFragment;
    /**
     * ViewPager的当前选中页
     */
    private int currentIndex;
    /**
     * 屏幕的宽度
     */
    private int screenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        findById();
        init();
        initTabLineWidth();
    }
    private void findById() {

        rookie = (TextView) this.findViewById(R.id.rookie);
        middle = (TextView) this.findViewById(R.id.middle);
        high = (TextView) this.findViewById(R.id.high);
        lRookie = (LinearLayout)this.findViewById(R.id.id_layout_rookie);
        lMiddle = (LinearLayout)this.findViewById(R.id.id_layout_middle);
        lHigh = (LinearLayout)this.findViewById(R.id.id_layout_high);
        mTabLineIv = (ImageView) this.findViewById(R.id.id_tab_line_iv);
        mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);
    }
    private void init() {
        rookieFragement = new RookieFragement();
        middleFragment = new MiddleFragment();
        highFragment = new HighFragment();
        lRookie.setOnClickListener(new TabOnClickListener(0,mPageVp));
        lMiddle.setOnClickListener(new TabOnClickListener(1,mPageVp));
        lHigh.setOnClickListener(new TabOnClickListener(2,mPageVp));
        mFragmentList.add(rookieFragement);
        mFragmentList.add(middleFragment);
        mFragmentList.add(highFragment);
        mFragmentAdapter = new myFragmentAdapter(this.getSupportFragmentManager(),mFragmentList);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(0);
        mPageVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         /*   *
             * state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做。

            *
             * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
             * offsetPixels:当前页面偏移的像素位置*/

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv
                        .getLayoutParams();

                Log.e("offset:", positionOffset+ "");
               /* *
                 * 利用currentIndex(当前所在页面)和position(下一个页面)以及offset来
                 * 设置mTabLineIv的左边距 滑动场景：
                 * 记3个页面,
                 * 从左到右分别为0,1,2
                 * 0->1; 1->2; 2->1; 1->0*/


                if (currentIndex == 0 && position == 0)// 0->1
                {
                    lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));

                } else if (currentIndex == 1 && position == 0) // 1->0
                {
                    lp.leftMargin = (int) (-(1 - positionOffset)
                            * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));

                } else if (currentIndex == 1 && position == 1) // 1->2
                {
                    lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));
                } else if (currentIndex == 2 && position == 1) // 2->1
                {
                    lp.leftMargin = (int) (-(1 - positionOffset)
                            * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));
                }
                mTabLineIv.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                resetTextView();
                switch (position) {
                    case 0:
                        rookie.setTextColor(Color.BLUE);
                        break;
                    case 1:
                        middle.setTextColor(Color.BLUE);
                        break;
                    case 2:
                        high.setTextColor(Color.BLUE);
                        break;
                }
                currentIndex = position;
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    private void initTabLineWidth() {
        DisplayMetrics dpMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay()
                .getMetrics(dpMetrics);
        screenWidth = dpMetrics.widthPixels;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv
                .getLayoutParams();
        lp.width = screenWidth / 3;
        mTabLineIv.setLayoutParams(lp);
    }
    private void resetTextView() {
        rookie.setTextColor(Color.BLACK);
        middle.setTextColor(Color.BLACK);
        high.setTextColor(Color.BLACK);
    }
}
