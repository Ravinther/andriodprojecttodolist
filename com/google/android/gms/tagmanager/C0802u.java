package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C0802u extends aj {
    private static final String ID;
    private static final String NAME;
    private static final String UC;
    private final DataLayer TN;

    static {
        ID = C0211a.CUSTOM_VAR.toString();
        NAME = C0214b.NAME.toString();
        UC = C0214b.DEFAULT_VALUE.toString();
    }

    public C0802u(DataLayer dataLayer) {
        super(ID, NAME);
        this.TN = dataLayer;
    }

    public boolean iy() {
        return false;
    }

    public C0911a m2354u(Map<String, C0911a> map) {
        Object obj = this.TN.get(di.m1345j((C0911a) map.get(NAME)));
        if (obj != null) {
            return di.m1356r(obj);
        }
        C0911a c0911a = (C0911a) map.get(UC);
        return c0911a != null ? c0911a : di.ku();
    }
}
