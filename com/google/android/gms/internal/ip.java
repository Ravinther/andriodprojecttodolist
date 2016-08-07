package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.HashSet;
import java.util.Set;

public class ip implements Creator<io> {
    static void m987a(io ioVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = ioVar.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, ioVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m232a(parcel, 2, ioVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0153b.m230a(parcel, 4, ioVar.hS(), i, true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0153b.m232a(parcel, 5, ioVar.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0153b.m230a(parcel, 6, ioVar.hT(), i, true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0153b.m232a(parcel, 7, ioVar.getType(), true);
        }
        C0153b.m222D(parcel, p);
    }

    public io aH(Parcel parcel) {
        String str = null;
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        im imVar = null;
        String str2 = null;
        im imVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            im imVar3;
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str3 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    imVar3 = (im) C0152a.m187a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    imVar2 = imVar3;
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str2 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    imVar3 = (im) C0152a.m187a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    imVar = imVar3;
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new io(hashSet, i, str3, imVar2, str2, imVar, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public io[] bE(int i) {
        return new io[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
