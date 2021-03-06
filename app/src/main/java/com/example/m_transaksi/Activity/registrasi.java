package com.example.m_transaksi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m_transaksi.R;
import com.example.m_transaksi.api.ApiClient;
import com.example.m_transaksi.api.ApiInterface;
import com.example.m_transaksi.model.Registrasi.Registrasi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registrasi extends AppCompatActivity implements View.OnClickListener {

    EditText tiIdAdmin, tiFull_name, tiPassword, tiNoHp;
    Button btnSubmit;
    TextView BackLogin;
    ApiInterface apiInterface;

    // simpan data
    String idAdmin, fullname, password, no_hp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        tiIdAdmin = findViewById(R.id.Id_pegawai);
        tiFull_name = findViewById(R.id.tiFullName);
        tiPassword = findViewById(R.id.tiPassword);
        tiNoHp = findViewById(R.id.tiNoHP);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        BackLogin = findViewById(R.id.tvBacktoLogin);
        BackLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                idAdmin = tiIdAdmin.getText().toString();
                fullname = tiFull_name.getText().toString();
                password = tiPassword.getText().toString();
                no_hp = tiNoHp.getText().toString();
               register(idAdmin, fullname, password, no_hp);
               break;
            case R.id.tvBacktoLogin:
                Intent i = new Intent(this, login.class);
                startActivity(i);
                finish();
                break;
        }
    }

    private void register(String idAdmin, String fullname, String password, String no_hp) {

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Registrasi> call = apiInterface.RegistrasiResponse(idAdmin, fullname, password, no_hp);
        call.enqueue(new Callback<Registrasi>() {
            @Override
            public void onResponse(Call<Registrasi> call, Response<Registrasi> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(registrasi.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(registrasi.this, login.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(registrasi.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Registrasi> call, Throwable t) {
                Toast.makeText(registrasi.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}