package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1152a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, visibleRegion.getVersionCode());
        C0153b.m230a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0153b.m230a(parcel, 3, visibleRegion.nearRight, i, false);
        C0153b.m230a(parcel, 4, visibleRegion.farLeft, i, false);
        C0153b.m230a(parcel, 5, visibleRegion.farRight, i, false);
        C0153b.m230a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0153b.m222D(parcel, p);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    latLng4 = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    latLng3 = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    latLng2 = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    latLng = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    latLngBounds = (LatLngBounds) C0152a.m187a(parcel, n, LatLngBounds.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
