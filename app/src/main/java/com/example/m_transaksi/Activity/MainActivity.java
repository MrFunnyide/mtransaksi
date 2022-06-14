package com.example.m_transaksi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m_transaksi.Adapter.AdapterData;
import com.example.m_transaksi.R;
import com.example.m_transaksi.SessionManager;
import com.example.m_transaksi.api.ApiClient;
import com.example.m_transaksi.api.ApiInterface;
import com.example.m_transaksi.model.Barang.DataBarang;
import com.example.m_transaksi.model.Barang.DataItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // adapter
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataItem> listData = new ArrayList<>();
    private SwipeRefreshLayout srlData;
    private ProgressBar pbBar;

    TextView tvIdAdmin, tvNameAdmin;
    SessionManager sessionManager;
//    String idAdmin;
    String nameAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(MainActivity.this);

        rvData =findViewById(R.id.rv_data);

        srlData = findViewById(R.id.swl_data);
        pbBar = findViewById(R.id.pb_data);

        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        if (!sessionManager.isLogged()) {
            moveToLogin();
        }

//        tvIdAdmin = findViewById(R.id.tvid_admin);
        tvNameAdmin = findViewById(R.id.tv_name_admin);


//        idAdmin = sessionManager.getUserDetail().get(SessionManager.ID_ADMIN);
        nameAdmin = sessionManager.getUserDetail().get(SessionManager.USERNAME);

//        tvIdAdmin.setText(idAdmin);
        tvNameAdmin.setText(nameAdmin);

//        retrieveData();

        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                retrieveData();
                srlData.setRefreshing(false);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData() {

        pbBar.setVisibility(View.VISIBLE);

        ApiInterface arData = ApiClient.getApiClient().create(ApiInterface.class);
        Call<DataBarang> tampilBrg = arData.DataBarangResponse();


        tampilBrg.enqueue(new Callback<DataBarang>() {
            @Override
            public void onResponse(Call<DataBarang> call, Response<DataBarang> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listData = response.body().getData();

//                Toast.makeText(MainActivity.this, "Kode : " + kode + " | pesan : " + pesan, Toast.LENGTH_SHORT).show();

                adData = new AdapterData(MainActivity.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                pbBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<DataBarang> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungin Server : " + t.getMessage(), Toast.LENGTH_SHORT).show();

                pbBar.setVisibility(View.INVISIBLE);
            }
        });
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