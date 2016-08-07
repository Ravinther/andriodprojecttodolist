package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class bp implements Creator<bq> {
    static void m450a(bq bqVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, bqVar.versionCode);
        C0153b.m230a(parcel, 2, bqVar.nr, i, false);
        C0153b.m228a(parcel, 3, bqVar.at(), false);
        C0153b.m228a(parcel, 4, bqVar.au(), false);
        C0153b.m228a(parcel, 5, bqVar.av(), false);
        C0153b.m228a(parcel, 6, bqVar.aw(), false);
        C0153b.m232a(parcel, 7, bqVar.nw, false);
        C0153b.m235a(parcel, 8, bqVar.nx);
        C0153b.m232a(parcel, 9, bqVar.ny, false);
        C0153b.m228a(parcel, 10, bqVar.ax(), false);
        C0153b.m242c(parcel, 11, bqVar.orientation);
        C0153b.m242c(parcel, 12, bqVar.nA);
        C0153b.m232a(parcel, 13, bqVar.mZ, false);
        C0153b.m230a(parcel, 14, bqVar.kN, i, false);
        C0153b.m222D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m451e(x0);
    }

    public bq m451e(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        bn bnVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        db dbVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    bnVar = (bn) C0152a.m187a(parcel, n, bn.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    iBinder = C0152a.m206n(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    iBinder2 = C0152a.m206n(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    iBinder3 = C0152a.m206n(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    iBinder4 = C0152a.m206n(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    iBinder5 = C0152a.m206n(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    dbVar = (db) C0152a.m187a(parcel, n, db.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new bq(i, bnVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, dbVar);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public bq[] m452j(int i) {
        return new bq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m452j(x0);
    }
}
