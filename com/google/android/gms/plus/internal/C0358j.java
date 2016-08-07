package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.plus.internal.j */
public class C0358j implements Creator<C0765h> {
    static void m1208a(C0765h c0765h, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, c0765h.getAccountName(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0765h.getVersionCode());
        C0153b.m238a(parcel, 2, c0765h.hq(), false);
        C0153b.m238a(parcel, 3, c0765h.hr(), false);
        C0153b.m238a(parcel, 4, c0765h.hs(), false);
        C0153b.m232a(parcel, 5, c0765h.ht(), false);
        C0153b.m232a(parcel, 6, c0765h.hu(), false);
        C0153b.m232a(parcel, 7, c0765h.hv(), false);
        C0153b.m232a(parcel, 8, c0765h.hw(), false);
        C0153b.m230a(parcel, 9, c0765h.hx(), i, false);
        C0153b.m222D(parcel, p);
    }

    public C0765h aF(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str5 = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    strArr3 = C0152a.m217x(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    strArr2 = C0152a.m217x(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    strArr = C0152a.m217x(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    plusCommonExtras = (PlusCommonExtras) C0152a.m187a(parcel, n, PlusCommonExtras.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0765h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0765h[] bC(int i) {
        return new C0765h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bC(x0);
    }
}
