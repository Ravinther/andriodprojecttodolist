package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class bz extends aj {
    private static final String ID;

    static {
        ID = C0211a.OS_VERSION.toString();
    }

    public bz() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2283u(Map<String, C0911a> map) {
        return di.m1356r(VERSION.RELEASE);
    }
}
