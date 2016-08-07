package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0950b;
import com.google.android.gms.internal.ir.C0950b.C0948a;
import com.google.android.gms.internal.ir.C0950b.C0949b;
import java.util.HashSet;
import java.util.Set;

public class iu implements Creator<C0950b> {
    static void m990a(C0950b c0950b, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = c0950b.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, c0950b.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m230a(parcel, 2, c0950b.m2781if(), i, true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0153b.m230a(parcel, 3, c0950b.ig(), i, true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0153b.m242c(parcel, 4, c0950b.getLayout());
        }
        C0153b.m222D(parcel, p);
    }

    public C0950b aK(Parcel parcel) {
        C0949b c0949b = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        C0948a c0948a = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    C0948a c0948a2 = (C0948a) C0152a.m187a(parcel, n, C0948a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c0948a = c0948a2;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    C0949b c0949b2 = (C0949b) C0152a.m187a(parcel, n, C0949b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0949b = c0949b2;
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0950b(hashSet, i2, c0948a, c0949b, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0950b[] bH(int i) {
        return new C0950b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bH(x0);
    }
}
