package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.games.c */
public class C0197c implements Creator<PlayerEntity> {
    static void m362a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, playerEntity.getPlayerId(), false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        C0153b.m232a(parcel, 2, playerEntity.getDisplayName(), false);
        C0153b.m230a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0153b.m230a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0153b.m226a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0153b.m242c(parcel, 6, playerEntity.fl());
        C0153b.m226a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0153b.m232a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0153b.m232a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0153b.m222D(parcel, p);
    }

    public PlayerEntity[] aQ(int i) {
        return new PlayerEntity[i];
    }

    public PlayerEntity ak(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
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
                    j = C0152a.m199h(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    str4 = C0152a.m204m(parcel, n);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
