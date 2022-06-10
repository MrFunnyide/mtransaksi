package com.example.m_transaksi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.m_transaksi.model.Registrasi.Data;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    // simpan data di sesi
    public static final String IS_LOGGED_IN = "isLoggedIN";
    public static final String ID = "id";
    public static final String NAMA_ADMIN = "nama_admin";
    public static final String NO_TELP = "no_telp";

    public SessionManager (Context context) {
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLogin(Data user) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID, user.getId());
        editor.putString(NAMA_ADMIN, user.getNamaAdmin());
        editor.putString(NO_TELP, user.getNoTelp());
        editor.commit();
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID, null));
        user.put(NAMA_ADMIN, sharedPreferences.getString(NAMA_ADMIN, null));
        user.put(NO_TELP, sharedPreferences.getString(NO_TELP, null));
        return user;
    }

    public void logoutSession() {
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
