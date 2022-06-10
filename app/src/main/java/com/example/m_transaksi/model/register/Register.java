package com.example.m_transaksi.model.register;

import com.google.gson.annotations.SerializedName;

public class Register{

	@SerializedName("data")
	private DataRegister dataRegister;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setData(DataRegister dataRegister){
		this.dataRegister = dataRegister;
	}

	public DataRegister getData(){
		return dataRegister;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}