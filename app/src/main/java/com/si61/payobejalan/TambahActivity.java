package com.si61.payobejalan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.si61.payobejalan.R.id;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etAlamat, etJam;
    private Button btnTambah;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(id.et_nama);
        etAlamat = findViewById(R.id.et_alamat);
        etJam = findViewById(id.et_jam_operasional);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama, alamat, jam;

                nama = etNama.getText().toString();
                alamat = etAlamat.getText().toString();
                jam = etJam.getText().toString();

                if (nama.trim().equals("")) {
                    etNama.setError("Nama Tidak Boleh Kosong");
                }
                else if (alamat.trim().equals("")) {
                    etAlamat.setError("Alamat Tidak Boleh Kosong");
                }
                else if (jam.trim().equals("")) {
                    etJam.setError("Jam Tidak Boleh Kosong");
                }
                else {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);
                    long eks = myDB.tambahData(nama, alamat, jam);

                    if (eks == -1) {
                        Toast.makeText(TambahActivity.this, "Tambah Data Gagal", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(TambahActivity.this, "Tambah Data Sukses", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
    });
}}