package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class ac implements Creator<ab> {
    static void m381a(ab abVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, abVar.versionCode);
        C0153b.m232a(parcel, 2, abVar.ln, false);
        C0153b.m242c(parcel, 3, abVar.height);
        C0153b.m242c(parcel, 4, abVar.heightPixels);
        C0153b.m235a(parcel, 5, abVar.lo);
        C0153b.m242c(parcel, 6, abVar.width);
        C0153b.m242c(parcel, 7, abVar.widthPixels);
        C0153b.m237a(parcel, 8, abVar.lp, i, false);
        C0153b.m222D(parcel, p);
    }

    public ab m382b(Parcel parcel) {
        ab[] abVarArr = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i5 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i4 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    abVarArr = (ab[]) C0152a.m192b(parcel, n, ab.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ab(i5, str, i4, i3, z, i2, i, abVarArr);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public ab[] m383c(int i) {
        return new ab[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m382b(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m383c(x0);
    }
}
