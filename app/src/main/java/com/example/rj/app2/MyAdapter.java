package com.example.rj.app2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter {



    public MyAdapter(@NonNull Context context, String[] values) {
        super(context, R.layout.row_layout, values);
    }

    public MyAdapter(@NonNull Context context, List<Recipe> recipeList){
        super(context, R.layout.row_layout, recipeList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout, parent, false);

        String culteryO = (String) getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.txtViewInRecipe);

        theTextView.setText(culteryO);

        ImageView theImageView = (ImageView) theView.findViewById(R.id.image_figure );
        theImageView.setImageResource(R.drawable.figure);

        return theView;
    }
}
