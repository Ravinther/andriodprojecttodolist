package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.List;

/* renamed from: com.google.android.gms.cast.b */
public class C0129b implements Creator<CastDevice> {
    static void m112a(CastDevice castDevice, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, castDevice.getVersionCode());
        C0153b.m232a(parcel, 2, castDevice.getDeviceId(), false);
        C0153b.m232a(parcel, 3, castDevice.wD, false);
        C0153b.m232a(parcel, 4, castDevice.getFriendlyName(), false);
        C0153b.m232a(parcel, 5, castDevice.getModelName(), false);
        C0153b.m232a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0153b.m242c(parcel, 7, castDevice.getServicePort());
        C0153b.m241b(parcel, 8, castDevice.getIcons(), false);
        C0153b.m222D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m113k(x0);
    }

    public CastDevice m113k(Parcel parcel) {
        int i = 0;
        List list = null;
        int o = C0152a.m207o(parcel);
        String str = null;
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
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    list = C0152a.m193c(parcel, n, WebImage.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CastDevice(i2, str5, str4, str3, str2, str, i, list);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m114y(x0);
    }

    public CastDevice[] m114y(int i) {
        return new CastDevice[i];
    }
}
