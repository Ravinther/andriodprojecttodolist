package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class ex implements Creator<ew> {
    static void m731a(ew ewVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, ewVar.getVersionCode());
        C0153b.m230a(parcel, 2, ewVar.ei(), i, false);
        C0153b.m222D(parcel, p);
    }

    public ew[] m732T(int i) {
        return new ew[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m733q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m732T(x0);
    }

    public ew m733q(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        ey eyVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    eyVar = (ey) C0152a.m187a(parcel, n, ey.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ew(i, eyVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
