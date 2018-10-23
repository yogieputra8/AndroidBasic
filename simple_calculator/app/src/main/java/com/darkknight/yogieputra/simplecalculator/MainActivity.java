package com.darkknight.yogieputra.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;
    private static String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHeight = (EditText)findViewById(R.id.edt_height);
        edtLength = (EditText)findViewById(R.id.edt_length);
        edtWidth = (EditText)findViewById(R.id.edt_width);
        tvResult = (TextView)findViewById(R.id.txt_hasil);
        btnCalculate = (Button)findViewById(R.id.btn_hitung);
        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            tvResult.setText(savedInstanceState.getString(STATE_HASIL));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, tvResult.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitung){
            String height = edtHeight.getText().toString().trim();
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            boolean isEmptyField = false;

            if (TextUtils.isEmpty(height)){
                isEmptyField = true;
                edtHeight.setError("This field can not be empty!");
            }

            if (TextUtils.isEmpty(length)){
                isEmptyField = true;
                edtLength.setError("This field can not be empty!");
            }

            if (TextUtils.isEmpty(width)){
                isEmptyField = true;
                edtWidth.setError("This field can not be empty!");
            }

            if (!isEmptyField){
                Double h = Double.parseDouble(height);
                Double l = Double.parseDouble(length);
                Double w = Double.parseDouble(width);
                Double result = h * w * l;
                tvResult.setText(String.valueOf(result));
            }
        }
    }
}
