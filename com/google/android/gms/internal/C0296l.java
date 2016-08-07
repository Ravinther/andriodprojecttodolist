package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.l */
public class C0296l {
    private String ko;
    private String kp;
    private String[] kq;
    private C0285h kr;
    private final C0282g ks;

    public C0296l(C0285h c0285h) {
        this.ko = "googleads.g.doubleclick.net";
        this.kp = "/pagead/ads";
        this.kq = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
        this.ks = new C0282g();
        this.kr = c0285h;
    }

    private Uri m1073a(Uri uri, Context context, String str, boolean z) throws C0297m {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new C0297m("Query parameter already exists: ms");
            }
            return m1074a(uri, "ms", z ? this.kr.m945a(context, str) : this.kr.m944a(context));
        } catch (UnsupportedOperationException e) {
            throw new C0297m("Provided Uri is not in a valid state");
        }
    }

    private Uri m1074a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    public Uri m1075a(Uri uri, Context context) throws C0297m {
        try {
            return m1073a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0297m("Provided Uri is not in a valid state");
        }
    }

    public void m1076a(MotionEvent motionEvent) {
        this.kr.m947a(motionEvent);
    }

    public boolean m1077a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.kq) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public C0285h m1078y() {
        return this.kr;
    }
}
