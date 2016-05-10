package entity.net;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yuan on 2016/5/4.
 */
public class UserPreferences {

    /**
     * pref—movie : 12
     * pref-lang : en
     * account_privacy : all_users
     */

    @SerializedName("pref—movie")
    private String pref_movie;
    @SerializedName("pref-lang")
    private String pref_lang;
    private String account_privacy;

    public void setPref_movie(String pref_movie) {
        this.pref_movie = pref_movie;
    }

    public void setPref_lang(String pref_lang) {
        this.pref_lang = pref_lang;
    }

    public void setAccount_privacy(String account_privacy) {
        this.account_privacy = account_privacy;
    }

    public String getPref_movie() {
        return pref_movie;
    }

    public String getPref_lang() {
        return pref_lang;
    }

    public String getAccount_privacy() {
        return account_privacy;
    }
}
