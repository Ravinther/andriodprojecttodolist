package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.z */
public class C0177z implements Creator<OnContentsResponse> {
    static void m327a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, onContentsResponse.wj);
        C0153b.m230a(parcel, 2, onContentsResponse.CW, i, false);
        C0153b.m222D(parcel, p);
    }

    public OnContentsResponse m328N(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    contents = (Contents) C0152a.m187a(parcel, n, Contents.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnContentsResponse(i, contents);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public OnContentsResponse[] as(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m328N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return as(x0);
    }
}
