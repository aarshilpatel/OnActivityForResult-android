package com.example.aarshil.onactivityforresult;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomToast_dialogActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCustomAlert,btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast_dialog);

       btnCustomAlert = (Button)findViewById(R.id.btn_Custom_Dialog);
       btnCustomAlert.setOnClickListener(this);

        btnToast = (Button)findViewById(R.id.btn_Custom_Toast);
        btnToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_Custom_Dialog:

                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.raw_dialog);
                dialog.show();

                break;

            case R.id.btn_Custom_Toast:

                LayoutInflater layoutInflater = getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.raw_toast,
                        null);

                Toast toast = new Toast(this);
                toast.setView(view1);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();

        }

    }
}
