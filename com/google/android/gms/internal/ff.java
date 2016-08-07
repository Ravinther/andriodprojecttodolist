package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.fe.C0631a;
import java.util.ArrayList;

public class ff implements Creator<fe> {
    static void m754a(fe feVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, feVar.getVersionCode());
        C0153b.m241b(parcel, 2, feVar.eC(), false);
        C0153b.m232a(parcel, 3, feVar.eD(), false);
        C0153b.m222D(parcel, p);
    }

    public fe[] m755Y(int i) {
        return new fe[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m756v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m755Y(x0);
    }

    public fe m756v(Parcel parcel) {
        String str = null;
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
                    arrayList = C0152a.m193c(parcel, n, C0631a.CREATOR);
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
            return new fe(i, arrayList, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
