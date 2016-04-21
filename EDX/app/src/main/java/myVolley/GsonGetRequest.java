package myVolley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by yuan on 2016/4/21.
 */
public class GsonGetRequest<T> extends Request<T> {
    private Gson mGson = new Gson();
    private final Class<T> mClazz;
    private Map map;
    private Response.Listener mlistener;
    public GsonGetRequest(int method, String url, Class<T> mClazz, Response.Listener mlistener, Response.ErrorListener listener, Map map) {
        super(method, url, listener);
        this.mClazz = mClazz;
        this.mlistener =mlistener;
        this.map = map;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return map;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
                    String json = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
                      return Response.success(mGson.fromJson(json, mClazz),
                                        HttpHeaderParser.parseCacheHeaders(networkResponse));
                    } catch (UnsupportedEncodingException e) {
                        return Response.error(new ParseError(e));
                   } catch (JsonSyntaxException e) {
                        return Response.error(new ParseError(e));
                    }
    }

    @Override
    protected void deliverResponse(T t) {
        mlistener.onResponse(t);
    }
}
