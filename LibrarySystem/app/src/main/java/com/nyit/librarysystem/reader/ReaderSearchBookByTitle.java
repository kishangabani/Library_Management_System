package com.nyit.librarysystem.reader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.R;

import java.io.IOException;

/**
 * Created by Pratik on 5/5/2017.
 */

public class ReaderSearchBookByTitle extends Activity {
    private DataBaseHelper db;
    TextView textView;
    EditText editText;
    Button submit;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader_searchbytitle);

        textView = (TextView) findViewById(R.id.tvSbbytitle);
        editText = (EditText) findViewById(R.id.edtsbBytitleed);
        submit = (Button) findViewById(R.id.btnsbBYtitlesubmit);
        try {
            db = new DataBaseHelper(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String id=editText.getText().toString();
                String title=db.getBybookTitle(id);

                if (true)
                {
                    textView.setText(title);
                    Toast.makeText(getApplicationContext(),"success  " + title,Toast.LENGTH_SHORT).show();
                }
                else
                {

                    textView.setText(title);
                    // textView.setText("book not found");
                    Toast.makeText(getApplicationContext(),"not success",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
    }
