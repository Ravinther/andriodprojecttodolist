package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.List;

public class cg implements Creator<cf> {
    static void m475a(cf cfVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, cfVar.versionCode);
        C0153b.m232a(parcel, 2, cfVar.nw, false);
        C0153b.m232a(parcel, 3, cfVar.oi, false);
        C0153b.m233a(parcel, 4, cfVar.mt, false);
        C0153b.m242c(parcel, 5, cfVar.errorCode);
        C0153b.m233a(parcel, 6, cfVar.mu, false);
        C0153b.m226a(parcel, 7, cfVar.oj);
        C0153b.m235a(parcel, 8, cfVar.ok);
        C0153b.m226a(parcel, 9, cfVar.ol);
        C0153b.m233a(parcel, 10, cfVar.om, false);
        C0153b.m226a(parcel, 11, cfVar.mx);
        C0153b.m242c(parcel, 12, cfVar.orientation);
        C0153b.m232a(parcel, 13, cfVar.on, false);
        C0153b.m226a(parcel, 14, cfVar.oo);
        C0153b.m222D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m476g(x0);
    }

    public cf m476g(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
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
                    list = C0152a.m218y(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    list2 = C0152a.m218y(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    list3 = C0152a.m218y(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    j3 = C0152a.m199h(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    j4 = C0152a.m199h(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cf(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public cf[] m477l(int i) {
        return new cf[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m477l(x0);
    }
}
