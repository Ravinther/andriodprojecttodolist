package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

public class DataHolderCreator implements Creator<DataHolder> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m151a(DataHolder dataHolder, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m238a(parcel, 1, dataHolder.dH(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataHolder.getVersionCode());
        C0153b.m237a(parcel, 2, dataHolder.dI(), i, false);
        C0153b.m242c(parcel, 3, dataHolder.getStatusCode());
        C0153b.m227a(parcel, 4, dataHolder.getMetadata(), false);
        C0153b.m222D(parcel, p);
    }

    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int o = C0152a.m207o(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    strArr = C0152a.m217x(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    cursorWindowArr = (CursorWindow[]) C0152a.m192b(parcel, n, CursorWindow.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    bundle = C0152a.m208o(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0151a("Overread allowed size end=" + o, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.validateContents();
        return dataHolder;
    }

    public DataHolder[] newArray(int size) {
        return new DataHolder[size];
    }
}
