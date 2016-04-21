package myVolley;


import listener.OnGetObjectListener;
import listener.OnGetUserInfoListener;

/**
 * Created by yuan on 2016/4/13.
 */
public interface Api {
    void oauthIdentification(OnGetObjectListener listener);
    void GetUserinfo (OnGetUserInfoListener listener);
}
