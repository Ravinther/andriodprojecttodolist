package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.wallet.c */
public class C0420c implements Creator<CountrySpecification> {
    static void m1375a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, countrySpecification.getVersionCode());
        C0153b.m232a(parcel, 2, countrySpecification.oQ, false);
        C0153b.m222D(parcel, p);
    }

    public CountrySpecification aU(Parcel parcel) {
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
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CountrySpecification(i, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CountrySpecification[] ca(int i) {
        return new CountrySpecification[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ca(x0);
    }
}
