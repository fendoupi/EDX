package listener;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/**
 * Created by yuan on 2016/5/8.
 */
public class MyDrawerListener implements DrawerLayout.DrawerListener {
    private DrawerLayout drawerLayout;
    public MyDrawerListener(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }

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
}
