package com.darkknight.yogieputra.simplestartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    public static final int GET_DATA_FROM_SECOND_ACTIVITY = 5;
    public static final String KEY_MESSAGE = "MESSAGE";
    EditText editText1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        editText1 = (EditText) findViewById(R.id.editText1);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(KEY_MESSAGE, message);
                setResult(GET_DATA_FROM_SECOND_ACTIVITY, intent);
                finish();
            }
        });
    }
}
