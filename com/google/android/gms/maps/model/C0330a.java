package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0330a {
    static void m1153a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, cameraPosition.getVersionCode());
        C0153b.m230a(parcel, 2, cameraPosition.target, i, false);
        C0153b.m225a(parcel, 3, cameraPosition.zoom);
        C0153b.m225a(parcel, 4, cameraPosition.tilt);
        C0153b.m225a(parcel, 5, cameraPosition.bearing);
        C0153b.m222D(parcel, p);
    }
}
