package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.internal.c */
public class C0183c implements Creator<FilterHolder> {
    static void m341a(FilterHolder filterHolder, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m230a(parcel, 1, filterHolder.ER, i, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, filterHolder.wj);
        C0153b.m230a(parcel, 2, filterHolder.ES, i, false);
        C0153b.m230a(parcel, 3, filterHolder.ET, i, false);
        C0153b.m230a(parcel, 4, filterHolder.EU, i, false);
        C0153b.m230a(parcel, 5, filterHolder.EV, i, false);
        C0153b.m222D(parcel, p);
    }

    public FilterHolder[] aJ(int i) {
        return new FilterHolder[i];
    }

    public FilterHolder ae(Parcel parcel) {
        InFilter inFilter = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    comparisonFilter = (ComparisonFilter) C0152a.m187a(parcel, n, ComparisonFilter.CREATOR);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    fieldOnlyFilter = (FieldOnlyFilter) C0152a.m187a(parcel, n, FieldOnlyFilter.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    logicalFilter = (LogicalFilter) C0152a.m187a(parcel, n, LogicalFilter.CREATOR);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    notFilter = (NotFilter) C0152a.m187a(parcel, n, NotFilter.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    inFilter = (InFilter) C0152a.m187a(parcel, n, InFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ae(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aJ(x0);
    }
}
