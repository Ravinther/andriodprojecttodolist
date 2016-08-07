package com.google.android.gms.analytics;

import android.util.Log;

/* renamed from: com.google.android.gms.analytics.l */
class C0510l implements Logger {
    private int rc;

    C0510l() {
        this.rc = 1;
    }

    private String m1464z(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.rc <= 3) {
            Log.e("GAV3", null, exception);
        }
    }

    public void error(String msg) {
        if (this.rc <= 3) {
            Log.e("GAV3", m1464z(msg));
        }
    }

    public int getLogLevel() {
        return this.rc;
    }

    public void info(String msg) {
        if (this.rc <= 1) {
            Log.i("GAV3", m1464z(msg));
        }
    }

    public void setLogLevel(int level) {
        this.rc = level;
    }

    public void verbose(String msg) {
        if (this.rc <= 0) {
            Log.v("GAV3", m1464z(msg));
        }
    }

    public void warn(String msg) {
        if (this.rc <= 2) {
            Log.w("GAV3", m1464z(msg));
        }
    }
}
