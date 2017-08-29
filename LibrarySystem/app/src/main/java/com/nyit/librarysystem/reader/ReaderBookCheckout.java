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

/**
 * Created by Pratik on 5/6/2017.
 */

public class ReaderBookCheckout extends Activity {

    TextView tv;
    EditText ed;
    Button btn;
    private DataBaseHelper db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader_bookcheckout);

        tv = (TextView) findViewById(R.id.tvbookcheckout);
        ed= (EditText) findViewById(R.id.edtbookcheckout);
        btn= (Button) findViewById(R.id.btnbookcheckout);



        try {
            db = new DataBaseHelper(this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bookid=ed.getText().toString();
                String result=db.bookCheckOut(bookid);
                tv.setText(result);

            }
        });



    }
}
