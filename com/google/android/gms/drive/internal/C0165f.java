package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.drive.internal.f */
public class C0165f implements Creator<CreateContentsRequest> {
    static void m286a(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, createContentsRequest.wj);
        C0153b.m222D(parcel, p);
    }

    public CreateContentsRequest m287G(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CreateContentsRequest(i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CreateContentsRequest[] al(int i) {
        return new CreateContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m287G(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return al(x0);
    }
}
