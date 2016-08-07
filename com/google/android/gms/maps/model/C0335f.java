package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0335f {
    static void m1158a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, markerOptions.getVersionCode());
        C0153b.m230a(parcel, 2, markerOptions.getPosition(), i, false);
        C0153b.m232a(parcel, 3, markerOptions.getTitle(), false);
        C0153b.m232a(parcel, 4, markerOptions.getSnippet(), false);
        C0153b.m228a(parcel, 5, markerOptions.hf(), false);
        C0153b.m225a(parcel, 6, markerOptions.getAnchorU());
        C0153b.m225a(parcel, 7, markerOptions.getAnchorV());
        C0153b.m235a(parcel, 8, markerOptions.isDraggable());
        C0153b.m235a(parcel, 9, markerOptions.isVisible());
        C0153b.m222D(parcel, p);
    }
}
