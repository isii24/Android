package com.example.isi24.taskmanager;


import android.app.DatePickerDialog;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class NoviZadatak extends AppCompatActivity {
    Button b1, b2, b3, b4, b5,butdate;
    EditText et1,et2;

    protected DatePickerDialog.OnDateSetListener m_datep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novi_zadatak);

        final Calendar cal= Calendar.getInstance();
        b1 = (Button) findViewById(R.id.but1);
        b2 = (Button) findViewById(R.id.but2);
        b3 = (Button) findViewById(R.id.but3);
        b4 = (Button) findViewById(R.id.but4);
        b5 = (Button) findViewById(R.id.but5);
        et1= (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        butdate = (Button) findViewById(R.id.picdate);

        b4.setEnabled(false);

        butdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datep= new DatePickerDialog(NoviZadatak.this,m_datep,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
                datep.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
                datep.show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setClickable(false);
                b3.setClickable(false);
                b4.setEnabled(true);
                b2.getBackground().setAlpha(64);
                b3.getBackground().setAlpha(64);
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setClickable(false);
                b3.setClickable(false);
                b4.setEnabled(true);
                b1.getBackground().setAlpha(64);
                b3.getBackground().setAlpha(64);
               // b1.setBackgroundColor(Color.TRANSPARENT);
                // b3.setBackgroundColor(Color.TRANSPARENT);
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setClickable(false);
                b1.setClickable(false);
                b4.setEnabled(true);
                b2.getBackground().setAlpha(64);
                b1.getBackground().setAlpha(64);
            }

        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().equals("")){
                    et1.setError("Unesite podatke!");
                }else if(et2.getText().toString().equals("")){
                    et2.setError("Unesite podatke!");
                }else {
                    Intent intent = new Intent(NoviZadatak.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NoviZadatak.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
