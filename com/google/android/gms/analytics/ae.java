package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.analytics.tracking.android.Fields;

class ae implements C0106m {
    private static Object qI;
    private static ae uk;
    private final Context mContext;

    static {
        qI = new Object();
    }

    protected ae(Context context) {
        this.mContext = context;
    }

    public static ae cs() {
        ae aeVar;
        synchronized (qI) {
            aeVar = uk;
        }
        return aeVar;
    }

    public static void m1434n(Context context) {
        synchronized (qI) {
            if (uk == null) {
                uk = new ae(context);
            }
        }
    }

    protected String ct() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public String getValue(String field) {
        return (field != null && field.equals(Fields.SCREEN_RESOLUTION)) ? ct() : null;
    }

    public boolean m1435x(String str) {
        return Fields.SCREEN_RESOLUTION.equals(str);
    }
}
