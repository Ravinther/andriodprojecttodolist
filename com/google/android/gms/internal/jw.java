package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class jw implements Creator<jv> {
    static void m1015a(jv jvVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, jvVar.getVersionCode());
        C0153b.m232a(parcel, 2, jvVar.ZK, false);
        C0153b.m232a(parcel, 3, jvVar.oi, false);
        C0153b.m230a(parcel, 4, jvVar.ZO, i, false);
        C0153b.m230a(parcel, 5, jvVar.ZP, i, false);
        C0153b.m230a(parcel, 6, jvVar.ZQ, i, false);
        C0153b.m222D(parcel, p);
    }

    public jv bn(Parcel parcel) {
        jt jtVar = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        jt jtVar2 = null;
        jr jrVar = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    jrVar = (jr) C0152a.m187a(parcel, n, jr.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    jtVar2 = (jt) C0152a.m187a(parcel, n, jt.CREATOR);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    jtVar = (jt) C0152a.m187a(parcel, n, jt.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jv(i, str2, str, jrVar, jtVar2, jtVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bn(x0);
    }

    public jv[] ct(int i) {
        return new jv[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ct(x0);
    }
}
