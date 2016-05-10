package listener;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;

/**
 * Created by yuan on 2016/5/9.
 */
public class MyslideOnclickListener implements View.OnClickListener {
    private DrawerLayout mdrawerLayout;
    public MyslideOnclickListener(DrawerLayout drawerLayout) {
        this.mdrawerLayout = drawerLayout;
    }
    @Override
    public void onClick(View v) {
        if (mdrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mdrawerLayout.closeDrawers();
        }
        if(!mdrawerLayout.isDrawerOpen(GravityCompat.START)){
            mdrawerLayout.openDrawer(GravityCompat.START);
        }

    }
}
