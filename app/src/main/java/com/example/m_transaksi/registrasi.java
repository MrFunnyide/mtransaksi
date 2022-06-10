package com.example.m_transaksi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class registrasi extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout tiIdAdmin, tiFull_name, tiPassword, tiNoHp;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    Button btnSubmit;
    TextView BackLogin;

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
                idAdmin = tiIdAdmin.getEditText().toString();
                fullname = tiFull_name.getEditText().toString();
                password = tiPassword.getEditText().toString();
                no_hp = tiNoHp.getEditText().toString();
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
        Intent i = new Intent(this, login.class);
        startActivity(i);
        finish();
    }
}