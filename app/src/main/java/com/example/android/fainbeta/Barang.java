package com.example.android.fainbeta;

import java.io.Serializable;

public class Barang implements Serializable {

    private String nama;
    private String lokasi;
    private String tanggal;
    private String deskripsi;
    private String key;

    public Barang(){

    }

    public Barang(String nama, String lokasi, String tanggal, String deskripsi) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "nama='" + nama + '\'' +
                ", lokasi='" + lokasi + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                '}';
    }
}
