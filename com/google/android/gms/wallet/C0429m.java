package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.wallet.m */
public class C0429m implements Creator<NotifyTransactionStatusRequest> {
    static void m1384a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, notifyTransactionStatusRequest.wj);
        C0153b.m232a(parcel, 2, notifyTransactionStatusRequest.Yk, false);
        C0153b.m242c(parcel, 3, notifyTransactionStatusRequest.status);
        C0153b.m232a(parcel, 4, notifyTransactionStatusRequest.Zk, false);
        C0153b.m222D(parcel, p);
    }

    public NotifyTransactionStatusRequest bd(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public NotifyTransactionStatusRequest[] cj(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cj(x0);
    }
}
