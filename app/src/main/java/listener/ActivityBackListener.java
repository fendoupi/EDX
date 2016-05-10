package listener;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by yuan on 2016/5/9.
 */
public class ActivityBackListener implements View.OnClickListener {
    private Activity activity;
    public ActivityBackListener(Activity activity) {
                this.activity =activity;
    }

    @Override

    public void onClick(View v) {
        Log.i("销毁事件","被点击了");
       activity.finish();
    }
}
