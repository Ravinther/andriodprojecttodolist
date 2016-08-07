package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.k */
public class C0427k implements Creator<MaskedWallet> {
    static void m1382a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, maskedWallet.getVersionCode());
        C0153b.m232a(parcel, 2, maskedWallet.Yk, false);
        C0153b.m232a(parcel, 3, maskedWallet.Yl, false);
        C0153b.m238a(parcel, 4, maskedWallet.Yq, false);
        C0153b.m232a(parcel, 5, maskedWallet.Yn, false);
        C0153b.m230a(parcel, 6, maskedWallet.Yo, i, false);
        C0153b.m230a(parcel, 7, maskedWallet.Yp, i, false);
        C0153b.m237a(parcel, 8, maskedWallet.YW, i, false);
        C0153b.m237a(parcel, 9, maskedWallet.YX, i, false);
        C0153b.m230a(parcel, 10, maskedWallet.Yr, i, false);
        C0153b.m230a(parcel, 11, maskedWallet.Ys, i, false);
        C0153b.m237a(parcel, 12, maskedWallet.Yt, i, false);
        C0153b.m222D(parcel, p);
    }

    public MaskedWallet bb(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    strArr = C0152a.m217x(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    address = (Address) C0152a.m187a(parcel, n, Address.CREATOR);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    address2 = (Address) C0152a.m187a(parcel, n, Address.CREATOR);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0152a.m192b(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) C0152a.m192b(parcel, n, OfferWalletObject.CREATOR);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    userAddress = (UserAddress) C0152a.m187a(parcel, n, UserAddress.CREATOR);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    userAddress2 = (UserAddress) C0152a.m187a(parcel, n, UserAddress.CREATOR);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0152a.m192b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public MaskedWallet[] ch(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ch(x0);
    }
}
