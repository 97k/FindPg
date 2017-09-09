package com.example.findingpg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * Created by aadi on 4/9/17.
 */

public class PgAdapter extends ArrayAdapter {

    public static final String TAG = PgAdapter.class.getSimpleName();

    private ArrayList<String> data;

    // For the string clicked by user
    private String userchoice ;

    public PgAdapter(Context context, ArrayList<String> data){
        super(context, android.R.layout.simple_list_item_1, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_item, parent, false);

        }

        TextView textView = (TextView)listItemView.findViewById(R.id.spinner_item_tv);
        String title = data.get(position);
        Log.i(TAG, "Value of string is this : " + title+ "at position " + position);
        textView.setText(title);
        setstring(title);

        return listItemView;

    }

    public void setstring(String clickedString){
        userchoice = clickedString;
        Log.e(TAG, "User clicked on this " + userchoice + " and this will be returned");
    }
    public String getString(){
        return userchoice;
    }
}