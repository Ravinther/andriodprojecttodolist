package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0346j {
    static void m1172a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0153b.m228a(parcel, 2, tileOverlayOptions.hh(), false);
        C0153b.m235a(parcel, 3, tileOverlayOptions.isVisible());
        C0153b.m225a(parcel, 4, tileOverlayOptions.getZIndex());
        C0153b.m222D(parcel, p);
    }
}
