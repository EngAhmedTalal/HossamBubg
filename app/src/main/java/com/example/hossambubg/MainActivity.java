package com.example.hossambubg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Type;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Spinner sp ;
    private EditText edit ;
    private DatePickerDialog picker ;
    private String[]  list=
    {
          "Unknown" ,
          "Female" ,
          "Male"
    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp =findViewById(R.id.spinner_ID) ;
        edit = findViewById(R.id.datePicker) ;
        edit.setInputType(InputType.TYPE_NULL);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cld = Calendar.getInstance() ;
                int day = cld.get(Calendar.DAY_OF_MONTH) ;
                int month = cld.get(Calendar.MONTH) ;
                int year = cld.get(Calendar.YEAR) ;

                //picker
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edit.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplication() , R.layout.spinner_item , list) ;
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        sp.setAdapter(arrayAdapter);
    }

    public void loginPage(View view) {
        startActivity(new Intent(MainActivity.this , LoginActivity.class));
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
