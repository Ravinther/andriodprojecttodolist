package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class an implements Creator<am> {
    static void m419a(am amVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, amVar.versionCode);
        C0153b.m242c(parcel, 2, amVar.lI);
        C0153b.m242c(parcel, 3, amVar.backgroundColor);
        C0153b.m242c(parcel, 4, amVar.lJ);
        C0153b.m242c(parcel, 5, amVar.lK);
        C0153b.m242c(parcel, 6, amVar.lL);
        C0153b.m242c(parcel, 7, amVar.lM);
        C0153b.m242c(parcel, 8, amVar.lN);
        C0153b.m242c(parcel, 9, amVar.lO);
        C0153b.m232a(parcel, 10, amVar.lP, false);
        C0153b.m242c(parcel, 11, amVar.lQ);
        C0153b.m232a(parcel, 12, amVar.lR, false);
        C0153b.m242c(parcel, 13, amVar.lS);
        C0153b.m242c(parcel, 14, amVar.lT);
        C0153b.m232a(parcel, 15, amVar.lU, false);
        C0153b.m222D(parcel, p);
    }

    public am m420c(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i4 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    i5 = C0152a.m198g(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i6 = C0152a.m198g(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i7 = C0152a.m198g(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    i8 = C0152a.m198g(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    i9 = C0152a.m198g(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    i10 = C0152a.m198g(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    i11 = C0152a.m198g(parcel, n);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    i12 = C0152a.m198g(parcel, n);
                    break;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new am(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m420c(x0);
    }

    public am[] m421e(int i) {
        return new am[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m421e(x0);
    }
}
