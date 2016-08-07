package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

public class hk implements Creator<hj> {
    static void m973a(hj hjVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, hjVar.getRequestId(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hjVar.getVersionCode());
        C0153b.m226a(parcel, 2, hjVar.getExpirationTime());
        C0153b.m234a(parcel, 3, hjVar.gn());
        C0153b.m224a(parcel, 4, hjVar.getLatitude());
        C0153b.m224a(parcel, 5, hjVar.getLongitude());
        C0153b.m225a(parcel, 6, hjVar.go());
        C0153b.m242c(parcel, 7, hjVar.gp());
        C0153b.m242c(parcel, 8, hjVar.getNotificationResponsiveness());
        C0153b.m242c(parcel, 9, hjVar.gq());
        C0153b.m222D(parcel, p);
    }

    public hj av(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    s = C0152a.m197f(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    d = C0152a.m202k(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    d2 = C0152a.m202k(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    i4 = C0152a.m198g(parcel, n);
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
            return new hj(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public hj[] bp(int i) {
        return new hj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return av(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bp(x0);
    }
}
