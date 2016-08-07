package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class al extends bx {
    private static final String ID;

    static {
        ID = C0211a.GREATER_EQUALS.toString();
    }

    public al() {
        super(ID);
    }

    protected boolean m3133a(dh dhVar, dh dhVar2, Map<String, C0911a> map) {
        return dhVar.m1344a(dhVar2) >= 0;
    }
}
