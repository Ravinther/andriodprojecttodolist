package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1145a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, latLngBounds.getVersionCode());
        C0153b.m230a(parcel, 2, latLngBounds.southwest, i, false);
        C0153b.m230a(parcel, 3, latLngBounds.northeast, i, false);
        C0153b.m222D(parcel, p);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < o) {
            int g;
            LatLng latLng3;
            int n = C0152a.m205n(parcel);
            LatLng latLng4;
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = C0152a.m198g(parcel, n);
                    latLng3 = latLng4;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    g = i;
                    latLng4 = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    latLng3 = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == o) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
