package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

public final class da {
    public static void m559a(String str, Throwable th) {
        if (m561n(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m560b(String str, Throwable th) {
        if (m561n(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m561n(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    public static void m562s(String str) {
        if (m561n(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void m563t(String str) {
        if (m561n(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m564u(String str) {
        if (m561n(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m565v(String str) {
        if (m561n(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void m566w(String str) {
        if (m561n(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
