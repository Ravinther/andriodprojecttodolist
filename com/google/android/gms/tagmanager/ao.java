package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID;
    private static final String US;
    private static final String UU;
    private static final String UY;

    static {
        ID = C0211a.HASH.toString();
        US = C0214b.ARG0.toString();
        UY = C0214b.ALGORITHM.toString();
        UU = C0214b.INPUT_FORMAT.toString();
    }

    public ao() {
        super(ID, US);
    }

    private byte[] m2255c(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean iy() {
        return true;
    }

    public C0911a m2256u(Map<String, C0911a> map) {
        C0911a c0911a = (C0911a) map.get(US);
        if (c0911a == null || c0911a == di.ku()) {
            return di.ku();
        }
        byte[] bytes;
        String j = di.m1345j(c0911a);
        c0911a = (C0911a) map.get(UY);
        String j2 = c0911a == null ? "MD5" : di.m1345j(c0911a);
        c0911a = (C0911a) map.get(UU);
        String j3 = c0911a == null ? "text" : di.m1345j(c0911a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C0398j.aX(j);
        } else {
            bh.m1266t("Hash: unknown input format: " + j3);
            return di.ku();
        }
        try {
            return di.m1356r(C0398j.m1364d(m2255c(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m1266t("Hash: unknown algorithm: " + j2);
            return di.ku();
        }
    }
}
