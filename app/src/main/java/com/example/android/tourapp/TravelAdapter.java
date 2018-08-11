package com.example.android.tourapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TravelAdapter extends ArrayAdapter<Travel> {

    private int mColorResourceId;


    /**
     * Create a new {@link TravelAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param sec_one_cat_one_items is the list of {@link Travel}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of sec_one_cat_one_items
     */
    public TravelAdapter(Context context, ArrayList<Travel> sec_one_cat_one_items, int colorResourceId) {
        super(context, 0, sec_one_cat_one_items);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cpromos_travel_list_item, parent, false);
        }
        Travel currentWord = getItem(position);

        TextView secOneCatOnePosTxtV1 = (TextView) listItemView.findViewById(R.id.sec_one_cat_one_pos1);
        secOneCatOnePosTxtV1.setText(currentWord.getSecOneCatOnePos1());
        TextView secOneCatOnePosTxtV2 = (TextView) listItemView.findViewById(R.id.sec_one_cat_one_pos2);
        secOneCatOnePosTxtV2.setText(currentWord.getSecOneCatOnePos2());
        TextView secOneCatOnePosTxtV3 = (TextView) listItemView.findViewById(R.id.sec_one_cat_one_pos3);
        secOneCatOnePosTxtV3.setText(currentWord.getSecOneCatOnePos3());
        TextView secOneCatOnePosTxtV4 = (TextView) listItemView.findViewById(R.id.sec_one_cat_one_pos4);
        secOneCatOnePosTxtV4.setText(currentWord.getSecOneCatOnePos4());
        TextView secOneCatOnePosTxtV5 = (TextView) listItemView.findViewById(R.id.sec_one_cat_one_pos5);
        secOneCatOnePosTxtV5.setText(currentWord.getSecOneCatOnePos5());
        TextView secOneCatOnePosTxtV6 = (TextView) listItemView.findViewById(R.id.sec_one_cat_one_pos6);
        secOneCatOnePosTxtV6.setText(currentWord.getSecOneCatOnePos6());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}