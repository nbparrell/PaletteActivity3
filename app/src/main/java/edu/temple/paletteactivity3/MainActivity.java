package edu.temple.paletteactivity3;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import static android.graphics.Color.parseColor;

public class MainActivity extends Activity implements PaletteFragment.mActivityInteraction{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        final String colors[] = res.getStringArray(R.array.colors_array);
        setContentView(R.layout.activity_main);
        PaletteFragment paletteFragment = PaletteFragment.newInstance(colors);
        getFragmentManager().beginTransaction().add(R.id.fragmentContainer,paletteFragment).addToBackStack(null).commit();

    }

    public void grdClick(int id){
        CanvasFragment canvasFragment = CanvasFragment.newInstance(id);
        getFragmentManager().beginTransaction().add(R.id.fragmentContainer,canvasFragment).addToBackStack(null).commit();
    }


    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
