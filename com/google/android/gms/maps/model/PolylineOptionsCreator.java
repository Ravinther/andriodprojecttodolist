package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.List;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1149a(PolylineOptions polylineOptions, Parcel parcel, int i) {
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

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0152a.m207o(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    list = C0152a.m193c(parcel, n, LatLng.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    f2 = C0152a.m201j(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    z2 = C0152a.m194c(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
