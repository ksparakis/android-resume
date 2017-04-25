package sparakis.com.ksparakisresume.viewholders;

import android.content.Intent;
import android.graphics.Color;
import sparakis.com.ksparakisresume.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static android.R.id.input;


/**
 * Created by ksparakis on 4/16/16.
 */
public class CommentsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView mNameTv;
    private final TextView mCompanyTv;
    private final TextView mDateTv;
    private final TextView mCommentTV;


    public CommentsViewHolder(final View parent, TextView nametv, TextView companytv, TextView datetv, TextView commenttv) {
        super(parent);
        mNameTv = nametv;
        mCommentTV = commenttv;
        mCompanyTv = companytv;
        mDateTv = datetv;
        parent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Has been clicked do something

    }
    public static CommentsViewHolder newInstance(View parent) {
        TextView nameTextView = (TextView) parent.findViewById(R.id.comment_name_tv);
        TextView companyTextView = (TextView) parent.findViewById(R.id.comment_company_tv);
        TextView dateTextView = (TextView) parent.findViewById(R.id.comment_date_tv);
        TextView commentTextView = (TextView) parent.findViewById(R.id.comment_data_tv);
        return new CommentsViewHolder(parent, nameTextView, companyTextView, dateTextView, commentTextView );
    }

    public void setDateText(String text) {
        //Clean this only show date
        try {
            DateTimeZone zone = DateTimeZone.UTC ;  //  Or: DateTimeZone.forID( "America/Montreal" ) ;
            DateTime dateTime = new DateTime( text, zone ) ;
            java.util.Date date = dateTime.toDate();
            PrettyTime p = new PrettyTime();
            mDateTv.setText(p.format(date));
         } catch (Exception e) {
            //System.out.println("ERROR PARSING "+ e);
            mDateTv.setVisibility(View.GONE);
        }

    }

    public void setNameText(String text){
        mNameTv.setText(text);
    }

    public void setCommenText(String text){
        mCommentTV.setText(text);
    }

    public void setCompanyText(String company) {
        if (company == null)
        {
            //Hide the company
            mCompanyTv.setVisibility(View.GONE);
        }
        else
        {
            mCompanyTv.setText(company);
        }

    }



}