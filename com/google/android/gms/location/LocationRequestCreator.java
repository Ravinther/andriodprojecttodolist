package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1113a(LocationRequest locationRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, locationRequest.mPriority);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequest.getVersionCode());
        C0153b.m226a(parcel, 2, locationRequest.Lc);
        C0153b.m226a(parcel, 3, locationRequest.Ld);
        C0153b.m235a(parcel, 4, locationRequest.Le);
        C0153b.m226a(parcel, 5, locationRequest.KV);
        C0153b.m242c(parcel, 6, locationRequest.Lf);
        C0153b.m225a(parcel, 7, locationRequest.Lg);
        C0153b.m222D(parcel, p);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0152a.m207o(parcel);
        int i = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    j3 = C0152a.m199h(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
