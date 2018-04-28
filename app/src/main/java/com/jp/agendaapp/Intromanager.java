package com.jp.agendaapp;

import android.content.Context;
import android.content.SharedPreferences;

public class Intromanager {

    SharedPreferences pref;

    public Intromanager(Context context) {
        pref = context.getSharedPreferences("first", 0);
    }

    public void setFirst(boolean isFirst) {
        pref.edit().putBoolean("check", isFirst).apply();
    }

    public boolean check() {
        return pref.getBoolean("check", true);
    }
}
