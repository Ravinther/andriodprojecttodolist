package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class ia implements Creator<hz> {
    static void m981a(hz hzVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, hzVar.name, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hzVar.versionCode);
        C0153b.m232a(parcel, 2, hzVar.Ov, false);
        C0153b.m232a(parcel, 3, hzVar.Ow, false);
        C0153b.m232a(parcel, 4, hzVar.Ox, false);
        C0153b.m233a(parcel, 5, hzVar.Oy, false);
        C0153b.m222D(parcel, p);
    }

    public hz aC(Parcel parcel) {
        List list = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    list = C0152a.m218y(parcel, n);
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
            return new hz(i, str4, str3, str2, str, list);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public hz[] bx(int i) {
        return new hz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bx(x0);
    }
}
