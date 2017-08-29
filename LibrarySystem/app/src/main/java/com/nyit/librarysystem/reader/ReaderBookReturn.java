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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pratik on 5/4/2017.
 */

public class ReaderBookReturn extends Activity{

    EditText bookretuenid;
    Button submitreturn;
    DataBaseHelper db;
    TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader_bookreturn);
        bookretuenid= (EditText) findViewById(R.id.edtreturnbookID);
        submitreturn= (Button) findViewById(R.id.btnReturnSubmit);
        tv= (TextView) findViewById(R.id.tvvvvvvvvvvvv);
        int fine=0;


        try {
            db = new DataBaseHelper(this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        submitreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
                Date date=new Date();
                String curdate=dateFormat.format(date);
                String bookid=bookretuenid.getText().toString();
                String result=db.returnBook(bookid);
                tv.setText(result);
                System.out.println(result);
                /*if()
                {
                    Toast.makeText(getApplicationContext(),"Book Return Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Book Return Not Successful",Toast.LENGTH_SHORT).show();
                }*/



            }
        });






    }
}
