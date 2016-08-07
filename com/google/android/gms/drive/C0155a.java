package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;

/* renamed from: com.google.android.gms.drive.a */
public class C0155a implements Creator<Contents> {
    static void m245a(Contents contents, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, contents.wj);
        C0153b.m230a(parcel, 2, contents.AC, i, false);
        C0153b.m242c(parcel, 3, contents.CQ);
        C0153b.m242c(parcel, 4, contents.CR);
        C0153b.m230a(parcel, 5, contents.CS, i, false);
        C0153b.m222D(parcel, p);
    }

    public Contents[] ad(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m246y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ad(x0);
    }

    public Contents m246y(Parcel parcel) {
        DriveId driveId = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0152a.m187a(parcel, n, ParcelFileDescriptor.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    driveId = (DriveId) C0152a.m187a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }
}
