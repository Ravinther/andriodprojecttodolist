package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C0428l implements Creator<MaskedWalletRequest> {
    static void m1383a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0153b.m232a(parcel, 2, maskedWalletRequest.Yl, false);
        C0153b.m235a(parcel, 3, maskedWalletRequest.YY);
        C0153b.m235a(parcel, 4, maskedWalletRequest.YZ);
        C0153b.m235a(parcel, 5, maskedWalletRequest.Za);
        C0153b.m232a(parcel, 6, maskedWalletRequest.Zb, false);
        C0153b.m232a(parcel, 7, maskedWalletRequest.Yg, false);
        C0153b.m232a(parcel, 8, maskedWalletRequest.Zc, false);
        C0153b.m230a(parcel, 9, maskedWalletRequest.Yu, i, false);
        C0153b.m235a(parcel, 10, maskedWalletRequest.Zd);
        C0153b.m235a(parcel, 11, maskedWalletRequest.Ze);
        C0153b.m237a(parcel, 12, maskedWalletRequest.Zf, i, false);
        C0153b.m235a(parcel, 13, maskedWalletRequest.Zg);
        C0153b.m235a(parcel, 14, maskedWalletRequest.Zh);
        C0153b.m241b(parcel, 15, maskedWalletRequest.Zi, false);
        C0153b.m222D(parcel, p);
    }

    public MaskedWalletRequest bc(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    z2 = C0152a.m194c(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    z3 = C0152a.m194c(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    cart = (Cart) C0152a.m187a(parcel, n, Cart.CREATOR);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    z4 = C0152a.m194c(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    z5 = C0152a.m194c(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    countrySpecificationArr = (CountrySpecification[]) C0152a.m192b(parcel, n, CountrySpecification.CREATOR);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    z6 = C0152a.m194c(parcel, n);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    z7 = C0152a.m194c(parcel, n);
                    break;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    arrayList = C0152a.m193c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public MaskedWalletRequest[] ci(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ci(x0);
    }
}
