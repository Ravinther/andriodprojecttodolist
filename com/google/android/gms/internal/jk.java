package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.ArrayList;

public class jk implements Creator<jj> {
    static void m1009a(jj jjVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, jjVar.getVersionCode());
        C0153b.m232a(parcel, 2, jjVar.ZA, false);
        C0153b.m232a(parcel, 3, jjVar.ZB, false);
        C0153b.m241b(parcel, 4, jjVar.ZC, false);
        C0153b.m222D(parcel, p);
    }

    public jj bh(Parcel parcel) {
        String str = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        ArrayList eH = fj.eH();
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
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    eH = C0152a.m193c(parcel, n, jh.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jj(i, str2, str, eH);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public jj[] cn(int i) {
        return new jj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cn(x0);
    }
}
