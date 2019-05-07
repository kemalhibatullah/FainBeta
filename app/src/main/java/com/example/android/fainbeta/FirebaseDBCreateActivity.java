package com.example.android.fainbeta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FirebaseDBCreateActivity extends AppCompatActivity {

    //view objects
    EditText nama1;
    EditText lokasi1;
    EditText tanggal1;
    EditText deskripsi1;
    Button buttonAdd;

    //a list to store all the artist from firebase database
    List<Barang> barang;

    //our database reference object
    DatabaseReference databaseBarang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);


        //getting the reference of artists node
        databaseBarang = FirebaseDatabase.getInstance().getReference("Barang");

        //getting views
        nama1 = (EditText) findViewById(R.id.namabarang);
        lokasi1 = (EditText) findViewById(R.id.lokasi);
        tanggal1 = (EditText) findViewById(R.id.tanggal);
        deskripsi1 = (EditText) findViewById(R.id.deskripsi);
        buttonAdd = (Button) findViewById(R.id.btsubmit);

        //adding an onclicklistener to button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addBarang();
            }
        });

    }

    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    private void addBarang() {
        //getting the values to save
        String nama = nama1.getText().toString().trim();
        String lokasi = lokasi1.getText().toString().trim();
        String tanggal = tanggal1.getText().toString().trim();
        String deskripsi = deskripsi1.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(nama) && !TextUtils.isEmpty(lokasi) && !TextUtils.isEmpty(tanggal) && !TextUtils.isEmpty(deskripsi)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseBarang.push().getKey();

            //creating an Artist Object
            Barang barang2 = new Barang(nama, lokasi, tanggal, deskripsi);

            //Saving the Artist
            databaseBarang.child(id).setValue(barang2);

            //setting edittext to blank again
            nama1.setText("");
            lokasi1.setText("");
            tanggal1.setText("");
            deskripsi1.setText("");

            //displaying a success toast
            Toast.makeText(this, "Barang berhasil ditambahkan", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Tidak boleh kosong", Toast.LENGTH_LONG).show();
        }
    }

}
