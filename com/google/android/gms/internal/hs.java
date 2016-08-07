package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationRequest;

public class hs implements Creator<hr> {
    static void m976a(hr hrVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m230a(parcel, 1, hrVar.gu(), i, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hrVar.wj);
        C0153b.m230a(parcel, 2, hrVar.gv(), i, false);
        C0153b.m222D(parcel, p);
    }

    public hr ay(Parcel parcel) {
        hn hnVar = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        LocationRequest locationRequest = null;
        while (parcel.dataPosition() < o) {
            int i2;
            hn hnVar2;
            LocationRequest locationRequest2;
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = i;
                    LocationRequest locationRequest3 = (LocationRequest) C0152a.m187a(parcel, n, LocationRequest.CREATOR);
                    hnVar2 = hnVar;
                    locationRequest2 = locationRequest3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    hnVar2 = (hn) C0152a.m187a(parcel, n, hn.CREATOR);
                    locationRequest2 = locationRequest;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    hn hnVar3 = hnVar;
                    locationRequest2 = locationRequest;
                    i2 = C0152a.m198g(parcel, n);
                    hnVar2 = hnVar3;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    hnVar2 = hnVar;
                    locationRequest2 = locationRequest;
                    i2 = i;
                    break;
            }
            i = i2;
            locationRequest = locationRequest2;
            hnVar = hnVar2;
        }
        if (parcel.dataPosition() == o) {
            return new hr(i, locationRequest, hnVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public hr[] bs(int i) {
        return new hr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bs(x0);
    }
}
