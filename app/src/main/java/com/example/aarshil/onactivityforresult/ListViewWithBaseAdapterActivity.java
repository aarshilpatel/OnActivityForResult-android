package com.example.aarshil.onactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewWithBaseAdapterActivity extends AppCompatActivity {

   ListView listView;

   String strLang[] = {"Android", "IOS", "C", "C++",".net", "php", "java"};
   int imgData[] = {R.drawable.logo,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,
   R.drawable.logo,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.logo};

   ArrayList<DataModel>dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_base_adapter);

    listView = (ListView)findViewById(R.id.listview);

    dataModelArrayList = new ArrayList<DataModel>();
    for (int i = 0; i<strLang.length; i++)
    {
        DataModel dataModel = new DataModel(strLang[i], imgData[i]);
        dataModelArrayList.add(dataModel);
    }

    MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this,dataModelArrayList);
   listView.setAdapter(myBaseAdapter);
    }


}
