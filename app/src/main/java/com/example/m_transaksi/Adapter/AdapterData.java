package com.example.m_transaksi.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m_transaksi.Activity.MainActivity;
import com.example.m_transaksi.R;
import com.example.m_transaksi.api.ApiClient;
import com.example.m_transaksi.api.ApiInterface;
import com.example.m_transaksi.model.Barang.DataItem;
import com.example.m_transaksi.model.addBarang.ResponseAddBarang;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataItem> listBarang;
    private OnAdapterListener listener;
    private int idLaundry;

    // construktor untuk adapterdata
    public AdapterData(Context ctx, List<DataItem> listBarang, OnAdapterListener listener) {
        this.ctx = ctx;
        this.listBarang = listBarang;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // mengambil id dari card_view melalui onCreateViewHolder
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    // tempat meletak data atau menempatkan onclik listener
    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataItem db = listBarang.get(position);

        holder.tvKodeBrg.setText(String.valueOf(db.getKodeBrg()));
        holder.tvNmBrg.setText(db.getNamaBrg());
        holder.tvJmlhBrg.setText(String.valueOf(db.getStokBrg()));
        holder.tvHrgaBrg.setText(String.valueOf(db.getHargaBrg()));
        Picasso.get()
                .load(db.getImg_url() )
                .placeholder(R.drawable.img_placeholder)
                .fit().centerCrop()
                .into(holder.img_url);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick( db );
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvKodeBrg, tvNmBrg, tvJmlhBrg, tvHrgaBrg;
        ImageView img_url;

        // construktoor untuuk holderData
        public HolderData(@NonNull View itemView) {
            super(itemView);

            // ambil data lewat id
            tvKodeBrg = itemView.findViewById(R.id.tvKodeBrg);
            tvNmBrg = itemView.findViewById(R.id.tvNmBrg);
            tvJmlhBrg = itemView.findViewById(R.id.tvJmlhBrg);
            tvHrgaBrg = itemView.findViewById(R.id.tvHrgBrg);
            img_url = itemView.findViewById(R.id.img_url);

            // fungsi untuk delete
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Apakah Anda Ingin Menghapus Data ?");
                    dialogPesan.setCancelable(true);

                    idLaundry = Integer.parseInt(tvKodeBrg.getText().toString());

                    dialogPesan.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteData();
                            // setelah delete data , dialog di tutup
                            dialog.dismiss();
                            ((MainActivity) ctx).retrieveData();
                        }
                    });

                    dialogPesan.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    dialogPesan.show();

                    return false;
                }
            });
        }
        private void deleteData() {
            ApiInterface ardData = ApiClient.getApiClient().create(ApiInterface.class);
            Call<ResponseAddBarang> hapusData = ardData.deleteData(idLaundry);

            hapusData.enqueue(new Callback<ResponseAddBarang>() {
                @Override
                public void onResponse(Call<ResponseAddBarang> call, Response<ResponseAddBarang> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    Toast.makeText(ctx, "Kode" + kode + "| Pesan : " + pesan, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseAddBarang> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server : "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public interface OnAdapterListener {
        void onClick(DataItem dataItem);
    }
}
