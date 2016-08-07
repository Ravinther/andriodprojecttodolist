package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0210b implements Creator<UserAddress> {
    static void m377a(UserAddress userAddress, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, userAddress.getVersionCode());
        C0153b.m232a(parcel, 2, userAddress.name, false);
        C0153b.m232a(parcel, 3, userAddress.KB, false);
        C0153b.m232a(parcel, 4, userAddress.KC, false);
        C0153b.m232a(parcel, 5, userAddress.KD, false);
        C0153b.m232a(parcel, 6, userAddress.KE, false);
        C0153b.m232a(parcel, 7, userAddress.KF, false);
        C0153b.m232a(parcel, 8, userAddress.KG, false);
        C0153b.m232a(parcel, 9, userAddress.KH, false);
        C0153b.m232a(parcel, 10, userAddress.oQ, false);
        C0153b.m232a(parcel, 11, userAddress.KI, false);
        C0153b.m232a(parcel, 12, userAddress.KJ, false);
        C0153b.m232a(parcel, 13, userAddress.KK, false);
        C0153b.m235a(parcel, 14, userAddress.KL);
        C0153b.m232a(parcel, 15, userAddress.KM, false);
        C0153b.m232a(parcel, 16, userAddress.KN, false);
        C0153b.m222D(parcel, p);
    }

    public UserAddress at(Parcel parcel) {
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
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str11 = C0152a.m204m(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    str12 = C0152a.m204m(parcel, n);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    str13 = C0152a.m204m(parcel, n);
                    break;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    str14 = C0152a.m204m(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public UserAddress[] bg(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return at(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}
