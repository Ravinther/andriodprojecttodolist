package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0333d {
    static void m1156a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, latLngBounds.getVersionCode());
        C0153b.m230a(parcel, 2, latLngBounds.southwest, i, false);
        C0153b.m230a(parcel, 3, latLngBounds.northeast, i, false);
        C0153b.m222D(parcel, p);
    }
}
