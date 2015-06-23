package com.example.faith.hairme;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.support.v7.app.ActionBarActivity;

import com.example.faith.hairme.R;

import java.util.ArrayList;


public class SalonPage extends Fragment {

    private GridView gridView;
    private GridViewAdapter gridAdapter;


    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "salon" + i));
        }
        return imageItems;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_salon_page,container,false);

        Log.d("ERROR", "loaded the layout");

        gridView = (GridView)v.findViewById(R.id.gridview);
        Log.d("ERROR", "after gridview");
        /*gridAdapter = new GridViewAdapter(getApplicationContext(), R.layout.salon_grid_items_layout,getData());*/

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.d("ERROR", "before start activity");
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                Log.d("ERROR", "before  intent");
                //Create intent
                Intent intent = new Intent(getActivity().getApplicationContext(), SalonInfo.class);
                Log.d("ERROR", "after intent");
                /*intent.putExtra("title", item.getTitle());*/
                /*intent.putExtra("image", item.getImage());*/

                //Start details activity
               getActivity().startActivity(intent);
                Log.d("ERROR", "starting activity");

            }
        });




        gridAdapter = new GridViewAdapter(getActivity(), R.layout.salon_grid_items_layout,getData());

        Log.d("ERROR", "after grid adapter");
        gridView.setAdapter(gridAdapter);

        Log.d("ERROR", "BEfore return");
        return v;


    }




}