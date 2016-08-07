package com.google.android.gms.internal;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

public final class gt {
    public static boolean isValid(int outcome) {
        switch (outcome) {
            case DragSortController.ON_DOWN /*0*/:
            case Value.TYPE_FIELD_NUMBER /*1*/:
            case Value.STRING_FIELD_NUMBER /*2*/:
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                return true;
            default:
                return false;
        }
    }
}
