package com.example.m_transaksi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.m_transaksi.R;
import com.example.m_transaksi.api.ApiClient;
import com.example.m_transaksi.api.ApiInterface;
import com.example.m_transaksi.model.addBarang.ResponseAddBarang;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class menuUploud extends AppCompatActivity {

    private EditText etname_brg, etstok_brg, etharga_brg, etid_adminUP;
    private Button btnUPData;

    private String nama_barang, id_adminUP, stok_barang, harga_barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_uploud);

        etname_brg = findViewById(R.id.et_namaBarang);
        etstok_brg = findViewById(R.id.et_stokBrg);
        etharga_brg = findViewById(R.id.et_hargaBrg);
        etid_adminUP = findViewById(R.id.et_idAdminUploud);

        btnUPData = findViewById(R.id.btnUploudData);
        btnUPData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama_barang = etname_brg.getText().toString();
                stok_barang = etstok_brg.getText().toString();
                harga_barang = etharga_brg.getText().toString();
                id_adminUP = etid_adminUP.getText().toString();

                if (nama_barang.trim().equals("")){
                    etname_brg.setError("Nama Harus di isi");
                } else if (stok_barang.trim().equals("")) {
                    etstok_brg.setError("Stok Barang Harus di isi");
                } else if (harga_barang.trim().equals("")) {
                    etharga_brg.setError("Harga Barang Harus di isi");
                } else if (id_adminUP.trim().equals("")) {
                    etid_adminUP.setError("Id Admin Harus di isi");
                } else {
                    simpanData();
                }
            }
        });
    }
    private void simpanData() {
        ApiInterface arData = ApiClient.getApiClient().create(ApiInterface.class);
        Call<ResponseAddBarang> simpanData = arData.createData(nama_barang, stok_barang, harga_barang, id_adminUP);

        simpanData.enqueue(new Callback<ResponseAddBarang>() {
            @Override
            public void onResponse(Call<ResponseAddBarang> call, Response<ResponseAddBarang> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(menuUploud.this, "Kode : " +kode+ " | pesan : " + pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseAddBarang> call, Throwable t) {
                Toast.makeText(menuUploud.this, "Gagal Menghubungi Server | " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}