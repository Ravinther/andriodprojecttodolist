package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.drive.d */
public class C0157d implements Creator<DriveId> {
    static void m247a(DriveId driveId, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, driveId.wj);
        C0153b.m232a(parcel, 2, driveId.Dc, false);
        C0153b.m226a(parcel, 3, driveId.Dd);
        C0153b.m226a(parcel, 4, driveId.De);
        C0153b.m222D(parcel, p);
    }

    public DriveId[] ae(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m248z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ae(x0);
    }

    public DriveId m248z(Parcel parcel) {
        long j = 0;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
