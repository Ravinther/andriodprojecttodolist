package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.games.multiplayer.c */
public class C0201c implements Creator<ParticipantEntity> {
    static void m366a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, participantEntity.getParticipantId(), false);
        C0153b.m232a(parcel, 2, participantEntity.getDisplayName(), false);
        C0153b.m230a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C0153b.m230a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C0153b.m242c(parcel, 5, participantEntity.getStatus());
        C0153b.m232a(parcel, 6, participantEntity.ge(), false);
        C0153b.m235a(parcel, 7, participantEntity.isConnectedToRoom());
        C0153b.m230a(parcel, 8, participantEntity.getPlayer(), i, false);
        C0153b.m242c(parcel, 9, participantEntity.getCapabilities());
        C0153b.m230a(parcel, 10, participantEntity.getResult(), i, false);
        C0153b.m232a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0153b.m232a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        C0153b.m222D(parcel, p);
    }

    public ParticipantEntity ao(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    uri = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    uri2 = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    playerEntity = (PlayerEntity) C0152a.m187a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    participantResult = (ParticipantResult) C0152a.m187a(parcel, n, ParticipantResult.CREATOR);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    str5 = C0152a.m204m(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0152a.m198g(parcel, n);
                    break;
                default:
                    C0152a.m191b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public ParticipantEntity[] bb(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ao(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bb(x0);
    }
}
