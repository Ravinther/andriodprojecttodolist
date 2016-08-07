package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

public class hu implements Creator<ht> {
    static void m977a(ht htVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, htVar.Oc, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, htVar.wj);
        C0153b.m222D(parcel, p);
    }

    public ht az(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str = C0152a.m204m(parcel, n);
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
            return new ht(i, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public ht[] bt(int i) {
        return new ht[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return az(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bt(x0);
    }
}
