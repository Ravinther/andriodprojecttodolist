package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.q */
class C1068q extends dd {
    private static final String ID;

    static {
        ID = C0211a.CONTAINS.toString();
    }

    public C1068q() {
        super(ID);
    }

    protected boolean m3139a(String str, String str2, Map<String, C0911a> map) {
        return str.contains(str2);
    }
}
