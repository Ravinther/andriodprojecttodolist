package com.google.android.gms.location;

import android.os.Parcel;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ep;
import com.mobeta.android.dslv.DragSortController;

/* renamed from: com.google.android.gms.location.b */
public class C0676b implements SafeParcelable {
    public static final C0310c CREATOR;
    int Lh;
    int Li;
    long Lj;
    private final int wj;

    static {
        CREATOR = new C0310c();
    }

    C0676b(int i, int i2, int i3, long j) {
        this.wj = i;
        this.Lh = i2;
        this.Li = i3;
        this.Lj = j;
    }

    private String bk(int i) {
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
                return "STATUS_SUCCESSFUL";
            case Value.STRING_FIELD_NUMBER /*2*/:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return "STATUS_NO_INFO_IN_DATABASE";
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                return "STATUS_INVALID_SCAN";
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case Value.INTEGER_FIELD_NUMBER /*8*/:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C0676b)) {
            return false;
        }
        C0676b c0676b = (C0676b) other;
        return this.Lh == c0676b.Lh && this.Li == c0676b.Li && this.Lj == c0676b.Lj;
    }

    int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return ep.hashCode(Integer.valueOf(this.Lh), Integer.valueOf(this.Li), Long.valueOf(this.Lj));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(bk(this.Lh));
        stringBuilder.append(", wifi status: ").append(bk(this.Li));
        stringBuilder.append(", elapsed realtime ns: ").append(this.Lj);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0310c.m1114a(this, parcel, flags);
    }
}
