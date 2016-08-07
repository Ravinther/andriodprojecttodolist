package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class ac extends aj {
    private static final String ID;
    private static final String US;
    private static final String UT;
    private static final String UU;
    private static final String UV;

    static {
        ID = C0211a.ENCODE.toString();
        US = C0214b.ARG0.toString();
        UT = C0214b.NO_PADDING.toString();
        UU = C0214b.INPUT_FORMAT.toString();
        UV = C0214b.OUTPUT_FORMAT.toString();
    }

    public ac() {
        super(ID, US);
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2252u(Map<String, C0911a> map) {
        C0911a c0911a = (C0911a) map.get(US);
        if (c0911a == null || c0911a == di.ku()) {
            return di.ku();
        }
        String j = di.m1345j(c0911a);
        c0911a = (C0911a) map.get(UU);
        String j2 = c0911a == null ? "text" : di.m1345j(c0911a);
        c0911a = (C0911a) map.get(UV);
        String j3 = c0911a == null ? "base16" : di.m1345j(c0911a);
        c0911a = (C0911a) map.get(UT);
        int i = (c0911a == null || !di.m1351n(c0911a).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C0398j.aX(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m1266t("Encode: unknown input format: " + j2);
                return di.ku();
            }
            if ("base16".equals(j3)) {
                d = C0398j.m1364d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m1266t("Encode: unknown output format: " + j3);
                return di.ku();
            }
            return di.m1356r(d);
        } catch (IllegalArgumentException e) {
            bh.m1266t("Encode: invalid input:");
            return di.ku();
        }
    }
}
