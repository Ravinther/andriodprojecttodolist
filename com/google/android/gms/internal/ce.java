package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class ce implements Creator<cd> {
    static void m472a(cd cdVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, cdVar.versionCode);
        C0153b.m227a(parcel, 2, cdVar.ob, false);
        C0153b.m230a(parcel, 3, cdVar.oc, i, false);
        C0153b.m230a(parcel, 4, cdVar.kQ, i, false);
        C0153b.m232a(parcel, 5, cdVar.adUnitId, false);
        C0153b.m230a(parcel, 6, cdVar.applicationInfo, i, false);
        C0153b.m230a(parcel, 7, cdVar.od, i, false);
        C0153b.m232a(parcel, 8, cdVar.oe, false);
        C0153b.m232a(parcel, 9, cdVar.of, false);
        C0153b.m232a(parcel, 10, cdVar.og, false);
        C0153b.m230a(parcel, 11, cdVar.kN, i, false);
        C0153b.m227a(parcel, 12, cdVar.oh, false);
        C0153b.m222D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m473f(x0);
    }

    public cd m473f(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        Bundle bundle = null;
        C0673z c0673z = null;
        ab abVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        db dbVar = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    bundle = C0152a.m208o(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    c0673z = (C0673z) C0152a.m187a(parcel, n, C0673z.CREATOR);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    abVar = (ab) C0152a.m187a(parcel, n, ab.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    applicationInfo = (ApplicationInfo) C0152a.m187a(parcel, n, ApplicationInfo.CREATOR);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    packageInfo = (PackageInfo) C0152a.m187a(parcel, n, PackageInfo.CREATOR);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    dbVar = (db) C0152a.m187a(parcel, n, db.CREATOR);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    bundle2 = C0152a.m208o(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cd(i, bundle, c0673z, abVar, str, applicationInfo, packageInfo, str2, str3, str4, dbVar, bundle2);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public cd[] m474k(int i) {
        return new cd[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m474k(x0);
    }
}
