package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.internal.e */
public class C0185e implements Creator<InFilter> {
    static void m343a(InFilter inFilter, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, inFilter.wj);
        C0153b.m230a(parcel, 1, inFilter.EP, i, false);
        C0153b.m222D(parcel, p);
    }

    public InFilter[] aK(int i) {
        return new InFilter[i];
    }

    public InFilter af(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    metadataBundle = (MetadataBundle) C0152a.m187a(parcel, n, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return af(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aK(x0);
    }
}
