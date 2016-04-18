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
 * Created by yuan on 2016/4/18.
 * post方式将json转化为对象
 */
public class GsonPostRequest<T> extends Request<T> {
    private final Gson mGson = new Gson();
    private Map<String,String> map;
    private final Class<T> mClazz;
    private final Response.Listener<T> mListener;

    public GsonPostRequest(int method, String url,  Response.Listener<T> mListener,Response.ErrorListener listener, Map<String, String> map, Class<T> mClazz) {
        super(method, url, listener);
        this.map = map;
        this.mClazz = mClazz;
        this.mListener = mListener;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
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
        mListener.onResponse(t);
    }
}
