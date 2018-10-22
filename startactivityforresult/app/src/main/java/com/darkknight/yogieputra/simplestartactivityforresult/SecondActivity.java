package com.darkknight.yogieputra.simplestartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    public static final int REQUEST_GET_DATA = 5;
    public static final String KEY_MESSAGE = "message";
    EditText edtInput1;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        edtInput1 = (EditText) findViewById(R.id.edt_txt_1);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputFromUser = edtInput1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(KEY_MESSAGE, inputFromUser);
                setResult(REQUEST_GET_DATA, intent);
                finish();
            }
        });
    }
}
