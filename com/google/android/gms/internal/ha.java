package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;

public class ha implements Creator<gz> {
    static void m948a(gz gzVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m241b(parcel, 1, gzVar.fT(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gzVar.getVersionCode());
        C0153b.m222D(parcel, p);
    }

    public gz[] aY(int i) {
        return new gz[i];
    }

    public gz am(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    arrayList = C0152a.m193c(parcel, n, GameRequestEntity.CREATOR);
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
            return new gz(i, arrayList);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return am(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aY(x0);
    }
}
