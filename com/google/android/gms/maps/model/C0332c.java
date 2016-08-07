package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0332c {
    static void m1155a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0153b.m228a(parcel, 2, groundOverlayOptions.he(), false);
        C0153b.m230a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0153b.m225a(parcel, 4, groundOverlayOptions.getWidth());
        C0153b.m225a(parcel, 5, groundOverlayOptions.getHeight());
        C0153b.m230a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0153b.m225a(parcel, 7, groundOverlayOptions.getBearing());
        C0153b.m225a(parcel, 8, groundOverlayOptions.getZIndex());
        C0153b.m235a(parcel, 9, groundOverlayOptions.isVisible());
        C0153b.m225a(parcel, 10, groundOverlayOptions.getTransparency());
        C0153b.m225a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0153b.m225a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0153b.m222D(parcel, p);
    }
}
