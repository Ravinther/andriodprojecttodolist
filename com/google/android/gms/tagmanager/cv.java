package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class cv extends aj {
    private static final String ID;

    static {
        ID = C0211a.SDK_VERSION.toString();
    }

    public cv() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2315u(Map<String, C0911a> map) {
        return di.m1356r(Integer.valueOf(VERSION.SDK_INT));
    }
}
