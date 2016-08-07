package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.f */
public class C0422f implements Creator<FullWallet> {
    static void m1377a(FullWallet fullWallet, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, fullWallet.getVersionCode());
        C0153b.m232a(parcel, 2, fullWallet.Yk, false);
        C0153b.m232a(parcel, 3, fullWallet.Yl, false);
        C0153b.m230a(parcel, 4, fullWallet.Ym, i, false);
        C0153b.m232a(parcel, 5, fullWallet.Yn, false);
        C0153b.m230a(parcel, 6, fullWallet.Yo, i, false);
        C0153b.m230a(parcel, 7, fullWallet.Yp, i, false);
        C0153b.m238a(parcel, 8, fullWallet.Yq, false);
        C0153b.m230a(parcel, 9, fullWallet.Yr, i, false);
        C0153b.m230a(parcel, 10, fullWallet.Ys, i, false);
        C0153b.m237a(parcel, 11, fullWallet.Yt, i, false);
        C0153b.m222D(parcel, p);
    }

    public FullWallet aW(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    proxyCard = (ProxyCard) C0152a.m187a(parcel, n, ProxyCard.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    address2 = (Address) C0152a.m187a(parcel, n, Address.CREATOR);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    address = (Address) C0152a.m187a(parcel, n, Address.CREATOR);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    strArr = C0152a.m217x(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    userAddress2 = (UserAddress) C0152a.m187a(parcel, n, UserAddress.CREATOR);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    userAddress = (UserAddress) C0152a.m187a(parcel, n, UserAddress.CREATOR);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0152a.m192b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public FullWallet[] cc(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cc(x0);
    }
}
