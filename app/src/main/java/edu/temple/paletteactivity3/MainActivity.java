package edu.temple.paletteactivity3;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import static android.graphics.Color.parseColor;

public class MainActivity extends Activity implements PaletteFragment.mActivityInteraction{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        final String colors[] = res.getStringArray(R.array.colors_array);
        setContentView(R.layout.activity_main);
        PaletteFragment paletteFragment = PaletteFragment.newInstance(colors);
        //View b = this.getWindow().getDecorView();
        String win = this.findViewById(R.id.fragmentContainer).getTag().toString();
        //Toast.makeText(this.getBaseContext(), win, Toast.LENGTH_LONG).show();
        if(win.equals("Standard")) {
            Toast.makeText(this.getBaseContext(), win, Toast.LENGTH_LONG).show();
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer, paletteFragment).addToBackStack(null).commit();
        }else if(win.equals("Tablet")){
            Toast.makeText(this.getBaseContext(), win, Toast.LENGTH_LONG).show();
            getFragmentManager().beginTransaction().add(R.id.fragList, paletteFragment).addToBackStack(null).commit();
            CanvasFragment canvasFragment = CanvasFragment.newInstance(0);
            getFragmentManager().beginTransaction().add(R.id.fragDetail,canvasFragment).addToBackStack(null).commit();
        }else if(win.equals("Landscape")){
            Toast.makeText(this.getBaseContext(), win, Toast.LENGTH_LONG).show();
            getFragmentManager().beginTransaction().add(R.id.fragList, paletteFragment).commit();
            CanvasFragment canvasFragment = CanvasFragment.newInstance(0);
            getFragmentManager().beginTransaction().add(R.id.fragDetail,canvasFragment).commit();
        }
    }

    public void grdClick(int id) {
        String win = this.findViewById(R.id.fragmentContainer).getTag().toString();
        CanvasFragment canvasFragment = CanvasFragment.newInstance(id);
        if (win.equals("Standard")){
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer, canvasFragment).addToBackStack(null).commit();
        }else if(win.equals("Tablet")){
            getFragmentManager().beginTransaction().replace(R.id.fragDetail,canvasFragment).commit();
        }else if(win.equals("Landscape")){
            getFragmentManager().beginTransaction().replace(R.id.fragDetail,canvasFragment).commit();
        }
    }


    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
