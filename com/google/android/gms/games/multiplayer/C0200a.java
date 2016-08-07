package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.a */
public class C0200a implements Creator<InvitationEntity> {
    static void m365a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m230a(parcel, 1, invitationEntity.getGame(), i, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        C0153b.m232a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0153b.m226a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0153b.m242c(parcel, 4, invitationEntity.getInvitationType());
        C0153b.m230a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0153b.m241b(parcel, 6, invitationEntity.getParticipants(), false);
        C0153b.m242c(parcel, 7, invitationEntity.getVariant());
        C0153b.m242c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0153b.m222D(parcel, p);
    }

    public InvitationEntity an(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int o = C0152a.m207o(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    gameEntity = (GameEntity) C0152a.m187a(parcel, n, GameEntity.CREATOR);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    participantEntity = (ParticipantEntity) C0152a.m187a(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    arrayList = C0152a.m193c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public InvitationEntity[] ba(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ba(x0);
    }
}
