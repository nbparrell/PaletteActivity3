package edu.temple.paletteactivity3;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import static android.graphics.Color.parseColor;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String[] mParam1;


    mActivityInteraction clr;

    public PaletteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PaletteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaletteFragment newInstance(String[] param1) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getStringArray(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View pFragment = inflater.inflate(R.layout.fragment_palette, container, false);
        // Inflate the layout for this fragment

        GridView grd = (GridView) pFragment.findViewById(R.id.grdViewColorPalette);
        ColorAdapter adColor = new ColorAdapter(mParam1, getActivity(), grd);
        grd.setAdapter(adColor);

        grd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GridView grd = (GridView) parent.findViewById(R.id.grdViewColorPalette);
                int color;
                if (mParam1[position].equals("BLUE") || mParam1[position].equals("AZUL")) {
                    color = parseColor("#0000FF");
                } else if (mParam1[position].equals("CYAN") || mParam1[position].equals("CIAN")) {
                    color = parseColor("#00FFFF");
                } else if (mParam1[position].equals("DKGRAY") || mParam1[position].equals("GRIS OSCURO")) {
                    color = parseColor("#A9A9A9");
                } else if (mParam1[position].equals("GREEN") || mParam1[position].equals("VERDE")) {
                    color = parseColor("#008000");
                } else if (mParam1[position].equals("MAGENTA")) {
                    color = parseColor("#FF00FF");
                } else {
                    color = 0;
                }
                clr.grdClick(color);
            }
        });



        return pFragment;
    }


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof mActivityInteraction) {
            clr = (mActivityInteraction) context;
        }
    }

    public interface mActivityInteraction{
        public void grdClick(int c);
    }

    /*@Override
    public void onViewCreated(View view, Bundle savedInstaceState){
        GridView grd = (GridView) view.findViewById(R.id.grdViewColorPalette);
        ColorAdapter adColor = new ColorAdapter(mParam1, getActivity(), grd);
        grd.setAdapter(adColor);
    }*/
}
