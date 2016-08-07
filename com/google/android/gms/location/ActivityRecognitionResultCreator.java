package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.C0152a;
import com.google.android.gms.common.internal.safeparcel.C0152a.C0151a;
import com.google.android.gms.common.internal.safeparcel.C0153b;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1111a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int p = C0153b.m244p(parcel);
        C0153b.m241b(parcel, 1, activityRecognitionResult.KP, false);
        C0153b.m242c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, activityRecognitionResult.getVersionCode());
        C0153b.m226a(parcel, 2, activityRecognitionResult.KQ);
        C0153b.m226a(parcel, 3, activityRecognitionResult.KR);
        C0153b.m222D(parcel, p);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int o = C0152a.m207o(parcel);
        int i = 0;
        List list = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0152a.m205n(parcel);
            switch (C0152a.m185S(n)) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    list = C0152a.m193c(parcel, n, DetectedActivity.CREATOR);
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    j2 = C0152a.m199h(parcel, n);
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    j = C0152a.m199h(parcel, n);
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
            return new ActivityRecognitionResult(i, list, j2, j);
        }
        throw new C0151a("Overread allowed size end=" + o, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
