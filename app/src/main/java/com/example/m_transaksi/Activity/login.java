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
import com.example.m_transaksi.SessionManager;
import com.example.m_transaksi.api.ApiClient;
import com.example.m_transaksi.api.ApiInterface;
import com.example.m_transaksi.model.Login.Data;
import com.example.m_transaksi.model.Login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity implements View.OnClickListener {

    EditText etIdLogin, etPassLogin;
    Button btnLogin;
    TextView tvCreateAccount;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    // tempat simpan data
    String idLog, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etIdLogin = findViewById(R.id.etIDLogin);
        etPassLogin = findViewById(R.id.etPasswordLogin);

        btnLogin = findViewById(R.id.btnLogin);
        // beri click listener ke login
        btnLogin.setOnClickListener(this);

        tvCreateAccount = findViewById(R.id.tvCreateAccount);
        tvCreateAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                idLog = etIdLogin.getText().toString();
                Password = etPassLogin.getText().toString();
                login(idLog, Password);
                break;
            case R.id.tvCreateAccount:
                Intent i = new Intent(this, registrasi.class);
                startActivity(i);
                break;
        }
    }

    private void login(String idLog, String password) {

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Login> LoginCall = apiInterface.LoginResponse(idLog, password);
        LoginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

                    sessionManager = new SessionManager(login.this);
                    Data loginData = response.body().getData();
                    sessionManager.createLoginSeason(loginData);
                    finish();

                    Toast.makeText(login.this, response.body().getData().getNamaAdmin(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(login.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}