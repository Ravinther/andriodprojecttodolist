package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.List;

public class aa implements Creator<C0673z> {
    static void m378a(C0673z c0673z, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, c0673z.versionCode);
        C0153b.m226a(parcel, 2, c0673z.le);
        C0153b.m227a(parcel, 3, c0673z.extras, false);
        C0153b.m242c(parcel, 4, c0673z.lf);
        C0153b.m233a(parcel, 5, c0673z.lg, false);
        C0153b.m235a(parcel, 6, c0673z.lh);
        C0153b.m242c(parcel, 7, c0673z.tagForChildDirectedTreatment);
        C0153b.m235a(parcel, 8, c0673z.li);
        C0153b.m232a(parcel, 9, c0673z.lj, false);
        C0153b.m230a(parcel, 10, c0673z.lk, i, false);
        C0153b.m230a(parcel, 11, c0673z.ll, i, false);
        C0153b.m232a(parcel, 12, c0673z.lm, false);
        C0153b.m222D(parcel, p);
    }

    public C0673z m379a(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        am amVar = null;
        Location location = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    bundle = C0152a.m208o(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    list = C0152a.m218y(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    z2 = C0152a.m194c(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    amVar = (am) C0152a.m187a(parcel, n, am.CREATOR);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    location = (Location) C0152a.m187a(parcel, n, Location.CREATOR);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0673z(i, j, bundle, i2, list, z, i3, z2, str, amVar, location, str2);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public C0673z[] m380b(int i) {
        return new C0673z[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m379a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m380b(x0);
    }
}
