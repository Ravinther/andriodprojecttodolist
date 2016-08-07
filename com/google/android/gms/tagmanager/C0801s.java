package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0211a;
import com.google.android.gms.internal.C0214b;
import com.google.android.gms.internal.C0247d.C0911a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C0801s extends aj {
    private static final String ID;
    private static final String TF;
    private static final String Up;
    private final C0406a Uq;

    /* renamed from: com.google.android.gms.tagmanager.s.a */
    public interface C0406a {
        Object m1368b(String str, Map<String, Object> map);
    }

    static {
        ID = C0211a.FUNCTION_CALL.toString();
        Up = C0214b.FUNCTION_CALL_NAME.toString();
        TF = C0214b.ADDITIONAL_PARAMS.toString();
    }

    public C0801s(C0406a c0406a) {
        super(ID, Up);
        this.Uq = c0406a;
    }

    public boolean iy() {
        return false;
    }

    public C0911a m2353u(Map<String, C0911a> map) {
        String j = di.m1345j((C0911a) map.get(Up));
        Map hashMap = new HashMap();
        C0911a c0911a = (C0911a) map.get(TF);
        if (c0911a != null) {
            Object o = di.m1353o(c0911a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m1269w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return di.ku();
            }
        }
        try {
            return di.m1356r(this.Uq.m1368b(j, hashMap));
        } catch (Exception e) {
            bh.m1269w("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return di.ku();
        }
    }
}
