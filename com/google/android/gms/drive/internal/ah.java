package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.DriveId;

public class ah implements Creator<OpenFileIntentSenderRequest> {
    static void m270a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, openFileIntentSenderRequest.wj);
        C0153b.m232a(parcel, 2, openFileIntentSenderRequest.CX, false);
        C0153b.m238a(parcel, 3, openFileIntentSenderRequest.Dk, false);
        C0153b.m230a(parcel, 4, openFileIntentSenderRequest.CY, i, false);
        C0153b.m222D(parcel, p);
    }

    public OpenFileIntentSenderRequest m271V(Parcel parcel) {
        DriveId driveId = null;
        int o = C0152a.m207o(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
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
                    strArr = C0152a.m217x(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    driveId = (DriveId) C0152a.m187a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public OpenFileIntentSenderRequest[] aA(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m271V(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
