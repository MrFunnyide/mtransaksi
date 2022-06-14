package com.example.m_transaksi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m_transaksi.R;
import com.example.m_transaksi.model.Barang.DataItem;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataItem> listBarang;

    public AdapterData(Context ctx, List<DataItem> listBarang) {
        this.ctx = ctx;
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataItem db = listBarang.get(position);

        holder.tvKodeBrg.setText(String.valueOf(db.getKodeBrg()));
        holder.tvNmBrg.setText(db.getNamaBrg());
        holder.tvJmlhBrg.setText(String.valueOf(db.getStokBrg()));
        holder.tvHrgaBrg.setText(String.valueOf(db.getHargaBrg()));
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvKodeBrg, tvNmBrg, tvJmlhBrg, tvHrgaBrg;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvKodeBrg = itemView.findViewById(R.id.tvKodeBrg);
            tvNmBrg = itemView.findViewById(R.id.tvNmBrg);
            tvJmlhBrg = itemView.findViewById(R.id.tvJmlhBrg);
            tvHrgaBrg = itemView.findViewById(R.id.tvHrgBrg);
        }
    }
}
