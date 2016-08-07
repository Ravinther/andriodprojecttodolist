package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ep;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C0765h implements SafeParcelable {
    public static final C0358j CREATOR;
    private final String[] Rm;
    private final String[] Rn;
    private final String[] Ro;
    private final String Rp;
    private final String Rq;
    private final String Rr;
    private final String Rs;
    private final PlusCommonExtras Rt;
    private final String vi;
    private final int wj;

    static {
        CREATOR = new C0358j();
    }

    C0765h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.wj = i;
        this.vi = str;
        this.Rm = strArr;
        this.Rn = strArr2;
        this.Ro = strArr3;
        this.Rp = str2;
        this.Rq = str3;
        this.Rr = str4;
        this.Rs = str5;
        this.Rt = plusCommonExtras;
    }

    public C0765h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.wj = 1;
        this.vi = str;
        this.Rm = strArr;
        this.Rn = strArr2;
        this.Ro = strArr3;
        this.Rp = str2;
        this.Rq = str3;
        this.Rr = str4;
        this.Rs = null;
        this.Rt = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0765h)) {
            return false;
        }
        C0765h c0765h = (C0765h) obj;
        return this.wj == c0765h.wj && ep.equal(this.vi, c0765h.vi) && Arrays.equals(this.Rm, c0765h.Rm) && Arrays.equals(this.Rn, c0765h.Rn) && Arrays.equals(this.Ro, c0765h.Ro) && ep.equal(this.Rp, c0765h.Rp) && ep.equal(this.Rq, c0765h.Rq) && ep.equal(this.Rr, c0765h.Rr) && ep.equal(this.Rs, c0765h.Rs) && ep.equal(this.Rt, c0765h.Rt);
    }

    public String getAccountName() {
        return this.vi;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return ep.hashCode(Integer.valueOf(this.wj), this.vi, this.Rm, this.Rn, this.Ro, this.Rp, this.Rq, this.Rr, this.Rs, this.Rt);
    }

    public String[] hq() {
        return this.Rm;
    }

    public String[] hr() {
        return this.Rn;
    }

    public String[] hs() {
        return this.Ro;
    }

    public String ht() {
        return this.Rp;
    }

    public String hu() {
        return this.Rq;
    }

    public String hv() {
        return this.Rr;
    }

    public String hw() {
        return this.Rs;
    }

    public PlusCommonExtras hx() {
        return this.Rt;
    }

    public Bundle hy() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.Rt.m2215m(bundle);
        return bundle;
    }

    public String toString() {
        return ep.m713e(this).m712a("versionCode", Integer.valueOf(this.wj)).m712a("accountName", this.vi).m712a("requestedScopes", this.Rm).m712a("visibleActivities", this.Rn).m712a("requiredFeatures", this.Ro).m712a("packageNameForAuth", this.Rp).m712a("callingPackageName", this.Rq).m712a("applicationName", this.Rr).m712a("extra", this.Rt.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0358j.m1208a(this, out, flags);
    }
}
