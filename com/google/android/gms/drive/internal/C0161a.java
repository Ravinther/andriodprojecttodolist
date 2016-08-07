package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.a */
public class C0161a implements Creator<AddEventListenerRequest> {
    static void m254a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, addEventListenerRequest.wj);
        C0153b.m230a(parcel, 2, addEventListenerRequest.CS, i, false);
        C0153b.m242c(parcel, 3, addEventListenerRequest.Dm);
        C0153b.m222D(parcel, p);
    }

    public AddEventListenerRequest m255C(Parcel parcel) {
        int i = 0;
        int o = C0152a.m207o(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    g = C0152a.m198g(parcel, n);
                    n = i3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    g = i2;
                    DriveId driveId3 = (DriveId) C0152a.m187a(parcel, n, DriveId.CREATOR);
                    n = i;
                    driveId2 = driveId3;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    n = C0152a.m198g(parcel, n);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    n = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new AddEventListenerRequest(i2, driveId, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public AddEventListenerRequest[] ah(int i) {
        return new AddEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m255C(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ah(x0);
    }
}
