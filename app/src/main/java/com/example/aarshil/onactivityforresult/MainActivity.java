package com.example.aarshil.onactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = (Button)findViewById(R.id.btn_next);
        tvData = (TextView)findViewById(R.id.tv_data);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,ResultActivity.class);
                startActivityForResult(i,111);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==111) {

            String strFn = data.getStringExtra("FN_KEY");
            String strLn = data.getStringExtra("LN_KEY");
            tvData.setText(strFn +" "+strLn);
            tvData.setVisibility(View.VISIBLE);


        }


    }
}
