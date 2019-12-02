package com.example.aarshil.onactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class    RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String strLang[] = {"Android","Java","IOS","PHP",".net","C","C++"};
    int imgData[] = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    ArrayList<DataModel> dataModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView =(RecyclerView)findViewById(R.id.recycler);

        dataModelArrayList = new ArrayList<DataModel>();
        for (int i =0; strLang.length>i; i++)
        {
            DataModel dataModel = new DataModel(strLang[i],imgData[i]);
            dataModelArrayList.add(dataModel);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this,dataModelArrayList);
        recyclerView.setAdapter(myRecyclerAdapter);
    }
}
