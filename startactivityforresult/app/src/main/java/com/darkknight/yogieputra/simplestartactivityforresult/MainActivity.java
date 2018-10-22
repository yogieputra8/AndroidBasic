package com.darkknight.yogieputra.simplestartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btnGotoSecondPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tv_result);
        btnGotoSecondPage = (Button) findViewById(R.id.btn_to_second_page);
        btnGotoSecondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, SecondActivity.REQUEST_GET_DATA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SecondActivity.REQUEST_GET_DATA){
            String message = data.getStringExtra(SecondActivity.KEY_MESSAGE);
            tvResult.setText(message);
        }
    }
}
