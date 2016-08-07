package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ee.C0607a;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class eq implements Creator<C0607a> {
    static void m714a(C0607a c0607a, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, c0607a.getAccountName(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0607a.getVersionCode());
        C0153b.m233a(parcel, 2, c0607a.dT(), false);
        C0153b.m242c(parcel, 3, c0607a.dS());
        C0153b.m232a(parcel, 4, c0607a.dV(), false);
        C0153b.m222D(parcel, p);
    }

    public C0607a[] m715R(int i) {
        return new C0607a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m716m(x0);
    }

    public C0607a m716m(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0152a.m207o(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    list = C0152a.m218y(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0607a(i2, str2, list, i, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m715R(x0);
    }
}
