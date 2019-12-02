package com.example.aarshil.onactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    String strLang[]= {"Android","java","php",".net","C","C++","IOS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.raw_list,R.id.tv_data,strLang);
        listView.setAdapter(arrayAdapter);


    }
}
