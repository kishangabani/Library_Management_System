package com.nyit.helper;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nyit.librarysystem.R;

import java.util.ArrayList;

/**
 * Created by Pratik on 5/5/2017.
 */

public class BookAdapter extends ArrayAdapter<Book>{
    public BookAdapter(@NonNull Context context, ArrayList<Book> books) {
        super(context,0, books);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }
        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvNamebook);
        TextView tvId = (TextView) convertView.findViewById(R.id.tvIdbook);
        // Populate the data into the template view using the data object
        tvTitle.setText(book.getTitle());
        tvId.setText(book.getBookId());
        // Return the completed view to render on screen
        return convertView;
    }
}
