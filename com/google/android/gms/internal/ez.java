package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ey.C0617a;
import java.util.ArrayList;

public class ez implements Creator<ey> {
    static void m734a(ey eyVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, eyVar.getVersionCode());
        C0153b.m241b(parcel, 2, eyVar.ek(), false);
        C0153b.m222D(parcel, p);
    }

    public ey[] m735U(int i) {
        return new ey[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m736r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m735U(x0);
    }

    public ey m736r(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    arrayList = C0152a.m193c(parcel, n, C0617a.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ey(i, arrayList);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
