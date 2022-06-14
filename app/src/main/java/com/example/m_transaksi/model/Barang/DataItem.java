package com.example.m_transaksi.model.Barang;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("stok_brg")
	private String stokBrg;

	@SerializedName("harga_brg")
	private String hargaBrg;

	@SerializedName("id_admin")
	private String idAdmin;

	@SerializedName("nama_brg")
	private String namaBrg;

	@SerializedName("kode_brg")
	private String kodeBrg;

	public void setStokBrg(String stokBrg){
		this.stokBrg = stokBrg;
	}

	public String getStokBrg(){
		return stokBrg;
	}

	public void setHargaBrg(String hargaBrg){
		this.hargaBrg = hargaBrg;
	}

	public String getHargaBrg(){
		return hargaBrg;
	}

	public void setIdAdmin(String idAdmin){
		this.idAdmin = idAdmin;
	}

	public String getIdAdmin(){
		return idAdmin;
	}

	public void setNamaBrg(String namaBrg){
		this.namaBrg = namaBrg;
	}

	public String getNamaBrg(){
		return namaBrg;
	}

	public void setKodeBrg(String kodeBrg){
		this.kodeBrg = kodeBrg;
	}

	public String getKodeBrg(){
		return kodeBrg;
	}
}