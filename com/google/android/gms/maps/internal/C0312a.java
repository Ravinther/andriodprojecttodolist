package com.google.android.gms.maps.internal;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.mobeta.android.dslv.DragSortController;

/* renamed from: com.google.android.gms.maps.internal.a */
public final class C0312a {
    public static Boolean m1118a(byte b) {
        switch (b) {
            case DragSortController.ON_DOWN /*0*/:
                return Boolean.FALSE;
            case Value.TYPE_FIELD_NUMBER /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte m1119c(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
