package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class aa implements Creator<OnDownloadProgressResponse> {
    static void m256a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, onDownloadProgressResponse.wj);
        C0153b.m226a(parcel, 2, onDownloadProgressResponse.DZ);
        C0153b.m226a(parcel, 3, onDownloadProgressResponse.Ea);
        C0153b.m222D(parcel, p);
    }

    public OnDownloadProgressResponse m257O(Parcel parcel) {
        long j = 0;
        int o = C0152a.m207o(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public OnDownloadProgressResponse[] at(int i) {
        return new OnDownloadProgressResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m257O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return at(x0);
    }
}
