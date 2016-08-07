package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0347k {
    static void m1173a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, visibleRegion.getVersionCode());
        C0153b.m230a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0153b.m230a(parcel, 3, visibleRegion.nearRight, i, false);
        C0153b.m230a(parcel, 4, visibleRegion.farLeft, i, false);
        C0153b.m230a(parcel, 5, visibleRegion.farRight, i, false);
        C0153b.m230a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0153b.m222D(parcel, p);
    }
}
