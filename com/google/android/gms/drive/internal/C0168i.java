package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.i */
public class C0168i implements Creator<CreateFolderRequest> {
    static void m292a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, createFolderRequest.wj);
        C0153b.m230a(parcel, 2, createFolderRequest.Dt, i, false);
        C0153b.m230a(parcel, 3, createFolderRequest.Ds, i, false);
        C0153b.m222D(parcel, p);
    }

    public CreateFolderRequest m293J(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = C0152a.m198g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    g = i;
                    DriveId driveId3 = (DriveId) C0152a.m187a(parcel, n, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    metadataBundle2 = (MetadataBundle) C0152a.m187a(parcel, n, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CreateFolderRequest[] ao(int i) {
        return new CreateFolderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m293J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ao(x0);
    }
}
