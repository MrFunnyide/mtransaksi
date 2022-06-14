package com.example.m_transaksi.api;

import com.example.m_transaksi.model.Barang.DataBarang;
import com.example.m_transaksi.model.Login.Login;
import com.example.m_transaksi.model.Registrasi.Registrasi;
import com.example.m_transaksi.model.addBarang.ResponseAddBarang;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> LoginResponse(
            @Field("id_admin") String id_admin,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("registrasi.php")
    Call<Registrasi> RegistrasiResponse(
            @Field("id_admin") String id_admin,
            @Field("nama_admin") String fullname,
            @Field("password") String password,
            @Field("no_telp") String no_telp
    );
    @GET("retrieve.php")
    Call<DataBarang> DataBarangResponse();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseAddBarang> createData(
            @Field("nama_brg") String nama_brg,
            @Field("stok_brg") String stok_brg,
            @Field("harga_brg") String harga_brg,
            @Field("id_admin") String id_admin
    );
}
