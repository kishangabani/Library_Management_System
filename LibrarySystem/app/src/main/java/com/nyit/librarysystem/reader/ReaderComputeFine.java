package com.nyit.librarysystem.reader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.R;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Pratik on 5/6/2017.
 */

public class ReaderComputeFine extends Activity {
    TextView tv;
    EditText ed;
    Button btn;
    private DataBaseHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader_computefine);
        tv= (TextView) findViewById(R.id.tvcomputefine);
        btn= (Button) findViewById(R.id.btncomputefine);
        ed= (EditText) findViewById(R.id.edtcomputefine);


        try {
            db = new DataBaseHelper(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String result="";
            String bookid=ed.getText().toString();
                try {
                    result=db.getFine(bookid);
                } catch (Exception e) {
                    e.printStackTrace();
                    tv.setText(e.toString());
                }
                tv.setText("Your fine is $"+result);


            }
        });


    }
}
