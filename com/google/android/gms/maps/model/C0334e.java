package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0334e {
    static void m1157a(LatLng latLng, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, latLng.getVersionCode());
        C0153b.m224a(parcel, 2, latLng.latitude);
        C0153b.m224a(parcel, 3, latLng.longitude);
        C0153b.m222D(parcel, p);
    }
}
