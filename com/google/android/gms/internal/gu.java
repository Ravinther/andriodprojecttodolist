package com.google.android.gms.internal;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

public final class gu {
    public static String aW(int i) {
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
                return "DAILY";
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return "WEEKLY";
            case Value.STRING_FIELD_NUMBER /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
