package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class ah extends aj {
    private static final String ID;
    private final ct TO;

    static {
        ID = C0211a.EVENT.toString();
    }

    public ah(ct ctVar) {
        super(ID, new String[0]);
        this.TO = ctVar;
    }

    public boolean iy() {
        return false;
    }

    public C0911a m2253u(Map<String, C0911a> map) {
        String jY = this.TO.jY();
        return jY == null ? di.ku() : di.m1356r(jY);
    }
}
