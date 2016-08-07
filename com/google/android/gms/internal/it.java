package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0947a;
import java.util.HashSet;
import java.util.Set;

public class it implements Creator<C0947a> {
    static void m989a(C0947a c0947a, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = c0947a.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, c0947a.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m242c(parcel, 2, c0947a.getMax());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0153b.m242c(parcel, 3, c0947a.getMin());
        }
        C0153b.m222D(parcel, p);
    }

    public C0947a aJ(Parcel parcel) {
        int i = 0;
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i2 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0947a(hashSet, i3, i2, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0947a[] bG(int i) {
        return new C0947a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bG(x0);
    }
}
