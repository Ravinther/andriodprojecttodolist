package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1147a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, markerOptions.getVersionCode());
        C0153b.m230a(parcel, 2, markerOptions.getPosition(), i, false);
        C0153b.m232a(parcel, 3, markerOptions.getTitle(), false);
        C0153b.m232a(parcel, 4, markerOptions.getSnippet(), false);
        C0153b.m228a(parcel, 5, markerOptions.hf(), false);
        C0153b.m225a(parcel, 6, markerOptions.getAnchorU());
        C0153b.m225a(parcel, 7, markerOptions.getAnchorV());
        C0153b.m235a(parcel, 8, markerOptions.isDraggable());
        C0153b.m235a(parcel, 9, markerOptions.isVisible());
        C0153b.m235a(parcel, 10, markerOptions.isFlat());
        C0153b.m225a(parcel, 11, markerOptions.getRotation());
        C0153b.m225a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0153b.m225a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0153b.m225a(parcel, 14, markerOptions.getAlpha());
        C0153b.m222D(parcel, p);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
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
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    iBinder = C0152a.m206n(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    f2 = C0152a.m201j(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    z2 = C0152a.m194c(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    z3 = C0152a.m194c(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    f3 = C0152a.m201j(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    f4 = C0152a.m201j(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    f5 = C0152a.m201j(parcel, n);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    f6 = C0152a.m201j(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
