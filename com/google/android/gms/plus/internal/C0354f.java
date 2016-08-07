package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.plus.internal.f */
public class C0354f implements Creator<PlusCommonExtras> {
    static void m1203a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, plusCommonExtras.ho(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, plusCommonExtras.getVersionCode());
        C0153b.m232a(parcel, 2, plusCommonExtras.hp(), false);
        C0153b.m222D(parcel, p);
    }

    public PlusCommonExtras aE(Parcel parcel) {
        String str = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
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
            return new PlusCommonExtras(i, str2, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public PlusCommonExtras[] bB(int i) {
        return new PlusCommonExtras[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bB(x0);
    }
}
