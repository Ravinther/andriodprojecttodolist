package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.wallet.i */
public class C0425i implements Creator<LineItem> {
    static void m1380a(LineItem lineItem, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, lineItem.getVersionCode());
        C0153b.m232a(parcel, 2, lineItem.description, false);
        C0153b.m232a(parcel, 3, lineItem.Yy, false);
        C0153b.m232a(parcel, 4, lineItem.Yz, false);
        C0153b.m232a(parcel, 5, lineItem.Yf, false);
        C0153b.m242c(parcel, 6, lineItem.YA);
        C0153b.m232a(parcel, 7, lineItem.Yg, false);
        C0153b.m222D(parcel, p);
    }

    public LineItem aZ(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0152a.m207o(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str5 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public LineItem[] cf(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cf(x0);
    }
}
