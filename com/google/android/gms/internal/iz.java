package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0953f;
import java.util.HashSet;
import java.util.Set;

public class iz implements Creator<C0953f> {
    static void m995a(C0953f c0953f, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = c0953f.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, c0953f.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m232a(parcel, 2, c0953f.getDepartment(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0153b.m232a(parcel, 3, c0953f.getDescription(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0153b.m232a(parcel, 4, c0953f.getEndDate(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0153b.m232a(parcel, 5, c0953f.getLocation(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0153b.m232a(parcel, 6, c0953f.getName(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0153b.m235a(parcel, 7, c0953f.isPrimary());
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0153b.m232a(parcel, 8, c0953f.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0153b.m232a(parcel, 9, c0953f.getTitle(), true);
        }
        if (hB.contains(Integer.valueOf(10))) {
            C0153b.m242c(parcel, 10, c0953f.getType());
        }
        C0153b.m222D(parcel, p);
    }

    public C0953f aP(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str7 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str6 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str5 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str4 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str3 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    z = C0152a.m194c(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str2 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    str = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0953f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0953f[] bM(int i) {
        return new C0953f[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bM(x0);
    }
}
