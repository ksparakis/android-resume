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
        RequestParams commentData;
        if (company.isEmpty())
        {
             commentData= new RequestParams();
                commentData.put("Name", name);
                commentData.put("Comment", comment);

        }
        else
        {
            commentData= new RequestParams();
            commentData.put("Name", name);
            commentData.put("Comment", comment);
            commentData.put("Company", company);
        }

        apiHandler.post( "comments/", commentData, responseHandler);
    }

}
