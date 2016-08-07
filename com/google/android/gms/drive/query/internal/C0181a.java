package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C0181a implements Creator<ComparisonFilter> {
    static void m339a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, comparisonFilter.wj);
        C0153b.m230a(parcel, 1, comparisonFilter.EO, i, false);
        C0153b.m230a(parcel, 2, comparisonFilter.EP, i, false);
        C0153b.m222D(parcel, p);
    }

    public ComparisonFilter[] aH(int i) {
        return new ComparisonFilter[i];
    }

    public ComparisonFilter ac(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C0152a.m187a(parcel, n, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    metadataBundle2 = (MetadataBundle) C0152a.m187a(parcel, n, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = C0152a.m198g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ac(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aH(x0);
    }
}
