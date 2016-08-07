package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.maps.internal.p */
public final class C0327p {
    private C0327p() {
    }

    public static void m1134a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(C0327p.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(C0327p.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
