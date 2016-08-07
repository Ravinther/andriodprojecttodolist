package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ey.C0617a;

public class fa implements Creator<C0617a> {
    static void m739a(C0617a c0617a, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, c0617a.versionCode);
        C0153b.m232a(parcel, 2, c0617a.Cs, false);
        C0153b.m242c(parcel, 3, c0617a.Ct);
        C0153b.m222D(parcel, p);
    }

    public C0617a[] m740V(int i) {
        return new C0617a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m741s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m740V(x0);
    }

    public C0617a m741s(Parcel parcel) {
        int i = 0;
        int o = C0152a.m207o(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0617a(i2, str, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
