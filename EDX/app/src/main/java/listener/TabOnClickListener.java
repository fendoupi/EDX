package listener;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by yuan on 2016/4/10.
 *主页Tab移动点击事件
 */
public class TabOnClickListener implements View.OnClickListener {
    private int index=0;
    private ViewPager mviewpager;
    public TabOnClickListener(int i,ViewPager mviewpager){
        index=i;
        this.mviewpager = mviewpager;
    }

    @Override
    public void onClick(View v) {
        mviewpager.setCurrentItem(index);
    }
}
