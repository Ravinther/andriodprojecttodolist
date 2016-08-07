package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

abstract class bx extends cd {
    public bx(String str) {
        super(str);
    }

    protected boolean m2877a(C0911a c0911a, C0911a c0911a2, Map<String, C0911a> map) {
        dh k = di.m1346k(c0911a);
        dh k2 = di.m1346k(c0911a2);
        return (k == di.ks() || k2 == di.ks()) ? false : m2878a(k, k2, (Map) map);
    }

    protected abstract boolean m2878a(dh dhVar, dh dhVar2, Map<String, C0911a> map);
}
