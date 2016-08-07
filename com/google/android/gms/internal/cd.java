package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cd implements SafeParcelable {
    public static final ce CREATOR;
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;
    public final db kN;
    public final ab kQ;
    public final Bundle ob;
    public final C0673z oc;
    public final PackageInfo od;
    public final String oe;
    public final String of;
    public final String og;
    public final Bundle oh;
    public final int versionCode;

    /* renamed from: com.google.android.gms.internal.cd.a */
    public static final class C0239a {
        public final String adUnitId;
        public final ApplicationInfo applicationInfo;
        public final db kN;
        public final ab kQ;
        public final Bundle ob;
        public final C0673z oc;
        public final PackageInfo od;
        public final String of;
        public final String og;
        public final Bundle oh;

        public C0239a(Bundle bundle, C0673z c0673z, ab abVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, db dbVar, Bundle bundle2) {
            this.ob = bundle;
            this.oc = c0673z;
            this.kQ = abVar;
            this.adUnitId = str;
            this.applicationInfo = applicationInfo;
            this.od = packageInfo;
            this.of = str2;
            this.og = str3;
            this.kN = dbVar;
            this.oh = bundle2;
        }
    }

    static {
        CREATOR = new ce();
    }

    cd(int i, Bundle bundle, C0673z c0673z, ab abVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, db dbVar, Bundle bundle2) {
        this.versionCode = i;
        this.ob = bundle;
        this.oc = c0673z;
        this.kQ = abVar;
        this.adUnitId = str;
        this.applicationInfo = applicationInfo;
        this.od = packageInfo;
        this.oe = str2;
        this.of = str3;
        this.og = str4;
        this.kN = dbVar;
        this.oh = bundle2;
    }

    public cd(Bundle bundle, C0673z c0673z, ab abVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, db dbVar, Bundle bundle2) {
        this(2, bundle, c0673z, abVar, str, applicationInfo, packageInfo, str2, str3, str4, dbVar, bundle2);
    }

    public cd(C0239a c0239a, String str) {
        this(c0239a.ob, c0239a.oc, c0239a.kQ, c0239a.adUnitId, c0239a.applicationInfo, c0239a.od, str, c0239a.of, c0239a.og, c0239a.kN, c0239a.oh);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        ce.m472a(this, out, flags);
    }
}
