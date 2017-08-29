package com.nyit.librarysystem.admin;

import java.io.IOException;

import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminAddUser extends Activity{

	private EditText edtName,edtAddress,edtZip,edtPhone;
	private Spinner spState;
	private Button btnAddUser;
	private DataBaseHelper db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_adduser);
		
		try {
			db = new DataBaseHelper(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initUI();
		
		btnAddUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = edtName.getText().toString();
				String address = edtAddress.getText().toString()+" "+spState.getSelectedItem()+" "+edtZip.getText().toString();
				String phone = edtPhone.getText().toString();
				
				Long insID = db.AddUser(name,address,phone);
				
				if (insID>0) {
					Toast.makeText(getApplicationContext(), "User "+insID+" Added", Toast.LENGTH_LONG).show();
					finish();
				}
				
			}
		});
	}
	private void initUI() {
		edtName = (EditText) findViewById(R.id.edtName);
		edtAddress = (EditText) findViewById(R.id.edtAddress);
		edtZip = (EditText) findViewById(R.id.edtZip);
		edtPhone = (EditText) findViewById(R.id.edtPhone);
		spState = (Spinner) findViewById(R.id.spState);
		btnAddUser = (Button) findViewById(R.id.btnAddUser);
	}
}
