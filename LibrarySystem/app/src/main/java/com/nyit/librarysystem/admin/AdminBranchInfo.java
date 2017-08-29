package com.nyit.librarysystem.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.nyit.helper.Branch;
import com.nyit.helper.BranchAdapter;
import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class AdminBranchInfo extends Activity{
	
	private DataBaseHelper db;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_branchinfo);
		
		listView = (ListView) findViewById(R.id.listBranch);
		
		try {
			db = new DataBaseHelper(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Branch> branchList = new ArrayList<Branch>();
		branchList= db.getAllBranchList();
		// Create the adapter to convert the array to views
		BranchAdapter adapter = new BranchAdapter(this, branchList);
		// Attach the adapter to a ListView
		listView.setAdapter(adapter);

		
	}
}
