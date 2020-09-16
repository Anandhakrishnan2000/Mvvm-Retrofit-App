package com.krizz.mvvmdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.krizz.mvvmdemo.R;
import com.krizz.mvvmdemo.model.DataModel;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private String TAG = DataAdapter.class.getSimpleName();
    private Context context;
    public ArrayList<DataModel> dataArrayList;

    public DataAdapter(Context context,ArrayList<DataModel> array){
        this.context = context;
        this.dataArrayList = array;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_row_data,parent,false);

        for (int i=0;i<dataArrayList.size();i++){
            Log.d(TAG,"DataArray elements: "+dataArrayList.get(i).getFirst_name()+dataArrayList.get(i).getEmail());
        }

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        DataModel data = dataArrayList.get(position);
        holder.nameView.setText(data.getFirst_name()+" "+data.getLast_name());
        holder.emailView.setText(data.getEmail());
        Glide.with(context)
                .load(data.getAvatar())
                .into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView avatar;
        private TextView nameView;
        private TextView emailView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            nameView = itemView.findViewById(R.id.nameview);
            emailView = itemView.findViewById(R.id.emailview);
        }
    }
}
