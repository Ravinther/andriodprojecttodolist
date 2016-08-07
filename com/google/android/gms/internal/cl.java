package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class cl {
    private int mOrientation;
    private String oC;
    private String oD;
    private String oE;
    private List<String> oF;
    private List<String> oG;
    private long oH;
    private boolean oI;
    private final long oJ;
    private List<String> oK;
    private long oL;

    public cl() {
        this.oH = -1;
        this.oI = false;
        this.oJ = -1;
        this.oL = -1;
        this.mOrientation = -1;
    }

    private static long m492a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                da.m566w("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    private static List<String> m493b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m494e(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Ad-Size");
        if (list != null && !list.isEmpty()) {
            this.oC = (String) list.get(0);
        }
    }

    private void m495f(Map<String, List<String>> map) {
        List b = m493b(map, "X-Afma-Click-Tracking-Urls");
        if (b != null) {
            this.oF = b;
        }
    }

    private void m496g(Map<String, List<String>> map) {
        List b = m493b(map, "X-Afma-Tracking-Urls");
        if (b != null) {
            this.oG = b;
        }
    }

    private void m497h(Map<String, List<String>> map) {
        long a = m492a(map, "X-Afma-Interstitial-Timeout");
        if (a != -1) {
            this.oH = a;
        }
    }

    private void m498i(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.oI = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m499j(Map<String, List<String>> map) {
        List b = m493b(map, "X-Afma-Manual-Tracking-Urls");
        if (b != null) {
            this.oK = b;
        }
    }

    private void m500k(Map<String, List<String>> map) {
        long a = m492a(map, "X-Afma-Refresh-Rate");
        if (a != -1) {
            this.oL = a;
        }
    }

    private void m501l(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = cv.aU();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = cv.aT();
            }
        }
    }

    public void m502a(String str, Map<String, List<String>> map, String str2) {
        this.oD = str;
        this.oE = str2;
        m503d(map);
    }

    public void m503d(Map<String, List<String>> map) {
        m494e(map);
        m495f((Map) map);
        m496g(map);
        m497h(map);
        m498i(map);
        m499j(map);
        m500k(map);
        m501l(map);
    }

    public cf m504f(long j) {
        return new cf(this.oD, this.oE, this.oF, this.oG, this.oH, this.oI, -1, this.oK, this.oL, this.mOrientation, this.oC, j);
    }
}
