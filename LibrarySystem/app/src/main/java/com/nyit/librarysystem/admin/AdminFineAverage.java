package com.nyit.librarysystem.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class AdminFineAverage extends Activity{


	private DataBaseHelper db;
	private AutoCompleteTextView actReaderName;
	private Button btnFineAvg;
	private TextView tvAvgFine;
	private ArrayList<String> allreaderNameList;
	private ArrayAdapter<String> arrayAdapter;
	String name;
	int readerID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_fineavg);

		actReaderName = (AutoCompleteTextView) findViewById(R.id.actReaderName);
		btnFineAvg = (Button) findViewById(R.id.btnFineAvg);
		tvAvgFine = (TextView) findViewById(R.id.tvAvgFine);
		
		try {
			db = new DataBaseHelper(this);
			allreaderNameList = db.getAllReaderList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < allreaderNameList.size(); i++) {
			Log.e("Name", allreaderNameList.get(i));
		}

		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allreaderNameList);

		actReaderName.setAdapter(arrayAdapter);

		actReaderName.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				 name = arrayAdapter.getItem(position).toString();
				 readerID = db.getReaderID(name);
				hideSoftKeyboard();
			}

			private void hideSoftKeyboard(){
				InputMethodManager inputMethodManager = (InputMethodManager)  getSystemService(INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
			}
		});

		btnFineAvg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<Float> fineList = new ArrayList<Float>();
				
				fineList = db.getReaderFine(readerID);
				Float totalFine = (float) 0;
				Float avgFine = (float) 0;
				for (int i = 0; i < fineList.size(); i++) {
					totalFine = totalFine +fineList.get(i);
				}
				if (fineList.size()>0) {
					avgFine = totalFine/fineList.size();
					tvAvgFine.setText(avgFine+"");
				}else {
					tvAvgFine.setText(avgFine+"");
				}
			}
		});

	}
}
