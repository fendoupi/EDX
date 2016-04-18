package entity.net;

/**
 * Created by yuan on 2016/4/18.
 * 网络获取json对应的实体类
 */
public class OauthIdentification {
    /**
     * access_token : 3f5819e8d753a4770445eb64accaa59b2ee488ae
     * token_type : Bearer
     * expires_in : 2591999
     * scope :
     */

    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getScope() {
        return scope;
    }
}
