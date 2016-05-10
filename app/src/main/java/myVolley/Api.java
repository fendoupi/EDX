package myVolley;


import listener.OnGetObjectListener;
import listener.OnGetUserAllCourcesListener;
import listener.OnGetUserInfoListener;

/**
 * Created by yuan on 2016/4/13.
 */
public interface Api {
    /*
    * 获取token
    * */
    void oauthIdentification(OnGetObjectListener listener);
    /*
    * 获取用户所有的课程信息
    * */
    void GetUserAllCourseInfo(OnGetUserAllCourcesListener listener);
    /*
    * 获取用户账号信息
    * */
    void GetUserinfo (OnGetUserInfoListener listener);

}
