package listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.test.cn.edx.CourseActivity;
import com.test.cn.edx.CourseListActivity;
import com.test.cn.edx.R;

/**
 * Created by yuan on 2016/5/10.
 */
public class UsuallyOnclickListener implements View.OnClickListener {
    private Context context;

    public UsuallyOnclickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
                if(v.getId()==R.id.course_list)
                i.setClass(context, CourseListActivity.class);
                if(v.getId()==R.id.computer_button)
                i.setClass(context, CourseActivity.class);

        context.startActivity(i);
    }
}
