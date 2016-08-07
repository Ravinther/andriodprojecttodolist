package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0955h;
import java.util.HashSet;
import java.util.Set;

public class jb implements Creator<C0955h> {
    static void m997a(C0955h c0955h, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = c0955h.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, c0955h.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0153b.m242c(parcel, 3, c0955h.io());
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0153b.m232a(parcel, 4, c0955h.getValue(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0153b.m232a(parcel, 5, c0955h.getLabel(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0153b.m242c(parcel, 6, c0955h.getType());
        }
        C0153b.m222D(parcel, p);
    }

    public C0955h aR(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str2 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i2 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0955h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0955h[] bO(int i) {
        return new C0955h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bO(x0);
    }
}
