package com.google.android.gms.internal;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

public final class gv {
    public static String aW(int i) {
        switch (i) {
            case DragSortController.ON_DOWN /*0*/:
                return "TURN_STATUS_INVITED";
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return "TURN_STATUS_MY_TURN";
            case Value.STRING_FIELD_NUMBER /*2*/:
                return "TURN_STATUS_THEIR_TURN";
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return "TURN_STATUS_COMPLETE";
            default:
                fz.m777h("MatchTurnStatus", "Unknown match turn status: " + i);
                return "TURN_STATUS_UNKNOWN";
        }
    }
}
