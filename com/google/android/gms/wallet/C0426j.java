package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C0426j implements Creator<LoyaltyWalletObject> {
    static void m1381a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0153b.m232a(parcel, 2, loyaltyWalletObject.eN, false);
        C0153b.m232a(parcel, 3, loyaltyWalletObject.YC, false);
        C0153b.m232a(parcel, 4, loyaltyWalletObject.YD, false);
        C0153b.m232a(parcel, 5, loyaltyWalletObject.YE, false);
        C0153b.m232a(parcel, 6, loyaltyWalletObject.YF, false);
        C0153b.m232a(parcel, 7, loyaltyWalletObject.YG, false);
        C0153b.m232a(parcel, 8, loyaltyWalletObject.YH, false);
        C0153b.m232a(parcel, 9, loyaltyWalletObject.YI, false);
        C0153b.m232a(parcel, 10, loyaltyWalletObject.YJ, false);
        C0153b.m232a(parcel, 11, loyaltyWalletObject.YK, false);
        C0153b.m242c(parcel, 12, loyaltyWalletObject.state);
        C0153b.m241b(parcel, 13, loyaltyWalletObject.YL, false);
        C0153b.m230a(parcel, 14, loyaltyWalletObject.YM, i, false);
        C0153b.m241b(parcel, 15, loyaltyWalletObject.YN, false);
        C0153b.m232a(parcel, 17, loyaltyWalletObject.YP, false);
        C0153b.m232a(parcel, 16, loyaltyWalletObject.YO, false);
        C0153b.m235a(parcel, 19, loyaltyWalletObject.YR);
        C0153b.m241b(parcel, 18, loyaltyWalletObject.YQ, false);
        C0153b.m241b(parcel, 21, loyaltyWalletObject.YT, false);
        C0153b.m241b(parcel, 20, loyaltyWalletObject.YS, false);
        C0153b.m230a(parcel, 23, loyaltyWalletObject.YV, i, false);
        C0153b.m241b(parcel, 22, loyaltyWalletObject.YU, false);
        C0153b.m222D(parcel, p);
    }

    public LoyaltyWalletObject ba(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList eH = fj.eH();
        jr jrVar = null;
        ArrayList eH2 = fj.eH();
        String str11 = null;
        String str12 = null;
        ArrayList eH3 = fj.eH();
        boolean z = false;
        ArrayList eH4 = fj.eH();
        ArrayList eH5 = fj.eH();
        ArrayList eH6 = fj.eH();
        jl jlVar = null;
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
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str5 = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str6 = C0152a.m204m(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str7 = C0152a.m204m(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    str8 = C0152a.m204m(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    str9 = C0152a.m204m(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    str10 = C0152a.m204m(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    eH = C0152a.m193c(parcel, n, jv.CREATOR);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    jrVar = (jr) C0152a.m187a(parcel, n, jr.CREATOR);
                    break;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    eH2 = C0152a.m193c(parcel, n, LatLng.CREATOR);
                    break;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    str11 = C0152a.m204m(parcel, n);
                    break;
                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                    str12 = C0152a.m204m(parcel, n);
                    break;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    eH3 = C0152a.m193c(parcel, n, jj.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case 20:
                    eH4 = C0152a.m193c(parcel, n, jt.CREATOR);
                    break;
                case 21:
                    eH5 = C0152a.m193c(parcel, n, jp.CREATOR);
                    break;
                case 22:
                    eH6 = C0152a.m193c(parcel, n, jt.CREATOR);
                    break;
                case 23:
                    jlVar = (jl) C0152a.m187a(parcel, n, jl.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, eH, jrVar, eH2, str11, str12, eH3, z, eH4, eH5, eH6, jlVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public LoyaltyWalletObject[] cg(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cg(x0);
    }
}
