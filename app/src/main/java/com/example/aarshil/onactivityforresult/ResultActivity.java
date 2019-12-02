package com.example.aarshil.onactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    EditText edtFn,edtLn;
    Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        edtFn = (EditText) findViewById(R.id.edt_fn);
        edtLn = (EditText) findViewById(R.id.edt_ln);
        btnResult = (Button) findViewById(R.id.btn_result);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strfn = edtFn.getText().toString();
                String strln = edtLn.getText().toString();

                Intent i = new Intent();
                i.putExtra("FN_KEY",strfn);
                i.putExtra("LN_KEY",strln);
                setResult(111,i);
                finish();
            }
        });
    }
}
