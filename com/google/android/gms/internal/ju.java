package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class ju implements Creator<jt> {
    static void m1014a(jt jtVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, jtVar.getVersionCode());
        C0153b.m232a(parcel, 2, jtVar.ZN, false);
        C0153b.m232a(parcel, 3, jtVar.description, false);
        C0153b.m222D(parcel, p);
    }

    public jt bm(Parcel parcel) {
        String str = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jt(i, str2, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bm(x0);
    }

    public jt[] cs(int i) {
        return new jt[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cs(x0);
    }
}
