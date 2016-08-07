package com.google.android.gms.internal;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

public final class gq {
    public static String aW(int i) {
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
                return "PUBLIC";
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return "SOCIAL";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
