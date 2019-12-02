package com.example.aarshil.onactivityforresult;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.Myviewholder> {
    Context context;
    ArrayList<DataModel>dataModelArrayList;

    public MyRecyclerAdapter(Context context, ArrayList<DataModel> dataModelArrayList) {
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }


    @NonNull
    @Override
    public MyRecyclerAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.raw_custom_list,parent,false);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.Myviewholder holder, int position) {
       holder.tvData.setText(dataModelArrayList.get(position).getStrLang());
       holder.imgData.setImageResource(dataModelArrayList.get(position).getImgData());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
       TextView tvData;
       ImageView imgData;

        public Myviewholder(View itemView) {
            super(itemView);

            tvData =(TextView) itemView.findViewById(R.id.tv_data);
            imgData = (ImageView) itemView.findViewById(R.id.img_data);
        }
    }
}
