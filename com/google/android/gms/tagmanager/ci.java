package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ci extends dd {
    private static final String ID;
    private static final String We;

    static {
        ID = C0211a.REGEX.toString();
        We = C0214b.IGNORE_CASE.toString();
    }

    public ci() {
        super(ID);
    }

    protected boolean m3137a(String str, String str2, Map<String, C0911a> map) {
        try {
            return Pattern.compile(str2, di.m1351n((C0911a) map.get(We)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
