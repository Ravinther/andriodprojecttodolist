package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.drive.metadata.internal.f */
public class C0179f implements Creator<MetadataBundle> {
    static void m337a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, metadataBundle.wj);
        C0153b.m227a(parcel, 2, metadataBundle.Ek, false);
        C0153b.m222D(parcel, p);
    }

    public MetadataBundle[] aF(int i) {
        return new MetadataBundle[i];
    }

    public MetadataBundle aa(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    bundle = C0152a.m208o(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aF(x0);
    }
}
