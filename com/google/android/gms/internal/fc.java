package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.fb.C0630a;

public class fc implements Creator<C0630a> {
    static void m748a(C0630a c0630a, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, c0630a.getVersionCode());
        C0153b.m242c(parcel, 2, c0630a.el());
        C0153b.m235a(parcel, 3, c0630a.er());
        C0153b.m242c(parcel, 4, c0630a.em());
        C0153b.m235a(parcel, 5, c0630a.es());
        C0153b.m232a(parcel, 6, c0630a.et(), false);
        C0153b.m242c(parcel, 7, c0630a.eu());
        C0153b.m232a(parcel, 8, c0630a.ew(), false);
        C0153b.m230a(parcel, 9, c0630a.ey(), i, false);
        C0153b.m222D(parcel, p);
    }

    public C0630a[] m749W(int i) {
        return new C0630a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m750t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m749W(x0);
    }

    public C0630a m750t(Parcel parcel) {
        ew ewVar = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i4 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    z2 = C0152a.m194c(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    ewVar = (ew) C0152a.m187a(parcel, n, ew.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0630a(i4, i3, z2, i2, z, str2, i, str, ewVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
