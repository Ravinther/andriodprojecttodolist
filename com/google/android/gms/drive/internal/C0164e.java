package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0164e implements Creator<CloseContentsRequest> {
    static void m284a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, closeContentsRequest.wj);
        C0153b.m230a(parcel, 2, closeContentsRequest.Dq, i, false);
        C0153b.m231a(parcel, 3, closeContentsRequest.Dr, false);
        C0153b.m222D(parcel, p);
    }

    public CloseContentsRequest m285F(Parcel parcel) {
        Boolean bool = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            Contents contents2;
            int g;
            Boolean bool2;
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = C0152a.m198g(parcel, n);
                    bool2 = bool3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    g = i;
                    Contents contents3 = (Contents) C0152a.m187a(parcel, n, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    bool2 = C0152a.m195d(parcel, n);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == o) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CloseContentsRequest[] ak(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m285F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ak(x0);
    }
}
