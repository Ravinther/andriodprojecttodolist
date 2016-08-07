package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;

public class ac implements Creator<OnEventResponse> {
    static void m260a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m242c(parcel, 1, onEventResponse.wj);
        C0153b.m242c(parcel, 2, onEventResponse.Dm);
        C0153b.m230a(parcel, 3, onEventResponse.Eb, i, false);
        C0153b.m230a(parcel, 4, onEventResponse.Ec, i, false);
        C0153b.m222D(parcel, p);
    }

    public OnEventResponse m261Q(Parcel parcel) {
        ConflictEvent conflictEvent = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            ChangeEvent changeEvent2;
            int i3;
            ConflictEvent conflictEvent2;
            int n = C0152a.m205n(parcel);
            ConflictEvent conflictEvent3;
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = C0152a.m198g(parcel, n);
                    conflictEvent2 = conflictEvent3;
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = C0152a.m198g(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i3 = i;
                    i = i2;
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = (ChangeEvent) C0152a.m187a(parcel, n, ChangeEvent.CREATOR);
                    conflictEvent2 = conflictEvent3;
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    conflictEvent2 = (ConflictEvent) C0152a.m187a(parcel, n, ConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            conflictEvent = conflictEvent2;
        }
        if (parcel.dataPosition() == o) {
            return new OnEventResponse(i2, i, changeEvent, conflictEvent);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public OnEventResponse[] av(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m261Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return av(x0);
    }
}
