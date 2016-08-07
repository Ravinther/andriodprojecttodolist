package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

abstract class dd extends cd {
    public dd(String str) {
        super(str);
    }

    protected boolean m2888a(C0911a c0911a, C0911a c0911a2, Map<String, C0911a> map) {
        String j = di.m1345j(c0911a);
        String j2 = di.m1345j(c0911a2);
        return (j == di.kt() || j2 == di.kt()) ? false : m2889a(j, j2, (Map) map);
    }

    protected abstract boolean m2889a(String str, String str2, Map<String, C0911a> map);
}
