package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m370a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m230a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameRequestEntity.getVersionCode());
        C0153b.m230a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C0153b.m236a(parcel, 3, gameRequestEntity.getData(), false);
        C0153b.m232a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0153b.m241b(parcel, 5, gameRequestEntity.fU(), false);
        C0153b.m242c(parcel, 7, gameRequestEntity.getType());
        C0153b.m226a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0153b.m226a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0153b.m227a(parcel, 11, gameRequestEntity.gf(), false);
        C0153b.m222D(parcel, p);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    gameEntity = (GameEntity) C0152a.m187a(parcel, n, GameEntity.CREATOR);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    playerEntity = (PlayerEntity) C0152a.m187a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    bArr = C0152a.m209p(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    arrayList = C0152a.m193c(parcel, n, PlayerEntity.CREATOR);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    bundle = C0152a.m208o(parcel, n);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
