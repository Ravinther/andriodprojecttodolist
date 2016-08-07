package com.google.android.gms.internal;

import android.util.Log;

public final class el {
    private final String Cd;

    public el(String str) {
        this.Cd = (String) er.m721f(str);
    }

    public boolean m681Q(int i) {
        return Log.isLoggable(this.Cd, i);
    }

    public void m682a(String str, String str2, Throwable th) {
        if (m681Q(6)) {
            Log.e(str, str2, th);
        }
    }

    public void m683f(String str, String str2) {
        if (m681Q(2)) {
            Log.v(str, str2);
        }
    }

    public void m684g(String str, String str2) {
        if (m681Q(5)) {
            Log.w(str, str2);
        }
    }

    public void m685h(String str, String str2) {
        if (m681Q(6)) {
            Log.e(str, str2);
        }
    }
}
