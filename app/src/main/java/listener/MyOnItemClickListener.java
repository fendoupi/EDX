package listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.test.cn.edx.SlideActivity.MyCourseActivity;
import com.test.cn.edx.SlideActivity.SettingInfoActivity;
import com.test.cn.edx.SlideActivity.SlideBbsActivity;
import com.test.cn.edx.SlideActivity.SlideDawnloadActivity;
import com.test.cn.edx.SlideActivity.SlideMynoteActivity;
import com.test.cn.edx.SlideActivity.SlideUserInfoActivity;

/**
 * Created by yuan on 2016/5/8.
 */
public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    private ListView listView;
    private Context context;
    public MyOnItemClickListener(Context context,ListView listView) {
        this.listView = listView;
        this.context = context;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent();
        if (position==0) i.setClass(context, MyCourseActivity.class);
        if (position==1) i.setClass(context, SlideUserInfoActivity.class);
        if (position==2) i.setClass(context, SlideMynoteActivity.class);
        if (position==3) i.setClass(context, SettingInfoActivity.class);
        if (position==4) i.setClass(context, SlideBbsActivity.class);
        if (position==5) i.setClass(context, SlideDawnloadActivity.class);
        context.startActivity(i);
    }


}
