package com.example.nakama.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText firstName, lastName, birthPlace, gender;
    private Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText)findViewById(R.id.edt_first_name);
        lastName = (EditText)findViewById(R.id.edt_last_name);
        birthPlace = (EditText)findViewById(R.id.edt_birth_place);
        gender = (EditText)findViewById(R.id.edt_gender);
        btnProcess = (Button)findViewById(R.id.btn_process);
        btnProcess.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_process){
            String fname = firstName.getText().toString().trim();
            String lname = lastName.getText().toString().trim();
            String bplace = birthPlace.getText().toString().trim();
            String gnder = gender.getText().toString().trim();
            boolean isEmptyField = false;

            if (TextUtils.isEmpty(fname)){
                isEmptyField = true;
                firstName.setError("This field can not be empty!");
            }

            if (TextUtils.isEmpty(lname)){
                isEmptyField = true;
                lastName.setError("This field can not be empty!");
            }

            if (TextUtils.isEmpty(bplace)){
                isEmptyField = true;
                birthPlace.setError("This field can not be empty!");
            }

            if (TextUtils.isEmpty(gnder)){
                isEmptyField = true;
                gender.setError("This field can not be empty!");
            }

            if (!isEmptyField){
                Intent moveIntentWithData = new Intent(MainActivity.this, ResultActivity.class);
                moveIntentWithData.putExtra(ResultActivity.FIRST_NAME, fname);
                moveIntentWithData.putExtra(ResultActivity.LAST_NAME, lname);
                moveIntentWithData.putExtra(ResultActivity.BIRTH_PLACE, bplace);
                moveIntentWithData.putExtra(ResultActivity.GENDER, gnder);
                startActivity(moveIntentWithData);
            }
        }
    }
}
