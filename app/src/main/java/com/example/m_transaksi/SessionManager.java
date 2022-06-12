package com.example.m_transaksi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.m_transaksi.model.Login.Data;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "is_logged_in";
    public static final String ID_ADMIN = "id_admin";
    public static final String USERNAME = "nama_admin";
    public static final String NO_TELP = "no_telp";

    public SessionManager (Context context) {
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSeason(Data user) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_ADMIN, user.getIdAdmin());
        editor.putString(USERNAME, user.getNamaAdmin());
        editor.putString(NO_TELP, user.getNoTelp());
        editor.commit();
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(ID_ADMIN, sharedPreferences.getString(ID_ADMIN, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(NO_TELP, sharedPreferences.getString(NO_TELP, null));
        return user;
    }

    public void logoutSession() {
        editor.clear();
        editor.commit();
    }

    public boolean isLogged() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
