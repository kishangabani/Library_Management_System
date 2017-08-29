package com.nyit.librarysystem.reader;

import java.io.IOException;

import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ReaderSearchBook extends Activity implements OnClickListener{

	private DataBaseHelper db;
	private Button btn1,btn2,btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reader_searchbook);
		
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		final int temp=42520;
		final String booktempisbn="001007";
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
		try {
			db = new DataBaseHelper(this);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}







	@Override
	public void onClick(View v) {
		
		int position;
		switch (v.getId()) {
		case R.id.button1:
			position = 0;
			Intent i = new Intent(ReaderSearchBook.this,ReaderSearchbyBookId.class);
			//i.putExtra("Position", position);
			startActivity(i);
			break;
		case R.id.button2:
			position = 1;
			Intent i1 = new Intent(ReaderSearchBook.this,ReaderSearchBookByTitle.class);
			//i1.putExtra("Position", position);
			startActivity(i1);
			break;
		case R.id.button3:
			position = 2;
			Intent i2= new Intent(ReaderSearchBook.this,ReaderSearchBookByPublisher.class);
			//i2.putExtra("Position", position);
			startActivity(i2);
			break;

		default:
			break;
		}
		
	}
}
