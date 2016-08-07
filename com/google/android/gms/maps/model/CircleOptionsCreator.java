package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class CircleOptionsCreator implements Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1142a(CircleOptions circleOptions, Parcel parcel, int i) {
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

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0152a.m207o(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    latLng = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    d = C0152a.m202k(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    f2 = C0152a.m201j(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
