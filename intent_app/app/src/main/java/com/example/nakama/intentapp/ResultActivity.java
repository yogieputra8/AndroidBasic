package com.example.nakama.intentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView txtResult;
    public static String FIRST_NAME = "first_name", LAST_NAME = "last_name", BIRTH_PLACE = "birth_place", GENDER = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = (TextView)findViewById(R.id.txt_hasil);
        String fname = getIntent().getStringExtra(FIRST_NAME);
        String lname = getIntent().getStringExtra(LAST_NAME);
        String bplace = getIntent().getStringExtra(BIRTH_PLACE);
        String gnder = getIntent().getStringExtra(GENDER);
        String dataResult = "Hi, my name is " + fname + " " + lname + ". I am born in " + bplace + ". I am " + gnder + ".";
        txtResult.setText(dataResult);
    }
}
