package com.example.aarshil.onactivityforresult;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSave,btnDisplay;
    EditText edtFn,edtLn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        btnSave = (Button)findViewById(R.id.btn_save);
        btnDisplay = (Button)findViewById(R.id.btn_display);

        edtFn = (EditText)findViewById(R.id.edt_fn);
        edtLn = (EditText)findViewById(R.id.edt_ln);

        btnSave.setOnClickListener(this);
        btnDisplay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){

            case R.id.btn_save:
                String strfn = edtFn.getText().toString();
                String strln = edtLn.getText().toString();

                sharedPreferences = getSharedPreferences("ABC",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FN_KEY",strfn);
                editor.putString("LN_KEY",strln);
                editor.commit();


                edtLn.setText("");
                edtFn.setText("");

                break;


            case R.id.btn_display:
                sharedPreferences = getSharedPreferences("ABC",MODE_PRIVATE);

                String fn = sharedPreferences.getString("FN_KEY","");
                String ln = sharedPreferences.getString("LN_KEY","");

                edtFn.setText(fn);
                edtLn.setText(ln);

                break;

        }




    }
}
