package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1148a(PolygonOptions polygonOptions, Parcel parcel, int i) {
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

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0152a.m207o(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
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
                    list = C0152a.m193c(parcel, n, LatLng.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    C0152a.m190a(parcel, n, arrayList, getClass().getClassLoader());
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
                    z2 = C0152a.m194c(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
