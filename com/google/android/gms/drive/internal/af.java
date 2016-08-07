package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class af implements Creator<OnMetadataResponse> {
    static void m266a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, onMetadataResponse.wj);
        C0153b.m230a(parcel, 2, onMetadataResponse.Ds, i, false);
        C0153b.m222D(parcel, p);
    }

    public OnMetadataResponse m267T(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    metadataBundle = (MetadataBundle) C0152a.m187a(parcel, n, MetadataBundle.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public OnMetadataResponse[] ay(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m267T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ay(x0);
    }
}
