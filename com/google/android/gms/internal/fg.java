package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.fe.C0631a;
import com.google.android.gms.internal.fe.C0632b;
import java.util.ArrayList;

public class fg implements Creator<C0631a> {
    static void m757a(C0631a c0631a, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, c0631a.versionCode);
        C0153b.m232a(parcel, 2, c0631a.className, false);
        C0153b.m241b(parcel, 3, c0631a.CH, false);
        C0153b.m222D(parcel, p);
    }

    public C0631a[] m758Z(int i) {
        return new C0631a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m759w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m758Z(x0);
    }

    public C0631a m759w(Parcel parcel) {
        ArrayList arrayList = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    arrayList = C0152a.m193c(parcel, n, C0632b.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0631a(i, str, arrayList);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
