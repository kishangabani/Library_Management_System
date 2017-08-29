package com.nyit.librarysystem.admin;

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


public class AdminSearchBook extends Activity
{

    private DataBaseHelper db;
    Button searchButtonid,searchButtonisbn;
    TextView info;
    EditText searchISBN,searchID;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_searchbook);


        info= (TextView) findViewById(R.id.tvinfo);
        searchButtonid= (Button) findViewById(R.id.btnSearchButtonByid);
        searchButtonisbn= (Button) findViewById(R.id.btnSearchButtonByisbn);
        searchID= (EditText) findViewById(R.id.editSearchID);
        searchISBN= (EditText) findViewById(R.id.editSearchISBN);

        try
        {
             db = new DataBaseHelper(this);
        } catch (IOException e)
        {
             e.printStackTrace();
        }

        res="";




            searchButtonid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Id=searchID.getText().toString().trim();
                    res=db.getBybookId(Id);

                    info.setText(res);

                    Toast.makeText(getApplicationContext(), searchID.getText().toString(), Toast.LENGTH_SHORT).show();

                }
            });

        searchButtonisbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ISBN=searchISBN.getText().toString().trim();

                res=db.getByBookISBN(ISBN);

                info.setText(res);

                Toast.makeText(getApplicationContext(), searchISBN.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });








    }
}
