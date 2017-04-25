package sparakis.com.ksparakisresume.activities;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import sparakis.com.ksparakisresume.R;
import sparakis.com.ksparakisresume.apicalls.ApiCallFunctions;
import sparakis.com.ksparakisresume.database.Comments;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AddCommentActivity extends AppCompatActivity {

    ImageButton backBtn;
    ImageButton sendBtn;
    EditText nameET;
    EditText companyET;
    ProgressBar spinner;
    EditText commentET;
    JsonHttpResponseHandler sendComment = new JsonHttpResponseHandler(){

        @Override
        public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
            super.onSuccess(statusCode, headers, response);

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
            String nowAsString = df.format(new Date());

            Comments dbComments = new Comments(
                    nameET.getText().toString(),
                    companyET.getText().toString(),
                    commentET.getText().toString(),
                    nowAsString
            );
            dbComments.save();
            finish();

        }

        @Override
        public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, JSONObject errorResponse) {
            super.onFailure(statusCode, headers, throwable, errorResponse);
            onError();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.comment_toolbar, null);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(v);

        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        backBtn = (ImageButton) findViewById(R.id.back_btn);
        sendBtn = (ImageButton) findViewById(R.id.send_btn);
        nameET = (EditText) findViewById(R.id.name_et);
        companyET = (EditText) findViewById(R.id.company_et);
        commentET = (EditText) findViewById(R.id.comment_et);
        spinner.setVisibility(View.GONE);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Send POST Request
                freeze();
                if(nameET.getText().toString().length() < 3 ||
                        commentET.getText().toString().length() < 10)
                {
                    inputError();
                }
                else
                {
                    ApiCallFunctions.post_comments(nameET.getText().toString(),companyET.getText().toString(),
                            commentET.getText().toString(), getApplicationContext(),sendComment);
                }
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    void onError()
    {
        unfreeze();
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ApiCallFunctions.post_comments(nameET.getText().toString(),companyET.getText().toString(),
                                commentET.getText().toString(), getApplicationContext(),sendComment);
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

    void inputError()
    {
        unfreeze();
        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "Inputs Error: Comment at least 20 Char, Name at least 3 Char", Snackbar.LENGTH_LONG);

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    void freeze()
    {

        spinner.setVisibility(View.VISIBLE);
        //backBtn.setEnabled(false);
        companyET.setEnabled(false);
        commentET.setEnabled(false);
        nameET.setEnabled(false);
        sendBtn.setEnabled(false);
    }

    void unfreeze()
    {
        spinner.setVisibility(View.GONE);
        backBtn.setEnabled(true);
        companyET.setEnabled(true);
        commentET.setEnabled(true);
        nameET.setEnabled(true);
        sendBtn.setEnabled(true);
    }
}
