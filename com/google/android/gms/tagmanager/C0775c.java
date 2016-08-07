package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C0775c extends aj {
    private static final String ID;
    private final C0369a TC;

    static {
        ID = C0211a.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public C0775c(Context context) {
        this(C0369a.m1238E(context));
    }

    C0775c(C0369a c0369a) {
        super(ID, new String[0]);
        this.TC = c0369a;
    }

    public boolean iy() {
        return false;
    }

    public C0911a m2284u(Map<String, C0911a> map) {
        return di.m1356r(Boolean.valueOf(this.TC.isLimitAdTrackingEnabled()));
    }
}
