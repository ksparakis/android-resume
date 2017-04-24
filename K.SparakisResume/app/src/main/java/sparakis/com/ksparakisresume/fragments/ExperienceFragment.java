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
public class ExperienceFragment extends Fragment {


    ImageView lexumo_iv;
    ImageView cipher_iv;
    ImageView carb_iv;
    android.support.v7.widget.CardView cipher_card;
    android.support.v7.widget.CardView carb_card;
    android.support.v7.widget.CardView lexumo_card;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_exp, container, false); //pass the correct layout name for the fragment
        lexumo_iv = (ImageView) view.findViewById(R.id.lexumo_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.lexumo).into(lexumo_iv);
        cipher_iv = (ImageView) view.findViewById(R.id.cipher_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.cipher).into(cipher_iv);
        carb_iv = (ImageView) view.findViewById(R.id.carbonite_iv);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.carb).into(carb_iv);

        carb_card = (android.support.v7.widget.CardView) view.findViewById(R.id.carb_card);
        cipher_card = (android.support.v7.widget.CardView) view.findViewById(R.id.cipher_card);
        lexumo_card = (android.support.v7.widget.CardView) view.findViewById(R.id.lexumo_card);

        // On click open specified Link
        carb_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.carbonite.com/en/cloud-backup/business/resources/carbonite-blog/five-questions-with-carbonite-engineering-intern-konstantino-sparakis/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        // On click open specified Link
        lexumo_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://lexumo.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        // On click open specified Link
        cipher_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://cipherzero.io";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

    }


}