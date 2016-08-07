package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.hx.C0657a;
import com.google.android.gms.location.GeofenceStatusCodes;

public class hw implements Creator<C0657a> {
    static void m979a(C0657a c0657a, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, c0657a.gt(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0657a.wj);
        C0153b.m232a(parcel, 2, c0657a.getTag(), false);
        C0153b.m232a(parcel, 3, c0657a.gH(), false);
        C0153b.m242c(parcel, 4, c0657a.gI());
        C0153b.m222D(parcel, p);
    }

    public C0657a aA(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0152a.m207o(parcel);
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i = C0152a.m198g(parcel, n);
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
            return new C0657a(i2, str3, str2, str, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0657a[] bu(int i) {
        return new C0657a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bu(x0);
    }
}
