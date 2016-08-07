package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.cb.C0909a;
import com.google.android.gms.internal.cb.C0910b;

public final class ca {

    /* renamed from: com.google.android.gms.internal.ca.a */
    public interface C0238a {
        void m468a(cf cfVar);
    }

    public static ct m469a(Context context, cd cdVar, C0238a c0238a) {
        return cdVar.kN.pX ? m470b(context, cdVar, c0238a) : m471c(context, cdVar, c0238a);
    }

    private static ct m470b(Context context, cd cdVar, C0238a c0238a) {
        da.m562s("Fetching ad response from local ad request service.");
        ct c0909a = new C0909a(context, cdVar, c0238a);
        c0909a.start();
        return c0909a;
    }

    private static ct m471c(Context context, cd cdVar, C0238a c0238a) {
        da.m562s("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C0910b(context, cdVar, c0238a);
        }
        da.m566w("Failed to connect to remote ad request service.");
        return null;
    }
}
