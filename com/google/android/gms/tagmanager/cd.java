package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

abstract class cd extends aj {
    private static final String US;
    private static final String VQ;

    static {
        US = C0214b.ARG0.toString();
        VQ = C0214b.ARG1.toString();
    }

    public cd(String str) {
        super(str, US, VQ);
    }

    protected abstract boolean m2304a(C0911a c0911a, C0911a c0911a2, Map<String, C0911a> map);

    public boolean iy() {
        return true;
    }

    public C0911a m2305u(Map<String, C0911a> map) {
        for (C0911a c0911a : map.values()) {
            if (c0911a == di.ku()) {
                return di.m1356r(Boolean.valueOf(false));
            }
        }
        C0911a c0911a2 = (C0911a) map.get(US);
        C0911a c0911a3 = (C0911a) map.get(VQ);
        boolean a = (c0911a2 == null || c0911a3 == null) ? false : m2304a(c0911a2, c0911a3, map);
        return di.m1356r(Boolean.valueOf(a));
    }
}
