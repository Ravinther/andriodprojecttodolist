package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.b */
public class C0162b implements Creator<AuthorizeAccessRequest> {
    static void m280a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, authorizeAccessRequest.wj);
        C0153b.m226a(parcel, 2, authorizeAccessRequest.Dn);
        C0153b.m230a(parcel, 3, authorizeAccessRequest.CS, i, false);
        C0153b.m222D(parcel, p);
    }

    public AuthorizeAccessRequest m281D(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    driveId = (DriveId) C0152a.m187a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public AuthorizeAccessRequest[] ai(int i) {
        return new AuthorizeAccessRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m281D(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ai(x0);
    }
}
