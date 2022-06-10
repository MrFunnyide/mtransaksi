package com.example.m_transaksi.model.login;

import com.google.gson.annotations.SerializedName;

public class DataLogin {

	@SerializedName("id")
	private int id;

	@SerializedName("no_telp")
	private String noTelp;

	@SerializedName("nama_admin")
	private String namaAdmin;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
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