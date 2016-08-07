package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m369a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m230a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C0153b.m232a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0153b.m232a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0153b.m226a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0153b.m232a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0153b.m226a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0153b.m232a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0153b.m242c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0153b.m242c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0153b.m242c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0153b.m236a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0153b.m241b(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0153b.m232a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0153b.m236a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0153b.m227a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0153b.m242c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, turnBasedMatchEntity.getVersionCode());
        C0153b.m235a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0153b.m242c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0153b.m232a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0153b.m232a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0153b.m222D(parcel, p);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
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
                    str2 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    i4 = C0152a.m198g(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    bArr = C0152a.m209p(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    arrayList = C0152a.m193c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    str5 = C0152a.m204m(parcel, n);
                    break;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    bArr2 = C0152a.m209p(parcel, n);
                    break;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    i5 = C0152a.m198g(parcel, n);
                    break;
                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                    bundle = C0152a.m208o(parcel, n);
                    break;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    i6 = C0152a.m198g(parcel, n);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case 20:
                    str6 = C0152a.m204m(parcel, n);
                    break;
                case 21:
                    str7 = C0152a.m204m(parcel, n);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
