package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.fb.C0630a;
import com.google.android.gms.internal.fe.C0632b;

public class fd implements Creator<C0632b> {
    static void m751a(C0632b c0632b, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, c0632b.versionCode);
        C0153b.m232a(parcel, 2, c0632b.eX, false);
        C0153b.m230a(parcel, 3, c0632b.CI, i, false);
        C0153b.m222D(parcel, p);
    }

    public C0632b[] m752X(int i) {
        return new C0632b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m753u(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m752X(x0);
    }

    public C0632b m753u(Parcel parcel) {
        C0630a c0630a = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    c0630a = (C0630a) C0152a.m187a(parcel, n, C0630a.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0632b(i, str, c0630a);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
