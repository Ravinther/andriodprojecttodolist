package com.google.android.gms.internal;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

public final class gr {
    public static boolean isValid(int result) {
        switch (result) {
            case DragSortController.ON_DOWN /*0*/:
            case Value.TYPE_FIELD_NUMBER /*1*/:
            case Value.STRING_FIELD_NUMBER /*2*/:
            case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
            case Value.MAP_KEY_FIELD_NUMBER /*4*/:
            case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                return true;
            default:
                return false;
        }
    }
}
