package com.example.android.fainbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FirebaseDBReadSingleActivity extends AppCompatActivity {

    private TextView etNama;
    private TextView etLokasi;
    private TextView etTanggal;
    private TextView etDeskripsi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        etNama = (TextView) findViewById(R.id.detailnama);
        etLokasi = (TextView) findViewById(R.id.detaillokasi);
        etTanggal = (TextView) findViewById(R.id.detailtanggal);
        etDeskripsi = (TextView) findViewById(R.id.detaildeskripsi);


        Barang barang = (Barang) getIntent().getSerializableExtra("data");
        if(barang!=null){
            etNama.setText(barang.getNama());
            etLokasi.setText(barang.getLokasi());
            etTanggal.setText(barang.getTanggal());
            etDeskripsi.setText(barang.getDeskripsi());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadSingleActivity.class);
    }
}