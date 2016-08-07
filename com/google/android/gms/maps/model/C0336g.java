package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0336g {
    static void m1159a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, polygonOptions.getVersionCode());
        C0153b.m241b(parcel, 2, polygonOptions.getPoints(), false);
        C0153b.m243c(parcel, 3, polygonOptions.hg(), false);
        C0153b.m225a(parcel, 4, polygonOptions.getStrokeWidth());
        C0153b.m242c(parcel, 5, polygonOptions.getStrokeColor());
        C0153b.m242c(parcel, 6, polygonOptions.getFillColor());
        C0153b.m225a(parcel, 7, polygonOptions.getZIndex());
        C0153b.m235a(parcel, 8, polygonOptions.isVisible());
        C0153b.m235a(parcel, 9, polygonOptions.isGeodesic());
        C0153b.m222D(parcel, p);
    }
}
