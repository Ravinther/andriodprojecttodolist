package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.wallet.h */
public class C0424h implements Creator<InstrumentInfo> {
    static void m1379a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, instrumentInfo.getVersionCode());
        C0153b.m232a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        C0153b.m232a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        C0153b.m222D(parcel, p);
    }

    public InstrumentInfo aY(Parcel parcel) {
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
            return new InstrumentInfo(i, str2, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public InstrumentInfo[] ce(int i) {
        return new InstrumentInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ce(x0);
    }
}
