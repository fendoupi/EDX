package listener;


import entity.net.User;

/**
 * Created by yuan on 2016/4/21.
 */
public interface OnGetUserInfoListener {
    void onSuccess(User obj);
    void onError(String error);
}
