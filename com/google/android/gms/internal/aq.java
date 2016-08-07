package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.android.gms.cast.Cast;
import java.util.HashMap;
import java.util.Map;

public final class aq {
    public static final ar lW;
    public static final ar lX;
    public static final ar lY;
    public static final ar lZ;
    public static final ar ma;
    public static final ar mb;
    public static final ar mc;
    public static final ar md;
    public static final ar me;

    /* renamed from: com.google.android.gms.internal.aq.1 */
    static class C05741 implements ar {
        C05741() {
        }

        public void m1662a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (str == null) {
                da.m566w("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = ddVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), Cast.MAX_MESSAGE_LENGTH) != null));
            }
            ddVar.m575a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.2 */
    static class C05752 implements ar {
        C05752() {
        }

        public void m1663a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                da.m566w("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C0296l bc = ddVar.bc();
                if (bc != null && bc.m1077a(parse)) {
                    a = bc.m1075a(parse, ddVar.getContext());
                    new cy(ddVar.getContext(), ddVar.bd().pU, a.toString()).start();
                }
            } catch (C0297m e) {
                da.m566w("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new cy(ddVar.getContext(), ddVar.bd().pU, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.3 */
    static class C05763 implements ar {
        C05763() {
        }

        public void m1664a(dd ddVar, Map<String, String> map) {
            bo ba = ddVar.ba();
            if (ba == null) {
                da.m566w("A GMSG tried to close something that wasn't an overlay.");
            } else {
                ba.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.4 */
    static class C05774 implements ar {
        C05774() {
        }

        public void m1665a(dd ddVar, Map<String, String> map) {
            bo ba = ddVar.ba();
            if (ba == null) {
                da.m566w("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                ba.m2493g("1".equals(map.get("custom_close")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.5 */
    static class C05785 implements ar {
        C05785() {
        }

        public void m1666a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                da.m566w("URL missing from httpTrack GMSG.");
            } else {
                new cy(ddVar.getContext(), ddVar.bd().pU, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.6 */
    static class C05796 implements ar {
        C05796() {
        }

        public void m1667a(dd ddVar, Map<String, String> map) {
            da.m564u("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.7 */
    static class C05807 implements ar {
        C05807() {
        }

        public void m1668a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C0296l bc = ddVar.bc();
                if (bc != null) {
                    bc.m1078y().m946a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                da.m566w("Could not parse touch parameters from gmsg.");
            }
        }
    }

    static {
        lW = new C05741();
        lX = new C05752();
        lY = new C05763();
        lZ = new C05774();
        ma = new C05785();
        mb = new C05796();
        mc = new as();
        md = new C05807();
        me = new at();
    }
}
