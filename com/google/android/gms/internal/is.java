package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.internal.ir.C0947a;
import com.google.android.gms.internal.ir.C0950b;
import com.google.android.gms.internal.ir.C0951c;
import com.google.android.gms.internal.ir.C0952d;
import com.google.android.gms.internal.ir.C0953f;
import com.google.android.gms.internal.ir.C0954g;
import com.google.android.gms.internal.ir.C0955h;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class is implements Creator<ir> {
    static void m988a(ir irVar, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        Set hB = irVar.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0153b.m242c(parcel, 1, irVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0153b.m232a(parcel, 2, irVar.getAboutMe(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0153b.m230a(parcel, 3, irVar.hW(), i, true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0153b.m232a(parcel, 4, irVar.getBirthday(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0153b.m232a(parcel, 5, irVar.getBraggingRights(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0153b.m242c(parcel, 6, irVar.getCircledByCount());
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0153b.m230a(parcel, 7, irVar.hX(), i, true);
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0153b.m232a(parcel, 8, irVar.getCurrentLocation(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0153b.m232a(parcel, 9, irVar.getDisplayName(), true);
        }
        if (hB.contains(Integer.valueOf(12))) {
            C0153b.m242c(parcel, 12, irVar.getGender());
        }
        if (hB.contains(Integer.valueOf(14))) {
            C0153b.m232a(parcel, 14, irVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(15))) {
            C0153b.m230a(parcel, 15, irVar.hY(), i, true);
        }
        if (hB.contains(Integer.valueOf(16))) {
            C0153b.m235a(parcel, 16, irVar.isPlusUser());
        }
        if (hB.contains(Integer.valueOf(19))) {
            C0153b.m230a(parcel, 19, irVar.hZ(), i, true);
        }
        if (hB.contains(Integer.valueOf(18))) {
            C0153b.m232a(parcel, 18, irVar.getLanguage(), true);
        }
        if (hB.contains(Integer.valueOf(21))) {
            C0153b.m242c(parcel, 21, irVar.getObjectType());
        }
        if (hB.contains(Integer.valueOf(20))) {
            C0153b.m232a(parcel, 20, irVar.getNickname(), true);
        }
        if (hB.contains(Integer.valueOf(23))) {
            C0153b.m241b(parcel, 23, irVar.ib(), true);
        }
        if (hB.contains(Integer.valueOf(22))) {
            C0153b.m241b(parcel, 22, irVar.ia(), true);
        }
        if (hB.contains(Integer.valueOf(25))) {
            C0153b.m242c(parcel, 25, irVar.getRelationshipStatus());
        }
        if (hB.contains(Integer.valueOf(24))) {
            C0153b.m242c(parcel, 24, irVar.getPlusOneCount());
        }
        if (hB.contains(Integer.valueOf(27))) {
            C0153b.m232a(parcel, 27, irVar.getUrl(), true);
        }
        if (hB.contains(Integer.valueOf(26))) {
            C0153b.m232a(parcel, 26, irVar.getTagline(), true);
        }
        if (hB.contains(Integer.valueOf(29))) {
            C0153b.m235a(parcel, 29, irVar.isVerified());
        }
        if (hB.contains(Integer.valueOf(28))) {
            C0153b.m241b(parcel, 28, irVar.ic(), true);
        }
        C0153b.m222D(parcel, p);
    }

    public ir aI(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C0947a c0947a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C0950b c0950b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C0951c c0951c = null;
        boolean z = false;
        String str7 = null;
        C0952d c0952d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    C0947a c0947a2 = (C0947a) C0152a.m187a(parcel, n, C0947a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0947a = c0947a2;
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str2 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str3 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i2 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    C0950b c0950b2 = (C0950b) C0152a.m187a(parcel, n, C0950b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c0950b = c0950b2;
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str4 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    str5 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    i3 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    str6 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    C0951c c0951c2 = (C0951c) C0152a.m187a(parcel, n, C0951c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c0951c = c0951c2;
                    break;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    z = C0152a.m194c(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    str7 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    C0952d c0952d2 = (C0952d) C0152a.m187a(parcel, n, C0952d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c0952d = c0952d2;
                    break;
                case 20:
                    str8 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = C0152a.m193c(parcel, n, C0953f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = C0152a.m193c(parcel, n, C0954g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = C0152a.m198g(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C0152a.m204m(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = C0152a.m193c(parcel, n, C0955h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C0152a.m194c(parcel, n);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ir(hashSet, i, str, c0947a, str2, str3, i2, c0950b, str4, str5, i3, str6, c0951c, z, str7, c0952d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public ir[] bF(int i) {
        return new ir[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bF(x0);
    }
}
