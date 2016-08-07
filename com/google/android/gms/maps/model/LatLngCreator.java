package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1146a(LatLng latLng, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, latLng.getVersionCode());
        C0153b.m224a(parcel, 2, latLng.latitude);
        C0153b.m224a(parcel, 3, latLng.longitude);
        C0153b.m222D(parcel, p);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int o = C0152a.m207o(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    d2 = C0152a.m202k(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    d = C0152a.m202k(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LatLng(i, d2, d);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
