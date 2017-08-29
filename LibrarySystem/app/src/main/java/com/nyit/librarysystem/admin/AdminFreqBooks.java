package com.nyit.librarysystem.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.nyit.helper.DataBaseHelper;
import com.nyit.helper.FrequentBorrowers;
import com.nyit.helper.FrequentBorrowersAdapter;
import com.nyit.librarysystem.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class AdminFreqBooks extends Activity{


	private DataBaseHelper db;
	private Spinner spBranch;
	private Button btnSubmit;
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_freqborrowers);

		spBranch = (Spinner) findViewById(R.id.spBranch);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		listview = (ListView) findViewById(R.id.listBorrower);

		//	SELECT title, count(*) AS count FROM borrow,book,bookinfo WHERE branchid = 5 and book.bookid = borrow.bookid and bookinfo.isbn = book.isbn GROUP BY title ORDER BY count DESC

		try {
			db = new DataBaseHelper(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> branchList = new ArrayList<String>();
		branchList = db.getAllBranch();
		ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, branchList);
		spBranch.setAdapter(branchAdapter);

		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String selectedBranch = (String) spBranch.getSelectedItem();
				int branchID = db.getBranchID(selectedBranch);
				ArrayList<FrequentBorrowers> frBorrowers = new ArrayList<FrequentBorrowers>();
				frBorrowers = db.getFrequentBooks(branchID);
				FrequentBorrowersAdapter adapter= new FrequentBorrowersAdapter(getApplicationContext(), frBorrowers);
				// Attach the adapter to a ListView
				listview.setAdapter(adapter);

			}
		});
	}

}