package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C0800p extends aj {
    private static final String ID;
    private final String Un;

    static {
        ID = C0211a.CONTAINER_VERSION.toString();
    }

    public C0800p(String str) {
        super(ID, new String[0]);
        this.Un = str;
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2352u(Map<String, C0911a> map) {
        return this.Un == null ? di.ku() : di.m1356r(this.Un);
    }
}
