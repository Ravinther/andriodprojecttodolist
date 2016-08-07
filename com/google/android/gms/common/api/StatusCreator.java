package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

public class StatusCreator implements Creator<Status> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m139a(Status status, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, status.getStatusCode());
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, status.getVersionCode());
        C0153b.m232a(parcel, 2, status.dF(), false);
        C0153b.m230a(parcel, 3, status.dE(), i, false);
        C0153b.m222D(parcel, p);
    }

    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    pendingIntent = (PendingIntent) C0152a.m187a(parcel, n, PendingIntent.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public Status[] newArray(int size) {
        return new Status[size];
    }
}
