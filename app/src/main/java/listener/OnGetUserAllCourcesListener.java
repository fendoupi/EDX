package listener;

import com.android.volley.VolleyError;

import entity.net.UserAllCourseInfo;

/**
 * Created by yuan on 2016/5/4.
 */
public interface OnGetUserAllCourcesListener {
   void Onsuccess(UserAllCourseInfo userAllCourseInfo);
   void OnError(VolleyError volleyError);
}
