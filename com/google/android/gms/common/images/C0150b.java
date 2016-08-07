package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.common.images.b */
public class C0150b implements Creator<WebImage> {
    static void m181a(WebImage webImage, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, webImage.getVersionCode());
        C0153b.m230a(parcel, 2, webImage.getUrl(), i, false);
        C0153b.m242c(parcel, 3, webImage.getWidth());
        C0153b.m242c(parcel, 4, webImage.getHeight());
        C0153b.m222D(parcel, p);
    }

    public WebImage[] m182M(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m183l(x0);
    }

    public WebImage m183l(Parcel parcel) {
        int i = 0;
        int o = C0152a.m207o(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            Uri uri2;
            int g;
            int n = C0152a.m205n(parcel);
            int i4;
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = C0152a.m198g(parcel, n);
                    n = i4;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    n = i;
                    i = i4;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = C0152a.m198g(parcel, n);
                    n = i4;
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    n = C0152a.m198g(parcel, n);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    n = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m182M(x0);
    }
}
