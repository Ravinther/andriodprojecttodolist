package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C0773b extends aj {
    private static final String ID;
    private final C0369a TC;

    static {
        ID = C0211a.ADVERTISER_ID.toString();
    }

    public C0773b(Context context) {
        this(C0369a.m1238E(context));
    }

    C0773b(C0369a c0369a) {
        super(ID, new String[0]);
        this.TC = c0369a;
    }

    public boolean iy() {
        return false;
    }

    public C0911a m2273u(Map<String, C0911a> map) {
        String iu = this.TC.iu();
        return iu == null ? di.ku() : di.m1356r(iu);
    }
}
