package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.location.c */
public class C0310c implements Creator<C0676b> {
    static void m1114a(C0676b c0676b, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, c0676b.Lh);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0676b.getVersionCode());
        C0153b.m242c(parcel, 2, c0676b.Li);
        C0153b.m226a(parcel, 3, c0676b.Lj);
        C0153b.m222D(parcel, p);
    }

    public C0676b au(Parcel parcel) {
        int i = 1;
        int o = C0152a.m207o(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    j = C0152a.m199h(parcel, n);
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
            return new C0676b(i2, i3, i, j);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0676b[] bm(int i) {
        return new C0676b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return au(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bm(x0);
    }
}
