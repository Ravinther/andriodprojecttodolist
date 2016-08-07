package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class GroundOverlayOptionsCreator implements Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1143a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
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

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
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
                    latLng = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    f2 = C0152a.m201j(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    latLngBounds = (LatLngBounds) C0152a.m187a(parcel, n, LatLngBounds.CREATOR);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    f3 = C0152a.m201j(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    f4 = C0152a.m201j(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    f5 = C0152a.m201j(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    f6 = C0152a.m201j(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    f7 = C0152a.m201j(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
