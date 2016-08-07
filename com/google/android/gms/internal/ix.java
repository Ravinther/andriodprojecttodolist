package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0951c;
import java.util.HashSet;
import java.util.Set;

public class ix implements Creator<C0951c> {
    static void m993a(C0951c c0951c, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = c0951c.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, c0951c.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m232a(parcel, 2, c0951c.getUrl(), true);
        }
        C0153b.m222D(parcel, p);
    }

    public C0951c aN(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0951c(hashSet, i, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0951c[] bK(int i) {
        return new C0951c[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bK(x0);
    }
}
