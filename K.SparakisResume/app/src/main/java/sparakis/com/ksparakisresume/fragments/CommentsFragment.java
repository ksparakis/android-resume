package sparakis.com.ksparakisresume.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;

import net.danlew.android.joda.JodaTimeAndroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import sparakis.com.ksparakisresume.R;
import sparakis.com.ksparakisresume.activities.AddCommentActivity;
import sparakis.com.ksparakisresume.adapters.CommentsAdapter;
import sparakis.com.ksparakisresume.apicalls.ApiCallFunctions;
import sparakis.com.ksparakisresume.database.Comments;

/**
 * Created by ksparakis on 4/20/16.
 */
public class CommentsFragment extends Fragment {

    RecyclerView commentsRV;
    SwipeRefreshLayout mSwipeRefreshLayout ;
    Button addCommentBtn;
    TextView pullTV;
    JsonHttpResponseHandler commentData = new JsonHttpResponseHandler(){

        @Override
        public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
            super.onSuccess(statusCode, headers, response);

           // try {
                System.out.println("Status Code = "+ statusCode);
                System.out.println("JSON = "+ response.toString());
                int count =0;
                JSONArray res= response;
                //JSONArray res = response.getJSONArray("results");
                count = res.length();
                Comments.deleteAll(Comments.class);

                for (int i =0; i < count; i++)
                {
                    //,"monthly_payment_day":5,
                    // "date_added":"2015-07-18T00:00:00Z",,
                    // ,"payment_plan":7,
                    // "last_payment_date":"2016-04-07T00:00:00Z"

                    try {
                        Comments dbComments = new Comments(
                                res.getJSONObject(i).getString("name"),
                                res.getJSONObject(i).getString("company"),
                                res.getJSONObject(i).getString("comment"),
                                res.getJSONObject(i).getString("timestamp")

                        );

                        dbComments.save();

                    }
                    catch (Exception e)
                    {

                    }
                }
                pullTV.setVisibility(View.GONE);
                populateComments();
                mSwipeRefreshLayout.setRefreshing(false);

        }


        @Override
        public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, JSONObject errorResponse) {
            super.onFailure(statusCode, headers, throwable, errorResponse);
            // System.out.println("Status Code = "+ statusCode);
            //System.out.println("JSON = "+ errorResponse.toString());
            onError();
        }
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater lf = getActivity().getLayoutInflater();
        JodaTimeAndroid.init(getActivity().getApplicationContext());
        View view =  lf.inflate(R.layout.fragment_comments, container, false); //pass the correct layout name for the fragment
        commentsRV = (RecyclerView) view.findViewById(R.id.comments_recyclerView);
        addCommentBtn = (Button) view.findViewById(R.id.commentBtn);
        pullTV = (TextView) view.findViewById(R.id.pulltv);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                mSwipeRefreshLayout.setRefreshing(true);
                refreshItems();
            }
        });

        addCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), AddCommentActivity.class);
                startActivity(intent);
            }
        });

        //If database is empty make first call to api for comments
        List<Comments> pp = Comments.listAll(Comments.class);
        if (pp.isEmpty()) {
            //System.out.println("ITS EMPTY");
            ApiCallFunctions.getComments(commentData);
        }
        else {
            pullTV.setVisibility(View.GONE);
            CommentsAdapter pca = new CommentsAdapter(pp);
            populateComments();
        }

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        populateComments();
        // Apply any required UI change now that the Fragment is visible.
    }

    private void populateComments() {
        commentsRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        List<Comments> pp = Comments.listAll(Comments.class);
        CommentsAdapter pca = new CommentsAdapter(pp);
        commentsRV.setAdapter(pca);

    }

    void refreshItems() {
        ApiCallFunctions.getComments(commentData);
    }


    void onError()
    {
        mSwipeRefreshLayout.setRefreshing(false);
        Snackbar snackbar = Snackbar
                .make(getView(), "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

        // Changing message text color
                snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
    }
}