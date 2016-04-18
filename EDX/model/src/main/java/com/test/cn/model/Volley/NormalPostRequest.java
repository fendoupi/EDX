/*
package com.test.cn.model.Volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

*/
/**
 * Created by yuan on 2016/4/18.
 *//*

public class NormalPostRequest extends Request<JSONObject> {
    private Map<String,String> map;
    private Response.Listener<JSONObject> sListener;//成功返回监听
    public NormalPostRequest(int method, String url,Response.Listener<JSONObject> sListener, Response.ErrorListener listener,Map<String,String> map) {
        super(method, url, listener);
        this.map =map;
        this.sListener =sListener;
    }

    */
/*
    *
    * 返回map 此时参数拥有实例*//*

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String jsonString = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));

            return Response.success(new JSONObject(jsonString),HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }

    }

    */
/*
    *
    * 返回成功监听数据*//*

    @Override
    protected void deliverResponse(JSONObject jsonObject) {
    sListener.onResponse(jsonObject);
    }
}
*/
