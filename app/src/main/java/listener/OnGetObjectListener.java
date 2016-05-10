package listener;

import entity.net.OauthIdentification;

/**
 * Created by yuan on 2016/4/20.
 */
public interface OnGetObjectListener {
    void onSuccess(OauthIdentification obj);
    void onError(String error);
}
