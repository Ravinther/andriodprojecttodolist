package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.wallet.o */
public class C0431o implements Creator<ProxyCard> {
    static void m1386a(ProxyCard proxyCard, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, proxyCard.getVersionCode());
        C0153b.m232a(parcel, 2, proxyCard.Zn, false);
        C0153b.m232a(parcel, 3, proxyCard.Zo, false);
        C0153b.m242c(parcel, 4, proxyCard.Zp);
        C0153b.m242c(parcel, 5, proxyCard.Zq);
        C0153b.m222D(parcel, p);
    }

    public ProxyCard bf(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public ProxyCard[] cl(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cl(x0);
    }
}
