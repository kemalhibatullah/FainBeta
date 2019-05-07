package com.example.android.fainbeta;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Hafizh Herdi on 10/8/2017.
 */

public class AdapterBarangRecyclerView extends RecyclerView.Adapter<AdapterBarangRecyclerView.ViewHolder> {

    private ArrayList<Barang> daftarBarang;
    private Context context;

    public AdapterBarangRecyclerView(ArrayList<Barang> barangs, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarBarang = barangs;
        context = ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        TextView tvLokasi;
        TextView tvTanggal;
        TextView tvDeskripsi;
        ImageView tvImage;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_namabarang);
            tvLokasi = (TextView) v.findViewById(R.id.tv_lokasibarang);
            tvTanggal = (TextView) v.findViewById(R.id.tv_tanggalbarang);
            tvDeskripsi = (TextView) v.findViewById(R.id.tv_deskripsibarang);
            tvImage = (ImageView) v.findViewById(R.id.card_view_image);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembarang, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        holder.tvTitle.setText(daftarBarang.get(position).getNama());
        holder.tvLokasi.setText(daftarBarang.get(position).getLokasi());
        holder.tvTanggal.setText(daftarBarang.get(position).getTanggal());
        holder.tvDeskripsi.setText(daftarBarang.get(position).getDeskripsi());
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                context.startActivity(FirebaseDBReadSingleActivity.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
            }
        });
        holder.tvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                context.startActivity(FirebaseDBReadSingleActivity.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
            }
        });
        holder.tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarBarang.size();
    }
}
