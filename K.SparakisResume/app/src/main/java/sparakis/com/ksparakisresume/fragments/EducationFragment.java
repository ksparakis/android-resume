package sparakis.com.ksparakisresume.fragments;

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
public class EducationFragment extends Fragment {


    ImageView educover;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_edu, container, false); //pass the correct layout name for the fragment
        educover = (ImageView) view.findViewById(R.id.edu_cover);
        Picasso.with(getActivity().getApplicationContext()).load(R.drawable.bu).into(educover);
        educover.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
    }

}