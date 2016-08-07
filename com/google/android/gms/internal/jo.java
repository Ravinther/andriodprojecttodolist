package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class jo implements Creator<jl> {
    static void m1011a(jl jlVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, jlVar.getVersionCode());
        C0153b.m232a(parcel, 2, jlVar.label, false);
        C0153b.m230a(parcel, 3, jlVar.ZD, i, false);
        C0153b.m232a(parcel, 4, jlVar.type, false);
        C0153b.m230a(parcel, 5, jlVar.YM, i, false);
        C0153b.m222D(parcel, p);
    }

    public jl bj(Parcel parcel) {
        jr jrVar = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        jm jmVar = null;
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
                    jmVar = (jm) C0152a.m187a(parcel, n, jm.CREATOR);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    jrVar = (jr) C0152a.m187a(parcel, n, jr.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jl(i, str2, jmVar, str, jrVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public jl[] cp(int i) {
        return new jl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cp(x0);
    }
}
