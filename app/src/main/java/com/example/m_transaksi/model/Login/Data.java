package com.example.m_transaksi.model.Login;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("id_admin")
	private String idAdmin;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("nama_admin")
	private String namaAdmin;

	public void setIdAdmin(String idAdmin){
		this.idAdmin = idAdmin;
	}

	public String getIdAdmin(){
		return idAdmin;
	}

	public void setNoTelp(String noTelp){
		this.noTelp = noTelp;
	}

	public String getNoTelp(){
		return noTelp;
	}

	public void setNamaAdmin(String namaAdmin){
		this.namaAdmin = namaAdmin;
	}

	public String getNamaAdmin(){
		return namaAdmin;
	}
}