package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C0804x implements bi {
    private int rc;

    C0804x() {
        this.rc = 5;
    }

    public void m2370b(String str, Throwable th) {
        if (this.rc <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void m2371c(String str, Throwable th) {
        if (this.rc <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void m2372s(String str) {
        if (this.rc <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void setLogLevel(int logLevel) {
        this.rc = logLevel;
    }

    public void m2373t(String str) {
        if (this.rc <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void m2374u(String str) {
        if (this.rc <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void m2375v(String str) {
        if (this.rc <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void m2376w(String str) {
        if (this.rc <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }
}
