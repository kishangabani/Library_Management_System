package com.nyit.librarysystem;

import java.io.IOException;

import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.reader.ReaderMenu;

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

public class ReaderLogin extends Activity {
	public static int READER_ID;
	private EditText edtID;
	private Button btnLogin;
	private DataBaseHelper db;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_readerlogin);
		edtID = (EditText) findViewById(R.id.edtRID);
		btnLogin = (Button) findViewById(R.id.btnRLogin);
		
		try {
			db = new DataBaseHelper(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int id = Integer.parseInt(edtID.getText().toString());
				int readerID = db.checkReaderLogin(id);

				if (readerID>0)
				{
					READER_ID =  readerID;
					Intent i = new Intent(ReaderLogin.this,ReaderMenu.class);
					startActivity(i);
				}
				else
				{
					Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	public int getReaderid()
	{
		return READER_ID;
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