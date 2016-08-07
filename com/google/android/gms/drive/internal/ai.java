package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.query.Query;

public class ai implements Creator<QueryRequest> {
    static void m272a(QueryRequest queryRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, queryRequest.wj);
        C0153b.m230a(parcel, 2, queryRequest.Ef, i, false);
        C0153b.m222D(parcel, p);
    }

    public QueryRequest m273W(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    query = (Query) C0152a.m187a(parcel, n, Query.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new QueryRequest(i, query);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public QueryRequest[] aB(int i) {
        return new QueryRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m273W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aB(x0);
    }
}
