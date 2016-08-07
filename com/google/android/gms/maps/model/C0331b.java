package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0331b {
    static void m1154a(CircleOptions circleOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, circleOptions.getVersionCode());
        C0153b.m230a(parcel, 2, circleOptions.getCenter(), i, false);
        C0153b.m224a(parcel, 3, circleOptions.getRadius());
        C0153b.m225a(parcel, 4, circleOptions.getStrokeWidth());
        C0153b.m242c(parcel, 5, circleOptions.getStrokeColor());
        C0153b.m242c(parcel, 6, circleOptions.getFillColor());
        C0153b.m225a(parcel, 7, circleOptions.getZIndex());
        C0153b.m235a(parcel, 8, circleOptions.isVisible());
        C0153b.m222D(parcel, p);
    }
}
