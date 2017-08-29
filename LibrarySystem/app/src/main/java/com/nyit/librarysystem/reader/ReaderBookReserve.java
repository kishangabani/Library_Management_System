package com.nyit.librarysystem.reader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nyit.helper.DataBaseHelper;
import com.nyit.librarysystem.R;

/**
 * Created by Pratik on 5/6/2017.
 */

public class ReaderBookReserve extends Activity {

    private DataBaseHelper db;
    TextView tv;
    Button btn;
    EditText ed;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader_bookreserve);
        setTitle("Reader Menu");

        tv = (TextView) findViewById(R.id.tvreserve);
        ed = (EditText) findViewById(R.id.edtreserve);
        btn = (Button) findViewById(R.id.btnreserve);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bookid=ed.getText().toString();
                String result="";

            }
        });




    }
}
