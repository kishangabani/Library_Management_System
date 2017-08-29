package com.nyit.helper;

import java.util.ArrayList;

import com.nyit.librarysystem.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BranchAdapter extends ArrayAdapter<Branch> {
    public BranchAdapter(Context context, ArrayList<Branch> users) {
       super(context, 0, users);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
       Branch branch = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_branch, parent, false);
       }
       // Lookup view for data population
       TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
       TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);
       // Populate the data into the template view using the data object
       tvName.setText(branch.getName());
       tvLocation.setText(branch.getLocation());
       // Return the completed view to render on screen
       return convertView;
   }
}
