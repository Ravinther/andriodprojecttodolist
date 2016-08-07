package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0952d;
import java.util.HashSet;
import java.util.Set;

public class iy implements Creator<C0952d> {
    static void m994a(C0952d c0952d, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = c0952d.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, c0952d.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m232a(parcel, 2, c0952d.getFamilyName(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0153b.m232a(parcel, 3, c0952d.getFormatted(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0153b.m232a(parcel, 4, c0952d.getGivenName(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0153b.m232a(parcel, 5, c0952d.getHonorificPrefix(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0153b.m232a(parcel, 6, c0952d.getHonorificSuffix(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0153b.m232a(parcel, 7, c0952d.getMiddleName(), true);
        }
        C0153b.m222D(parcel, p);
    }

    public C0952d aO(Parcel parcel) {
        String str = null;
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str6 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str5 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str4 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str3 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str2 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0952d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0952d[] bL(int i) {
        return new C0952d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bL(x0);
    }
}
