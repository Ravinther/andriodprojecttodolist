package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class TileOverlayOptionsCreator implements Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1151a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0153b.m228a(parcel, 2, tileOverlayOptions.hh(), false);
        C0153b.m235a(parcel, 3, tileOverlayOptions.isVisible());
        C0153b.m225a(parcel, 4, tileOverlayOptions.getZIndex());
        C0153b.m235a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0153b.m222D(parcel, p);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0152a.m207o(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    iBinder = C0152a.m206n(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    z2 = C0152a.m194c(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
