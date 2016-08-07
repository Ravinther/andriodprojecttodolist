package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0954g;
import java.util.HashSet;
import java.util.Set;

public class ja implements Creator<C0954g> {
    static void m996a(C0954g c0954g, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = c0954g.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, c0954g.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m235a(parcel, 2, c0954g.isPrimary());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0153b.m232a(parcel, 3, c0954g.getValue(), true);
        }
        C0153b.m222D(parcel, p);
    }

    public C0954g aQ(Parcel parcel) {
        boolean z = false;
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    z = C0152a.m194c(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0954g(hashSet, i, z, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0954g[] bN(int i) {
        return new C0954g[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bN(x0);
    }
}
