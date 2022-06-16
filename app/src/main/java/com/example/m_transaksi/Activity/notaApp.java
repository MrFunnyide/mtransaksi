package com.example.m_transaksi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.m_transaksi.R;

public class notaApp extends AppCompatActivity implements View.OnClickListener {

    TextView nt_nama, nt_stok, nt_harga, ntTotal;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_app);

        nt_nama = findViewById(R.id.tv_notanama);
        nt_stok = findViewById(R.id.tv_notajumlah);
        nt_harga = findViewById(R.id.tv_notaharga);
        ntTotal = findViewById(R.id.tv_notaTotal);
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(this);

        int total =Integer.parseInt(getIntent().getStringExtra("bawa_harga"));
        int jumlah = Integer.parseInt(getIntent().getStringExtra("bawa_jumlah"));

        // coba kali
        int AllTotal = total * jumlah;

        //rubah ke String untuk di tampilkan
        String AllTotalStr = String.valueOf(AllTotal);


        nt_nama.setText(getIntent().getStringExtra("bawa_nama"));
        nt_stok.setText(getIntent().getStringExtra("bawa_jumlah"));
        nt_harga.setText(getIntent().getStringExtra("bawa_harga"));
        ntTotal.setText(AllTotalStr);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHome:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
        }
    }
}