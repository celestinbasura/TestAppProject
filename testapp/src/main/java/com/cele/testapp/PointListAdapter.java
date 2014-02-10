package com.cele.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.modbusclient.R;

import java.util.ArrayList;

/**
 * Created by Celestin on 30.01.14..
 */
public class PointListAdapter extends BaseAdapter {
    private ArrayList mListItems;
    private LayoutInflater mLayoutInflater;

    public PointListAdapter (Context context, ArrayList arrayList) {

        mListItems = arrayList;

        //get the layout inflater
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount () {

        return mListItems.size();
    }

    @Override

    public Object getItem (int i) {
        return null;
    }

    @Override
    //get the position id of the item from the list
    public long getItemId (int i) {
        return 0;
    }

    @Override

    public View getView (int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.list_item, null);
        }

        String stringItem = (String) mListItems.get(position);
        if (stringItem != null) {

            TextView itemName = (TextView) view.findViewById(R.id.list_item_text_view);

            if (itemName != null) {
                //set the item name on the TextView
                itemName.setText(stringItem);
            }
        }

        return view;

    }
}
