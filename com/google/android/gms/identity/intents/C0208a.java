package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0208a implements Creator<UserAddressRequest> {
    static void m375a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, userAddressRequest.getVersionCode());
        C0153b.m241b(parcel, 2, userAddressRequest.Ky, false);
        C0153b.m222D(parcel, p);
    }

    public UserAddressRequest ar(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    list = C0152a.m193c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddressRequest(i, list);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public UserAddressRequest[] be(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ar(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}
