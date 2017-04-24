package sparakis.com.ksparakisresume.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import sparakis.com.ksparakisresume.R;

/**
 * Created by ksparakis on 4/20/16.
 */
public class ProjectsFragment extends Fragment {

    ImageView spot_iv;
    ImageView apekit_iv;
    ImageView reclo_iv;
    ImageView csrf_iv;
    ImageView sundial_iv;
    ImageView ambios_iv;
    ImageView hands_iv;
    android.support.v7.widget.CardView spot_card;
    android.support.v7.widget.CardView apekit_card;
    android.support.v7.widget.CardView reclo_card;
    android.support.v7.widget.CardView csrf_card;
    android.support.v7.widget.CardView sundial_card;
    android.support.v7.widget.CardView ambios_card;
    android.support.v7.widget.CardView hands_card;

    String spot_url = "https://github.com/ksparakis/spot-analysis";
    String apekit_url = "https://github.com/ksparakis/apekit";
    String reclo_url = "https://github.com/ksparakis/cloud-recover";
    String csrf_url = "https://ksparakis.github.io/XSS-CSRF-Vuln-Examples/";
    String sundial_url = "https://www.youtube.com/watch?v=sy4Q-coJYH0";
    String ambios_url = "https://www.instagram.com/p/2MbthKAfAg/";
    String hands_url = "https://www.youtube.com/watch?v=by-Jo_hytO4";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_proj, container, false); //pass the correct layout name for the fragment
        spot_iv = (ImageView) view.findViewById(R.id.spotlogo);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.spotlogo).into(spot_iv);
        spot_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        apekit_iv = (ImageView) view.findViewById(R.id.apekit_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.apekit).into(apekit_iv);
        apekit_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        reclo_iv = (ImageView) view.findViewById(R.id.reclo_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.reclo).into(reclo_iv);
        reclo_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        csrf_iv = (ImageView) view.findViewById(R.id.csrf);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.csrf).into(csrf_iv);
        csrf_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        sundial_iv = (ImageView) view.findViewById(R.id.sundial_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.sundial).into(sundial_iv);
        sundial_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        hands_iv = (ImageView) view.findViewById(R.id.hands_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.hands).into(hands_iv);
        hands_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ambios_iv = (ImageView) view.findViewById(R.id.ambios_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.ambios).into(ambios_iv);
        ambios_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);


        spot_card = (android.support.v7.widget.CardView) view.findViewById(R.id.spot_card);
        apekit_card = (android.support.v7.widget.CardView) view.findViewById(R.id.apekit_card);
        reclo_card = (android.support.v7.widget.CardView) view.findViewById(R.id.reclo_card);
        csrf_card = (android.support.v7.widget.CardView) view.findViewById(R.id.csrf_card);
        sundial_card = (android.support.v7.widget.CardView) view.findViewById(R.id.sundial_card);
        hands_card = (android.support.v7.widget.CardView) view.findViewById(R.id.hands_card);
        ambios_card = (android.support.v7.widget.CardView) view.findViewById(R.id.ambios_card);


        spot_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(spot_url));
                startActivity(i);
            }
        });

        csrf_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(csrf_url));
                startActivity(i);
            }
        });

        apekit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(apekit_url));
                startActivity(i);
            }
        });

        reclo_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(reclo_url));
                startActivity(i);
            }
        });

        sundial_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(sundial_url));
                startActivity(i);
            }
        });

        hands_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(hands_url));
                startActivity(i);
            }
        });

        ambios_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ambios_url));
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        // Apply any required UI change now that the Fragment is visible.
    }


}