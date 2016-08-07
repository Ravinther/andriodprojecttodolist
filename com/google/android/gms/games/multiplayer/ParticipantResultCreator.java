package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m364a(ParticipantResult participantResult, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, participantResult.getParticipantId(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, participantResult.getVersionCode());
        C0153b.m242c(parcel, 2, participantResult.getResult());
        C0153b.m242c(parcel, 3, participantResult.getPlacing());
        C0153b.m222D(parcel, p);
    }

    public ParticipantResult createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0152a.m207o(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public ParticipantResult[] newArray(int size) {
        return new ParticipantResult[size];
    }
}
