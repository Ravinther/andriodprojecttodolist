package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class CameraPositionCreator implements Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1141a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, cameraPosition.getVersionCode());
        C0153b.m230a(parcel, 2, cameraPosition.target, i, false);
        C0153b.m225a(parcel, 3, cameraPosition.zoom);
        C0153b.m225a(parcel, 4, cameraPosition.tilt);
        C0153b.m225a(parcel, 5, cameraPosition.bearing);
        C0153b.m222D(parcel, p);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int o = C0152a.m207o(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    latLng = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    f3 = C0152a.m201j(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    f2 = C0152a.m201j(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CameraPosition[] newArray(int size) {
        return new CameraPosition[size];
    }
}
