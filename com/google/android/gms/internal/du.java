package com.google.android.gms.internal;

import android.util.Log;

public class du {
    private static boolean ye;
    private final String mTag;
    private boolean yf;
    private boolean yg;
    private String yh;

    static {
        ye = false;
    }

    public du(String str) {
        this(str, di());
    }

    public du(String str, boolean z) {
        this.mTag = str;
        this.yf = z;
        this.yg = false;
    }

    public static boolean di() {
        return ye;
    }

    private String m633e(String str, Object... objArr) {
        String format = String.format(str, objArr);
        return this.yh != null ? this.yh + format : format;
    }

    public void m634U(String str) {
        this.yh = String.format("[%s] ", new Object[]{str});
    }

    public void m635a(String str, Object... objArr) {
        if (dh()) {
            Log.v(this.mTag, m633e(str, objArr));
        }
    }

    public void m636a(Throwable th, String str, Object... objArr) {
        if (dg() || ye) {
            Log.d(this.mTag, m633e(str, objArr), th);
        }
    }

    public void m637b(String str, Object... objArr) {
        if (dg() || ye) {
            Log.d(this.mTag, m633e(str, objArr));
        }
    }

    public void m638c(String str, Object... objArr) {
        Log.i(this.mTag, m633e(str, objArr));
    }

    public void m639d(String str, Object... objArr) {
        Log.w(this.mTag, m633e(str, objArr));
    }

    public boolean dg() {
        return this.yf;
    }

    public boolean dh() {
        return this.yg;
    }
}
