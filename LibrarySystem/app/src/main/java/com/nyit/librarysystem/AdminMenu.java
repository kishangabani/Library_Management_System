package com.nyit.librarysystem;

import com.nyit.librarysystem.admin.AdminAddBook;
import com.nyit.librarysystem.admin.AdminAddUser;
import com.nyit.librarysystem.admin.AdminBranchInfo;
import com.nyit.librarysystem.admin.AdminFineAverage;
import com.nyit.librarysystem.admin.AdminFreqBooks;
import com.nyit.librarysystem.admin.AdminFreqBorrowers;
import com.nyit.librarysystem.admin.AdminSearchBook;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminMenu extends Activity implements OnClickListener{
	
	private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_menu);
		setTitle("Admin Menu");

		initUI();
		setListener();
		
	}

	private void setListener() {
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);

	}

	private void initUI() {
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		btn5 = (Button) findViewById(R.id.button5);
		btn6 = (Button) findViewById(R.id.button6);
		btn7 = (Button) findViewById(R.id.button7);
		btn8 = (Button) findViewById(R.id.button8);
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

	@Override
	public void onClick(View v)
	{
		
		switch (v.getId())
		{
		case R.id.button1:
				Intent i1 = new Intent(AdminMenu.this,AdminAddBook.class);
				startActivity(i1);
			break;

			case R.id.button2:
			    Intent i2=new Intent (AdminMenu.this, AdminSearchBook.class);
			    startActivity(i2);
			    break;

		case R.id.button3:
			Intent i3 = new Intent(AdminMenu.this,AdminAddUser.class);
			startActivity(i3);
		break;

		case R.id.button4:
			Intent i4 = new Intent(AdminMenu.this,AdminBranchInfo.class);
			startActivity(i4);
		break;

		case R.id.button5:
			Intent i5 = new Intent(AdminMenu.this,AdminFreqBorrowers.class);
			startActivity(i5);
		break;
		
		case R.id.button6:
			Intent i6 = new Intent(AdminMenu.this,AdminFreqBooks.class);
			startActivity(i6);
		break;
		
		case R.id.button7:
			Intent i7 = new Intent(AdminMenu.this,AdminFineAverage.class);
			startActivity(i7);
		break;

			case R.id.button8:
				Intent i8 = new Intent(AdminMenu.this,MainActivity.class);
				startActivity(i8);
				finish();
				break;


		default:
			break;
		}
	}

}
