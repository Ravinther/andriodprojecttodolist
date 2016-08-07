package com.google.android.gms.internal;

import java.util.Map;

public final class as implements ar {
    private static boolean m1669a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m1670b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return cv.aU();
            }
            if ("l".equalsIgnoreCase(str)) {
                return cv.aT();
            }
        }
        return -1;
    }

    public void m1671a(dd ddVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            da.m566w("Action missing from an open GMSG.");
            return;
        }
        de bb = ddVar.bb();
        if ("expand".equalsIgnoreCase(str)) {
            if (ddVar.be()) {
                da.m566w("Cannot expand WebView that is already expanded.");
            } else {
                bb.m585a(m1669a(map), m1670b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            str = (String) map.get("u");
            if (str != null) {
                bb.m586a(m1669a(map), m1670b(map), str);
            } else {
                bb.m587a(m1669a(map), m1670b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else {
            bb.m581a(new bn((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
