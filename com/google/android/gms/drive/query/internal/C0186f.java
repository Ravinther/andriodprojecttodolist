package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.f */
public class C0186f implements Creator<LogicalFilter> {
    static void m344a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, logicalFilter.wj);
        C0153b.m230a(parcel, 1, logicalFilter.EO, i, false);
        C0153b.m241b(parcel, 2, logicalFilter.EY, false);
        C0153b.m222D(parcel, p);
    }

    public LogicalFilter[] aL(int i) {
        return new LogicalFilter[i];
    }

    public LogicalFilter ag(Parcel parcel) {
        List list = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            Operator operator2;
            ArrayList c;
            int n = C0152a.m205n(parcel);
            List list2;
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C0152a.m187a(parcel, n, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    c = C0152a.m193c(parcel, n, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    List list3 = list;
                    operator2 = operator;
                    i2 = C0152a.m198g(parcel, n);
                    list2 = list3;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == o) {
            return new LogicalFilter(i, operator, list);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
