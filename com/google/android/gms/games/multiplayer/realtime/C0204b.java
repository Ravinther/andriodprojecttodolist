package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.b */
public class C0204b implements Creator<RoomEntity> {
    static void m367a(RoomEntity roomEntity, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, roomEntity.getRoomId(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        C0153b.m232a(parcel, 2, roomEntity.getCreatorId(), false);
        C0153b.m226a(parcel, 3, roomEntity.getCreationTimestamp());
        C0153b.m242c(parcel, 4, roomEntity.getStatus());
        C0153b.m232a(parcel, 5, roomEntity.getDescription(), false);
        C0153b.m242c(parcel, 6, roomEntity.getVariant());
        C0153b.m227a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0153b.m241b(parcel, 8, roomEntity.getParticipants(), false);
        C0153b.m242c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0153b.m222D(parcel, p);
    }

    public RoomEntity aq(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int o = C0152a.m207o(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    bundle = C0152a.m208o(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    arrayList = C0152a.m193c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public RoomEntity[] bd(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bd(x0);
    }
}
