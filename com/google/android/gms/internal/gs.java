package com.google.android.gms.internal;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;

public final class gs {
    public static String aW(int i) {
        switch (i) {
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return "GIFT";
            case Value.STRING_FIELD_NUMBER /*2*/:
                return "WISH";
            default:
                fz.m777h("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
