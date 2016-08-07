package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

public class ae implements Creator<OnListParentsResponse> {
    static void m264a(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, onListParentsResponse.wj);
        C0153b.m230a(parcel, 2, onListParentsResponse.Ee, i, false);
        C0153b.m222D(parcel, p);
    }

    public OnListParentsResponse m265S(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    dataHolder = (DataHolder) C0152a.m187a(parcel, n, DataHolder.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public OnListParentsResponse[] ax(int i) {
        return new OnListParentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m265S(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ax(x0);
    }
}
