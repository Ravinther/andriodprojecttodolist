package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class jn implements Creator<jm> {
    static void m1010a(jm jmVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, jmVar.getVersionCode());
        C0153b.m242c(parcel, 2, jmVar.ZE);
        C0153b.m232a(parcel, 3, jmVar.ZF, false);
        C0153b.m224a(parcel, 4, jmVar.ZG);
        C0153b.m232a(parcel, 5, jmVar.ZH, false);
        C0153b.m226a(parcel, 6, jmVar.ZI);
        C0153b.m242c(parcel, 7, jmVar.ZJ);
        C0153b.m222D(parcel, p);
    }

    public jm bi(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    d = C0152a.m202k(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jm(i3, i, str2, d, str, j, i2);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public jm[] co(int i) {
        return new jm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return co(x0);
    }
}
