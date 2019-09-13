package com.rendomapp.rendomapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Dell on 21/05/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private ArrayList<Model> arrayList;
    Context context;
    boolean multiselection = true;

    public MyAdapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyHolder holder, int position) {

        final Model model = arrayList.get(position);
        holder.btn.setText(model.getName());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
                model.setSelected(!model.isSelected());
                holder.btn.setBackgroundColor(model.isSelected() ? Color.CYAN : Color.WHITE);
                if (multiselection) {
                    if (model.isSelected()) {
                        Log.e("text", "" + model.getName());
                        list.add(model.getName());
                    } else {
                        list.remove(model.getName());
                    }
                    model.setArrayList(list);
                    Log.e("size", "" + model.getArrayList().size());
                }else{
                    multiselection = false;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private Button btn;

        public MyHolder(View itemView) {
            super(itemView);

            btn = itemView.findViewById(R.id.btn);
        }
    }
}
