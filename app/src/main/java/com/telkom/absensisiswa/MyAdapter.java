package com.telkom.absensisiswa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.imageProfil);
        holder.recNama.setText(dataList.get(position).getDataNama());
        holder.recTanggaldanwaktu.setText(dataList.get(position).getDataTanggaldanwaktu());
        holder.recLokasi.setText(dataList.get(position).getDataLokasi());
        holder.recKeterangan.setText(dataList.get(position).getDataKeterangan());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Tanggal dan waktu", dataList.get(holder.getAdapterPosition()).getDataTanggaldanwaktu());
                intent.putExtra("Lokasi", dataList.get(holder.getAdapterPosition()).getDataLokasi());
                intent.putExtra("Keterangan", dataList.get(holder.getAdapterPosition()).getDataKeterangan());
                intent.putExtra("Nama", dataList.get(holder.getAdapterPosition()).getDataNama());
                intent.putExtra("Key", dataList.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClass> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView imageProfil;
    TextView recNama, recTanggaldanwaktu, recLokasi, recKeterangan;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageProfil = itemView.findViewById(R.id.imageProfile);
        recCard = itemView.findViewById(R.id.recCard);
        recNama = itemView.findViewById(R.id.recNama);
        recTanggaldanwaktu = itemView.findViewById(R.id.recTanggaldanwaktu);
        recLokasi = itemView.findViewById(R.id.recLokasi);
        recKeterangan = itemView.findViewById(R.id.recKeterangan);
    }
}