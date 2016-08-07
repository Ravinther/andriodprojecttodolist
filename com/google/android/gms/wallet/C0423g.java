package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.wallet.g */
public class C0423g implements Creator<FullWalletRequest> {
    static void m1378a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, fullWalletRequest.getVersionCode());
        C0153b.m232a(parcel, 2, fullWalletRequest.Yk, false);
        C0153b.m232a(parcel, 3, fullWalletRequest.Yl, false);
        C0153b.m230a(parcel, 4, fullWalletRequest.Yu, i, false);
        C0153b.m222D(parcel, p);
    }

    public FullWalletRequest aX(Parcel parcel) {
        Cart cart = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
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
                    cart = (Cart) C0152a.m187a(parcel, n, Cart.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public FullWalletRequest[] cd(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cd(x0);
    }
}
