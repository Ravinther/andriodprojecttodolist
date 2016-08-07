package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class dc extends dd {
    private static final String ID;

    static {
        ID = C0211a.STARTS_WITH.toString();
    }

    public dc() {
        super(ID);
    }

    protected boolean m3138a(String str, String str2, Map<String, C0911a> map) {
        return str.startsWith(str2);
    }
}
