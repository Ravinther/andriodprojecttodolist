package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C0983w extends dg {
    private static final String ID;
    private static final String UN;
    private static final String VALUE;
    private final DataLayer TN;

    static {
        ID = C0211a.DATA_LAYER_WRITE.toString();
        VALUE = C0214b.VALUE.toString();
        UN = C0214b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    }

    public C0983w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.TN = dataLayer;
    }

    private void m2916a(C0911a c0911a) {
        if (c0911a != null && c0911a != di.ko()) {
            String j = di.m1345j(c0911a);
            if (j != di.kt()) {
                this.TN.bg(j);
            }
        }
    }

    private void m2917b(C0911a c0911a) {
        if (c0911a != null && c0911a != di.ko()) {
            Object o = di.m1353o(c0911a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.TN.push((Map) o2);
                    }
                }
            }
        }
    }

    public void m2918w(Map<String, C0911a> map) {
        m2917b((C0911a) map.get(VALUE));
        m2916a((C0911a) map.get(UN));
    }
}
