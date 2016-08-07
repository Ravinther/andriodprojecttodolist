package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0338i {
    static void m1161a(Tile tile, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, tile.getVersionCode());
        C0153b.m242c(parcel, 2, tile.width);
        C0153b.m242c(parcel, 3, tile.height);
        C0153b.m236a(parcel, 4, tile.data, false);
        C0153b.m222D(parcel, p);
    }
}
