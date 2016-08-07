package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.Map;

class cf extends aj {
    private static final String ID;
    private static final String Wa;
    private static final String Wb;

    static {
        ID = C0211a.RANDOM.toString();
        Wa = C0214b.MIN.toString();
        Wb = C0214b.MAX.toString();
    }

    public cf() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return false;
    }

    public C0911a m2306u(Map<String, C0911a> map) {
        double doubleValue;
        double d;
        C0911a c0911a = (C0911a) map.get(Wa);
        C0911a c0911a2 = (C0911a) map.get(Wb);
        if (!(c0911a == null || c0911a == di.ku() || c0911a2 == null || c0911a2 == di.ku())) {
            dh k = di.m1346k(c0911a);
            dh k2 = di.m1346k(c0911a2);
            if (!(k == di.ks() || k2 == di.ks())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return di.m1356r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return di.m1356r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
