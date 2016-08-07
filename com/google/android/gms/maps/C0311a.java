package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.maps.a */
public class C0311a {
    static void m1117a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, googleMapOptions.getVersionCode());
        C0153b.m223a(parcel, 2, googleMapOptions.gN());
        C0153b.m223a(parcel, 3, googleMapOptions.gO());
        C0153b.m242c(parcel, 4, googleMapOptions.getMapType());
        C0153b.m230a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0153b.m223a(parcel, 6, googleMapOptions.gP());
        C0153b.m223a(parcel, 7, googleMapOptions.gQ());
        C0153b.m223a(parcel, 8, googleMapOptions.gR());
        C0153b.m223a(parcel, 9, googleMapOptions.gS());
        C0153b.m223a(parcel, 10, googleMapOptions.gT());
        C0153b.m223a(parcel, 11, googleMapOptions.gU());
        C0153b.m222D(parcel, p);
    }
}
