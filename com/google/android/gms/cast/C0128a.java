package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C0128a implements Creator<ApplicationMetadata> {
    static void m109a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, applicationMetadata.getVersionCode());
        C0153b.m232a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0153b.m232a(parcel, 3, applicationMetadata.getName(), false);
        C0153b.m241b(parcel, 4, applicationMetadata.getImages(), false);
        C0153b.m233a(parcel, 5, applicationMetadata.wm, false);
        C0153b.m232a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0153b.m230a(parcel, 7, applicationMetadata.cR(), i, false);
        C0153b.m222D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m110j(x0);
    }

    public ApplicationMetadata m110j(Parcel parcel) {
        Uri uri = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    list2 = C0152a.m193c(parcel, n, WebImage.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    list = C0152a.m218y(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    uri = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m111w(x0);
    }

    public ApplicationMetadata[] m111w(int i) {
        return new ApplicationMetadata[i];
    }
}
