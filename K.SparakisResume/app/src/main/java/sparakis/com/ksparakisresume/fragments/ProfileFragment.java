package sparakis.com.ksparakisresume.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import sparakis.com.ksparakisresume.R;
import android.widget.TextView;
import com.squareup.picasso.*;

/**
 * Created by ksparakis on 4/20/16.
 */
public class ProfileFragment extends Fragment {

    View view;
    ImageView pro_cover;
    ImageView pro_pic;
    ImageView forkme;
    TextView linkedin_tv;
    TextView github_tv;
    TextView sparakis_tv;
    TextView insta_tv;
    TextView twitter_tv;
    TextView resume_tv;
    android.support.v7.widget.CardView fork_card;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater lf = getActivity().getLayoutInflater();
        view =  lf.inflate(R.layout.fragment_profile, container, false); //pass the correct layout name for the fragment

        //Init all fragment items
        pro_cover = (ImageView)  view.findViewById(R.id.pro_cover);
        pro_pic = (ImageView)  view.findViewById(R.id.profile_image);
        forkme = (ImageView)  view.findViewById(R.id.fork_me);
        fork_card = (android.support.v7.widget.CardView) view.findViewById(R.id.forkCard);
        twitter_tv = (TextView) view.findViewById(R.id.twitter_tv);
        resume_tv = (TextView) view.findViewById(R.id.resume_tv);
        github_tv = (TextView) view.findViewById(R.id.git_tv);
        insta_tv = (TextView) view.findViewById(R.id.insta_tv);
        twitter_tv = (TextView) view.findViewById(R.id.twitter_tv);
        linkedin_tv  = (TextView) view.findViewById(R.id.linkedin_tv);
        sparakis_tv = (TextView) view.findViewById(R.id.sparakis_tv);

        //Load images properly with picaso package, or else app lags and crashes
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.cover).into(pro_cover);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.profile).into(pro_pic);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.github).into(forkme);

        //Reset scaling as its lost with the picaso load
        pro_cover.setScaleType(ImageView.ScaleType.CENTER_CROP);
        forkme.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // On click open specified Link
        fork_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/ksparakis/android-resume";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        linkedin_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://linkedin.com/in/sparakis";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        github_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/ksparakis/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        resume_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/ksparakis/Resume/blob/master/Resume.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        sparakis_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://www.sparakis.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        twitter_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "twitter://user?user_id=4636430483";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));

                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://twitter.com/sparakis")));
                }
            }
        });

        insta_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String url = "https://www.instagram.com/ksparakis";
                Uri uri = Uri.parse("http://instagram.com/_u/ksparakis");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/ksparakis")));
                }
            }
        });


        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

    }


}