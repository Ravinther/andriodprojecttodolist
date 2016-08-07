package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0180a implements Creator<Query> {
    static void m338a(Query query, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, query.wj);
        C0153b.m230a(parcel, 1, query.EL, i, false);
        C0153b.m232a(parcel, 3, query.EM, false);
        C0153b.m222D(parcel, p);
    }

    public Query[] aG(int i) {
        return new Query[i];
    }

    public Query ab(Parcel parcel) {
        String str = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < o) {
            int i2;
            String str2;
            LogicalFilter logicalFilter2;
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = i;
                    LogicalFilter logicalFilter3 = (LogicalFilter) C0152a.m187a(parcel, n, LogicalFilter.CREATOR);
                    str2 = str;
                    logicalFilter2 = logicalFilter3;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str2 = C0152a.m204m(parcel, n);
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    String str3 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = C0152a.m198g(parcel, n);
                    str2 = str3;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
            }
            i = i2;
            logicalFilter = logicalFilter2;
            str = str2;
        }
        if (parcel.dataPosition() == o) {
            return new Query(i, logicalFilter, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ab(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
