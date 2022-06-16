package com.example.m_transaksi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m_transaksi.R;
import com.squareup.picasso.Picasso;

public class DetailBarang extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "DetailBarang";
    Button btnpensaBrg;
    TextView NM_Brg, ST_Brg, HG_Brg;
    EditText jumlahBrng;

    String title, hargaBrg, stk_brg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_barang);
        // bind id
        NM_Brg = findViewById(R.id.tv_NM_BG);
        ST_Brg = findViewById(R.id.tv_stokBrg);
        HG_Brg = findViewById(R.id.tv_hargaBrg);
        btnpensaBrg = findViewById(R.id.btn_pesanBarang);
        jumlahBrng = findViewById(R.id.et_brgBeli);

        // masukkan ke variabel
        title = getIntent().getStringExtra("intent_namaBrg");
        hargaBrg = getIntent().getStringExtra("intent_hargaBrg");
        stk_brg = getIntent().getStringExtra("intent_stokBrg");

        getSupportActionBar().setTitle(title);

        NM_Brg.setText(title);
        HG_Brg.setText(hargaBrg);
        ST_Brg.setText(stk_brg);
        btnpensaBrg.setOnClickListener(this);


        String imgDtl = getIntent().getStringExtra("intent_imgBrg");
        Picasso.get()
                .load(imgDtl)
                .placeholder(R.drawable.img_placeholder)
                .into((ImageView) findViewById(R.id.dtl_img));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pesanBarang:
                String jumlahPesanan = jumlahBrng.getText().toString();

//                Toast.makeText(this, "Anda sudah bisa pindah layout", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, notaApp.class);
                i.putExtra("bawa_nama", title);
                i.putExtra("bawa_stok", stk_brg);
                i.putExtra("bawa_harga", hargaBrg);
                i.putExtra("bawa_jumlah", jumlahPesanan);
                startActivity(i);
                break;
        }
    }
}