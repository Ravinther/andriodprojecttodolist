package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0237c.C0901c;
import com.google.android.gms.internal.C0237c.C0902d;
import com.google.android.gms.internal.C0237c.C0907i;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class ai {
    private static void m1242a(DataLayer dataLayer, C0902d c0902d) {
        for (C0911a j : c0902d.fd) {
            dataLayer.bg(di.m1345j(j));
        }
    }

    public static void m1243a(DataLayer dataLayer, C0907i c0907i) {
        if (c0907i.fT == null) {
            bh.m1269w("supplemental missing experimentSupplemental");
            return;
        }
        m1242a(dataLayer, c0907i.fT);
        m1244b(dataLayer, c0907i.fT);
        m1246c(dataLayer, c0907i.fT);
    }

    private static void m1244b(DataLayer dataLayer, C0902d c0902d) {
        for (C0911a c : c0902d.fc) {
            Map c2 = m1245c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map<String, Object> m1245c(C0911a c0911a) {
        Object o = di.m1353o(c0911a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m1269w("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void m1246c(DataLayer dataLayer, C0902d c0902d) {
        for (C0901c c0901c : c0902d.fe) {
            if (c0901c.eX == null) {
                bh.m1269w("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c0901c.eX);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c0901c.eY;
                long j2 = c0901c.eZ;
                if (!c0901c.fa || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m1269w("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.bg(c0901c.eX);
                Map b = dataLayer.m1230b(c0901c.eX, obj);
                if (c0901c.fb > 0) {
                    if (b.containsKey("gtm")) {
                        Object obj2 = b.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c0901c.fb));
                        } else {
                            bh.m1269w("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        b.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c0901c.fb)));
                    }
                }
                dataLayer.push(b);
            }
        }
    }
}
