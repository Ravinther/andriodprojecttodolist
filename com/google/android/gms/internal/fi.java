package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class fi implements Creator<fh> {
    static void m760a(fh fhVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, fhVar.getVersionCode());
        C0153b.m229a(parcel, 2, fhVar.eF(), false);
        C0153b.m230a(parcel, 3, fhVar.eG(), i, false);
        C0153b.m222D(parcel, p);
    }

    public fh[] aa(int i) {
        return new fh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m761x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aa(x0);
    }

    public fh m761x(Parcel parcel) {
        fe feVar = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    parcel2 = C0152a.m219z(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    feVar = (fe) C0152a.m187a(parcel, n, fe.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new fh(i, parcel2, feVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
