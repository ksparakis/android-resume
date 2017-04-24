package sparakis.com.ksparakisresume.apicalls;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ksparakis on 1/28/16.
 */
public class ApiCallFunctions {


    /*

                GET METHODS
     */



    public static void getComments( AsyncHttpResponseHandler responseHandler) {
        apiHandler.get("comments/" , null,responseHandler);
    }


    /*

                POST METHODS

     */

    public static void post_comments(String name, String company, String comment, Context context, JsonHttpResponseHandler responseHandler) {

        JSONObject commentData = new JSONObject();
        try {
            commentData.put("name", name);
            commentData.put("company", company);
            commentData.put("comment", comment);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        apiHandler.postRaw(context, "comments/", commentData, responseHandler);
    }

}
