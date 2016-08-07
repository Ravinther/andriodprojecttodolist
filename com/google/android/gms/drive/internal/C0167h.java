package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.h */
public class C0167h implements Creator<CreateFileRequest> {
    static void m290a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, createFileRequest.wj);
        C0153b.m230a(parcel, 2, createFileRequest.Dt, i, false);
        C0153b.m230a(parcel, 3, createFileRequest.Ds, i, false);
        C0153b.m230a(parcel, 4, createFileRequest.Dq, i, false);
        C0153b.m222D(parcel, p);
    }

    public CreateFileRequest m291I(Parcel parcel) {
        Contents contents = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            MetadataBundle metadataBundle2;
            DriveId driveId2;
            int g;
            Contents contents2;
            int n = C0152a.m205n(parcel);
            Contents contents3;
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    contents3 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = C0152a.m198g(parcel, n);
                    contents2 = contents3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    g = i;
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = (DriveId) C0152a.m187a(parcel, n, DriveId.CREATOR);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle3;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    driveId2 = driveId;
                    g = i;
                    contents3 = contents;
                    metadataBundle2 = (MetadataBundle) C0152a.m187a(parcel, n, MetadataBundle.CREATOR);
                    contents2 = contents3;
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    contents2 = (Contents) C0152a.m187a(parcel, n, Contents.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
            contents = contents2;
        }
        if (parcel.dataPosition() == o) {
            return new CreateFileRequest(i, driveId, metadataBundle, contents);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public CreateFileRequest[] an(int i) {
        return new CreateFileRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m291I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return an(x0);
    }
}
