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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminAddBook extends Activity{

	private LinearLayout llRadio,llExisting,llnewBook,llCommon;
	private RadioGroup radioAddBookGroup;
	private RadioButton radioAddBookButton;
	private Button btnSubmit,btnLLExisting;
	private Spinner spISBN,spBranch,spPosition,spPublisher;
	private EditText edtISBN,edtTitle,edtAuthor,edtPubDate;
	private DataBaseHelper db;
	int selectedId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_addbook);

		try {
			db = new DataBaseHelper(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setListener();

		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				selectedId = radioAddBookGroup.getCheckedRadioButtonId();
				radioAddBookButton = (RadioButton) findViewById(selectedId);
				Toast.makeText(AdminAddBook.this,radioAddBookButton.getText(), Toast.LENGTH_SHORT).show();

				llRadio.setVisibility(View.GONE);

				if (selectedId == R.id.radioExisting) {
					ArrayList<String> isbnList = new ArrayList<String>();
					isbnList = db.getAllISBN();
					ArrayAdapter<String> isbnAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, isbnList);
					spISBN.setAdapter(isbnAdapter);

					llExisting.setVisibility(View.VISIBLE);
					llCommon.setVisibility(View.VISIBLE);

				}

				if (selectedId == R.id.radioNew) {

					ArrayList<String> publisherList = new ArrayList<String>();
					publisherList = db.getAllPublisher();
					ArrayAdapter<String> publisherAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, publisherList);
					spPublisher.setAdapter(publisherAdapter);

					llnewBook.setVisibility(View.VISIBLE);
					llCommon.setVisibility(View.VISIBLE);
				}



				ArrayList<String> branchList = new ArrayList<String>();
				branchList = db.getAllBranch();
				ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, branchList);
				spBranch.setAdapter(branchAdapter);

				ArrayList<String> positionList = new ArrayList<String>();
				positionList = db.getAllPositioin();
				ArrayAdapter<String> positionAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, positionList);
				spPosition.setAdapter(positionAdapter);





				btnLLExisting.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						String selectedISBN = "",title="",authorName="",pubDate="",selectedPublisher;

						String selectedBranch = (String) spBranch.getSelectedItem();
						String selectedposition = (String) spPosition.getSelectedItem();

						if (selectedId == R.id.radioExisting) {
							selectedISBN = (String) spISBN.getSelectedItem();
							int bookID = db.getBookID(selectedISBN);
							int branchID = db.getBranchID(selectedBranch);

							Long insID = db.addBookLocation(bookID,branchID,selectedposition);
							if (insID>0) {
								Toast.makeText(getApplicationContext(), "Book "+bookID+" is added", Toast.LENGTH_LONG).show();
								//finish();
							}else {
								Toast.makeText(getApplicationContext(), "Book "+bookID+" is not added", Toast.LENGTH_LONG).show();
							}
						}

						else if (selectedId == R.id.radioNew) {
							selectedISBN = edtISBN.getText().toString();
							title = edtTitle.getText().toString();
							selectedPublisher = (String) spPublisher.getSelectedItem();
							authorName = edtAuthor.getText().toString();
							pubDate = edtPubDate.getText().toString();
							
							Long insIDAu = db.addAuthor(authorName);
							Long insIDBo = db.addBook(selectedISBN);
							
							int publisherID = db.getPublisherID(selectedPublisher);
							int authorID = db.getAuthorID(authorName);
							
							Long insIDbi = db.addBookInfo(selectedISBN,title,publisherID,pubDate,authorID);
							
							Log.e("Author Book BookInfo", insIDAu+" "+insIDBo+" "+insIDbi);
							if (insIDbi>0) {
								Toast.makeText(getApplicationContext(), "Book  is added", Toast.LENGTH_LONG).show();
								//finish();
							}else {
								Toast.makeText(getApplicationContext(), "Book  is not added", Toast.LENGTH_LONG).show();
							}
							System.out.println(insIDbi);
							//author,book,bookinfo
						}
						else
						{

						}
						

					}
				});

			}

		});

	}

	private void setListener() {
		radioAddBookGroup = (RadioGroup) findViewById(R.id.radioAddBook);
		btnSubmit = (Button) findViewById(R.id.btnRadio);
		llRadio = (LinearLayout) findViewById(R.id.llRadio);
		llExisting = (LinearLayout) findViewById(R.id.llExistingBook);
		llCommon  = (LinearLayout) findViewById(R.id.llCommon);
		llnewBook  = (LinearLayout) findViewById(R.id.llnewBook);
		spISBN = (Spinner) findViewById(R.id.spISBN);
		spBranch = (Spinner) findViewById(R.id.spBranch);
		spPosition = (Spinner) findViewById(R.id.spPosition);
		spPublisher = (Spinner) findViewById(R.id.spPublisher);
		btnLLExisting = (Button) findViewById(R.id.btnLlExisting);

		edtISBN = (EditText) findViewById(R.id.edtISBN);
		edtTitle = (EditText) findViewById(R.id.edtTitle);
		edtAuthor = (EditText) findViewById(R.id.edtAuthor);
		edtPubDate = (EditText) findViewById(R.id.edtPubDate);
	}


}
