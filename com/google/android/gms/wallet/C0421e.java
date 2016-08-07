package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.wallet.e */
public class C0421e implements Creator<C0808d> {
    static void m1376a(C0808d c0808d, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, c0808d.getVersionCode());
        C0153b.m230a(parcel, 2, c0808d.Yj, i, false);
        C0153b.m222D(parcel, p);
    }

    public C0808d aV(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    loyaltyWalletObject = (LoyaltyWalletObject) C0152a.m187a(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0808d(i, loyaltyWalletObject);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0808d[] cb(int i) {
        return new C0808d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cb(x0);
    }
}
