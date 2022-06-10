package com.example.m_transaksi.api;

import com.example.m_transaksi.model.login.Login;
import com.example.m_transaksi.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> LoginResponse(
            @Field("id") String id_admin,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("registrasi.php")
    Call<Register> RegistrasiResponse(
            @Field("id") String id_admin,
            @Field("nama_admin") String fullname,
            @Field("password") String password,
            @Field("no_telp") String no_telp
    );
}
