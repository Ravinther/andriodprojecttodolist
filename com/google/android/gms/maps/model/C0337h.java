package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0337h {
    static void m1160a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, polylineOptions.getVersionCode());
        C0153b.m241b(parcel, 2, polylineOptions.getPoints(), false);
        C0153b.m225a(parcel, 3, polylineOptions.getWidth());
        C0153b.m242c(parcel, 4, polylineOptions.getColor());
        C0153b.m225a(parcel, 5, polylineOptions.getZIndex());
        C0153b.m235a(parcel, 6, polylineOptions.isVisible());
        C0153b.m235a(parcel, 7, polylineOptions.isGeodesic());
        C0153b.m222D(parcel, p);
    }
}
