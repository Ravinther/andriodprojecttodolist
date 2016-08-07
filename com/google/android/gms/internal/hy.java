package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public class hy implements Creator<hx> {
    static void m980a(hx hxVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, hxVar.getId(), false);
        C0153b.m227a(parcel, 2, hxVar.gE(), false);
        C0153b.m230a(parcel, 3, hxVar.gF(), i, false);
        C0153b.m230a(parcel, 4, hxVar.gx(), i, false);
        C0153b.m225a(parcel, 5, hxVar.gy());
        C0153b.m230a(parcel, 6, hxVar.gz(), i, false);
        C0153b.m232a(parcel, 7, hxVar.gG(), false);
        C0153b.m230a(parcel, 8, hxVar.gA(), i, false);
        C0153b.m235a(parcel, 9, hxVar.gB());
        C0153b.m225a(parcel, 10, hxVar.getRating());
        C0153b.m242c(parcel, 11, hxVar.gC());
        C0153b.m226a(parcel, 12, hxVar.gD());
        C0153b.m241b(parcel, 13, hxVar.gw(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hxVar.wj);
        C0153b.m222D(parcel, p);
    }

    public hx aB(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        List list = null;
        Bundle bundle = null;
        hz hzVar = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str2 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    bundle = C0152a.m208o(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    hzVar = (hz) C0152a.m187a(parcel, n, hz.CREATOR);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    latLng = (LatLng) C0152a.m187a(parcel, n, LatLng.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    f = C0152a.m201j(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    latLngBounds = (LatLngBounds) C0152a.m187a(parcel, n, LatLngBounds.CREATOR);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    uri = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    f2 = C0152a.m201j(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    list = C0152a.m193c(parcel, n, ht.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new hx(i, str, list, bundle, hzVar, latLng, f, latLngBounds, str2, uri, z, f2, i2, j);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public hx[] bw(int i) {
        return new hx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bw(x0);
    }
}
