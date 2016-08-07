package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class dc implements Creator<db> {
    static void m567a(db dbVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, dbVar.versionCode);
        C0153b.m232a(parcel, 2, dbVar.pU, false);
        C0153b.m242c(parcel, 3, dbVar.pV);
        C0153b.m242c(parcel, 4, dbVar.pW);
        C0153b.m235a(parcel, 5, dbVar.pX);
        C0153b.m222D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m568h(x0);
    }

    public db m568h(Parcel parcel) {
        boolean z = false;
        int o = C0152a.m207o(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new db(i3, str, i2, i, z);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m569o(x0);
    }

    public db[] m569o(int i) {
        return new db[i];
    }
}
