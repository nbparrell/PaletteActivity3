package edu.temple.paletteactivity3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import static android.graphics.Color.parseColor;

/**
 * Created by t410 on 10/19/2017.
 */

public class ColorAdapter extends ArrayAdapter {
    private String[]dataSet;
    private Context mContext;
    private GridView grdColor;
    public ColorAdapter(String[] data, Context context, GridView grd){
        super(context, android.R.layout.simple_spinner_dropdown_item, data);
        this.grdColor = grd;
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public View getDropDownView(int position, View currentView, ViewGroup parent){
        int x = grdColor.getCount();
        int i;
        int color;
        View row = null;
        row = super.getDropDownView(position, currentView, parent);
        if(dataSet[position].equals("BLUE") || dataSet[position].equals("AZUL")){
            color = parseColor("#0000FF");
        }else if (dataSet[position].equals("CYAN") || dataSet[position].equals("CIAN")) {
            color = parseColor("#00FFFF");
        }else if (dataSet[position].equals("DKGRAY") || dataSet[position].equals("GRIS OSCURO")) {
            color = parseColor("#A9A9A9");
        }else if (dataSet[position].equals("GREEN") || dataSet[position].equals("VERDE")) {
            color = parseColor("#008000");
        }else if (dataSet[position].equals("MAGENTA")) {
            color = parseColor("#FF00FF");
        }else{
            color = 0;
        }
        row.setBackgroundColor(color);
        //Object spinnerItem = spnColor.getItemAtPosition(0);
        return row;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View mainRow;
        mainRow = super.getView(position, convertView, parent);
        int color;
        if(dataSet[position].equals("BLUE") || dataSet[position].equals("AZUL")){
            color = parseColor("#0000FF");
        }else if (dataSet[position].equals("CYAN") || dataSet[position].equals("CIAN")) {
            color = parseColor("#00FFFF");
        }else if (dataSet[position].equals("DKGRAY") || dataSet[position].equals("GRIS OSCURO")) {
            color = parseColor("#A9A9A9");
        }else if (dataSet[position].equals("GREEN") || dataSet[position].equals("VERDE")) {
            color = parseColor("#008000");
        }else if (dataSet[position].equals("MAGENTA")) {
            color = parseColor("#FF00FF");
        }else{
            color = 0;
        }
        mainRow.setBackgroundColor(color);
        return mainRow;

    }

}
