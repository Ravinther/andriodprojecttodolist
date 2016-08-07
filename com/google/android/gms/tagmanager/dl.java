package com.google.android.gms.tagmanager;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.internal.C0247d.C0911a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dl {
    private static by<C0911a> m1360a(by<C0911a> byVar) {
        try {
            return new by(di.m1356r(bO(di.m1345j((C0911a) byVar.getObject()))), byVar.jr());
        } catch (Throwable e) {
            bh.m1264c("Escape URI: unsupported encoding", e);
            return byVar;
        }
    }

    private static by<C0911a> m1361a(by<C0911a> byVar, int i) {
        if (m1363q((C0911a) byVar.getObject())) {
            switch (i) {
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    return m1360a(byVar);
                default:
                    bh.m1266t("Unsupported Value Escaping: " + i);
                    return byVar;
            }
        }
        bh.m1266t("Escaping can only be applied to strings.");
        return byVar;
    }

    static by<C0911a> m1362a(by<C0911a> byVar, int... iArr) {
        by a;
        for (int a2 : iArr) {
            a = m1361a(a, a2);
        }
        return a;
    }

    static String bO(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m1363q(C0911a c0911a) {
        return di.m1353o(c0911a) instanceof String;
    }
}
