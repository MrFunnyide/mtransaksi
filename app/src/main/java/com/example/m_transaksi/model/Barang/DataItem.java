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

	@SerializedName("img_url")
	private String img_url;

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

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

	@Override
	public String toString() {
		return "DataItem{" +
				"stokBrg='" + stokBrg + '\'' +
				", hargaBrg='" + hargaBrg + '\'' +
				", idAdmin='" + idAdmin + '\'' +
				", namaBrg='" + namaBrg + '\'' +
				", kodeBrg='" + kodeBrg + '\'' +
				", img_url='" + img_url + '\'' +
				'}';
	}
}