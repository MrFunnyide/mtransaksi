package com.example.m_transaksi.model.Registrasi;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("id")
	private String id;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("nama_admin")
	private String namaAdmin;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
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