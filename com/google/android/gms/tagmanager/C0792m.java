package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C0792m extends aj {
    private static final String ID;
    private static final String VALUE;

    static {
        ID = C0211a.CONSTANT.toString();
        VALUE = C0214b.VALUE.toString();
    }

    public C0792m() {
        super(ID, VALUE);
    }

    public static String iB() {
        return ID;
    }

    public static String iC() {
        return VALUE;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2340u(Map<String, C0911a> map) {
        return (C0911a) map.get(VALUE);
    }
}
