package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class ho implements Creator<hn> {
    static void m974a(hn hnVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m241b(parcel, 1, hnVar.LA, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hnVar.wj);
        C0153b.m232a(parcel, 2, hnVar.gr(), false);
        C0153b.m235a(parcel, 3, hnVar.gs());
        C0153b.m222D(parcel, p);
    }

    public hn aw(Parcel parcel) {
        String str = null;
        boolean z = false;
        int o = C0152a.m207o(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    list = C0152a.m193c(parcel, n, ht.CREATOR);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    z = C0152a.m194c(parcel, n);
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
            return new hn(i, list, str, z);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public hn[] bq(int i) {
        return new hn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bq(x0);
    }
}
