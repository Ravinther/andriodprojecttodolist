package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.games.a */
public class C0196a implements Creator<GameEntity> {
    static void m361a(GameEntity gameEntity, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m232a(parcel, 1, gameEntity.getApplicationId(), false);
        C0153b.m232a(parcel, 2, gameEntity.getDisplayName(), false);
        C0153b.m232a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0153b.m232a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0153b.m232a(parcel, 5, gameEntity.getDescription(), false);
        C0153b.m232a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0153b.m230a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0153b.m230a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0153b.m230a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0153b.m235a(parcel, 10, gameEntity.isPlayEnabledGame());
        C0153b.m235a(parcel, 11, gameEntity.isInstanceInstalled());
        C0153b.m232a(parcel, 12, gameEntity.getInstancePackageName(), false);
        C0153b.m242c(parcel, 13, gameEntity.getGameplayAclStatus());
        C0153b.m242c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0153b.m242c(parcel, 15, gameEntity.getLeaderboardCount());
        C0153b.m235a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0153b.m235a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        C0153b.m232a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0153b.m232a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0153b.m235a(parcel, 21, gameEntity.isMuted());
        C0153b.m232a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0153b.m222D(parcel, p);
    }

    public GameEntity[] aP(int i) {
        return new GameEntity[i];
    }

    public GameEntity aj(Parcel parcel) {
        int o = C0152a.m207o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
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
                    str3 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    str4 = C0152a.m204m(parcel, n);
                    break;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    str5 = C0152a.m204m(parcel, n);
                    break;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    str6 = C0152a.m204m(parcel, n);
                    break;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    uri = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    break;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    uri2 = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    break;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    uri3 = (Uri) C0152a.m187a(parcel, n, Uri.CREATOR);
                    break;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    z = C0152a.m194c(parcel, n);
                    break;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    z2 = C0152a.m194c(parcel, n);
                    break;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    str7 = C0152a.m204m(parcel, n);
                    break;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    i2 = C0152a.m198g(parcel, n);
                    break;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    i3 = C0152a.m198g(parcel, n);
                    break;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    i4 = C0152a.m198g(parcel, n);
                    break;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    z3 = C0152a.m194c(parcel, n);
                    break;
                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                    z4 = C0152a.m194c(parcel, n);
                    break;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    str8 = C0152a.m204m(parcel, n);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = C0152a.m204m(parcel, n);
                    break;
                case 20:
                    str10 = C0152a.m204m(parcel, n);
                    break;
                case 21:
                    z5 = C0152a.m194c(parcel, n);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aP(x0);
    }
}
