package com.nyit.helper;

import java.util.ArrayList;

import com.nyit.librarysystem.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FrequentBorrowersAdapter extends ArrayAdapter<FrequentBorrowers> {
    public FrequentBorrowersAdapter(Context context, ArrayList<FrequentBorrowers> frequentBorrowers) {
       super(context, 0, frequentBorrowers);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
    	FrequentBorrowers frequentBorrowers = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_branch, parent, false);
       }
       // Lookup view for data population
       TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
       TextView tvCount = (TextView) convertView.findViewById(R.id.tvLocation);
       tvName.setText(frequentBorrowers.getName());
       tvCount.setText(frequentBorrowers.getCount()+"");
       return convertView;
   }
}
