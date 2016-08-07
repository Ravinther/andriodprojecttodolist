package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.g */
public class C0166g implements Creator<CreateFileIntentSenderRequest> {
    static void m288a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, createFileIntentSenderRequest.wj);
        C0153b.m230a(parcel, 2, createFileIntentSenderRequest.Ds, i, false);
        C0153b.m242c(parcel, 3, createFileIntentSenderRequest.CQ);
        C0153b.m232a(parcel, 4, createFileIntentSenderRequest.CX, false);
        C0153b.m230a(parcel, 5, createFileIntentSenderRequest.CY, i, false);
        C0153b.m222D(parcel, p);
    }

    public CreateFileIntentSenderRequest m289H(Parcel parcel) {
        int i = 0;
        DriveId driveId = null;
        int o = C0152a.m207o(parcel);
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    metadataBundle = (MetadataBundle) C0152a.m187a(parcel, n, MetadataBundle.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str = C0152a.m204m(parcel, n);
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
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CreateFileIntentSenderRequest[] am(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m289H(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return am(x0);
    }
}
