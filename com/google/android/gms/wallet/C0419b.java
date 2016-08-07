package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C0419b implements Creator<Cart> {
    static void m1374a(Cart cart, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, cart.getVersionCode());
        C0153b.m232a(parcel, 2, cart.Yf, false);
        C0153b.m232a(parcel, 3, cart.Yg, false);
        C0153b.m241b(parcel, 4, cart.Yh, false);
        C0153b.m222D(parcel, p);
    }

    public Cart aT(Parcel parcel) {
        String str = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                    arrayList = C0152a.m193c(parcel, n, LineItem.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public Cart[] bZ(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bZ(x0);
    }
}
