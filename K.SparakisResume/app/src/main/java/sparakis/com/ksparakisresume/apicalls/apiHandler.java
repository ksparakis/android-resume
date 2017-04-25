package sparakis.com.ksparakisresume.apicalls;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by ksparakis on 1/28/16.
 */
public class apiHandler {

    //private static final String BASE_URL = "http://resume-api.sparakis.com/";
    private static final String BASE_URL = "http://104.196.216.20/";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void put(String url, RequestParams params, AsyncHttpResponseHandler responseHandler)
    {
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void putRawWithToken(Context context, String url, JSONObject params, AsyncHttpResponseHandler responseHandler, String Token) {
        client.addHeader("Authorization", "Token "+Token);

        StringEntity entity = null;
        try {
            entity = new StringEntity(params.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.put(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
    }

    public static void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler)
    {
        client.delete(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void getWithToken(String url, RequestParams params, AsyncHttpResponseHandler responseHandler, String Token) {
        client.addHeader("Authorization", "Token "+Token);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void getWithToken(String url, AsyncHttpResponseHandler responseHandler, String Token) {
        client.addHeader("Authorization", "Token "+Token);
        client.get(getAbsoluteUrl(url), responseHandler);
    }

    public static void postRaw(Context context, String url, JSONObject params, AsyncHttpResponseHandler responseHandler) {


        StringEntity entity = null;
        try {
            entity = new StringEntity(params.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.post(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
    }

    public static void postRawWithToken(Context context, String url, String params, AsyncHttpResponseHandler responseHandler, String Token) {
        client.addHeader("Authorization", "Token "+Token);

        StringEntity entity = null;
        try {
            entity = new StringEntity(params.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.post(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
    }

    public static void postWithToken(String url, RequestParams params, AsyncHttpResponseHandler responseHandler, String Token) {
        client.addHeader("Authorization", "Token "+Token);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }


    public static void putWithToken(String url, RequestParams params, AsyncHttpResponseHandler responseHandler, String Token)
    {
        client.addHeader("Authorization", "Token "+Token);
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void deleteWithToken(String url, RequestParams params, AsyncHttpResponseHandler responseHandler, String Token)
    {
        client.addHeader("Authorization", "Token "+Token);
        client.delete(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
