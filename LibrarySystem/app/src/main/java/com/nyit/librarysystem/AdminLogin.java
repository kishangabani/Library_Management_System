package com.nyit.librarysystem;

import java.io.IOException;

import com.nyit.helper.DataBaseHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin  extends Activity {


	EditText edtID,edtPassword;
	Button btnALogin;
	DataBaseHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adminlogin);
		
		try {
			 db = new DataBaseHelper(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		edtID = (EditText) findViewById(R.id.edtID);
		edtPassword = (EditText) findViewById(R.id.editPassword);
		btnALogin = (Button) findViewById(R.id.btnALogin);
		
		btnALogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String id = edtID.getText().toString();
				String password = edtPassword.getText().toString();
				String pass = db.getPassword(id);
				
				if (password.equals(pass))
				{
					Intent i = new Intent(AdminLogin.this,AdminMenu.class);
					startActivity(i);
					
					Toast.makeText(getApplicationContext(), "Correct Password", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Wrong User ID and Password", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
