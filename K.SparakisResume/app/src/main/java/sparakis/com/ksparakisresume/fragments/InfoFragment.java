package sparakis.com.ksparakisresume.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sparakis.com.ksparakisresume.R;

/**
 * Created by ksparakis on 4/20/16.
 */
public class InfoFragment extends Fragment {

    RecyclerView expRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view =  lf.inflate(R.layout.fragment_exp, container, false); //pass the correct layout name for the fragment
       // expRV = (RecyclerView) view.findViewById(R.id.educationRecyclerView);

        //populateData();
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        //populateData();
        // Apply any required UI change now that the Fragment is visible.
    }

    private void populateData() {
        /*
        dataRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        State_Machine ss = State_Machine.findById(State_Machine.class, 1);
        String selVil = ss.selected_village+"";
        List<Device_Data> pp = Device_Data.find(Device_Data.class, "villageId = ?", selVil);
        DataAdapter pca = new DataAdapter(pp);
        dataRV.setAdapter(pca);
        */
    }
}