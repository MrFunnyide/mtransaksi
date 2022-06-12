package com.example.m_transaksi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvIdAdmin, tvNameAdmin;
    SessionManager sessionManager;
    String idAdmin, nameAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLogged()) {
            moveToLogin();
        }

        tvIdAdmin = findViewById(R.id.tvid_admin);
        tvNameAdmin = findViewById(R.id.tv_name_admin);


        idAdmin = sessionManager.getUserDetail().get(SessionManager.ID_ADMIN);
        nameAdmin = sessionManager.getUserDetail().get(SessionManager.USERNAME);

        tvIdAdmin.setText(idAdmin);
        tvNameAdmin.setText(nameAdmin);

    }

    private void moveToLogin() {
        Intent i = new Intent(MainActivity.this, login.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                sessionManager.logoutSession();
                moveToLogin();
        }
        return super.onOptionsItemSelected(item);
    }
}